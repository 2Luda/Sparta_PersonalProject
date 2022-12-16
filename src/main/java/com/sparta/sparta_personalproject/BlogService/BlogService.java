package com.sparta.sparta_personalproject.BlogService;

import com.sparta.sparta_personalproject.BlogDto.BlogRequestDto;
import com.sparta.sparta_personalproject.BlogDto.BlogResponseDto;
import com.sparta.sparta_personalproject.BlogDto.LoginRequestDto;
import com.sparta.sparta_personalproject.BlogEntity.Blog;
import com.sparta.sparta_personalproject.BlogEntity.User;
import com.sparta.sparta_personalproject.BlogRepository.UserRepository;
import com.sparta.sparta_personalproject.BlogRepository.blogRepository;
import com.sparta.sparta_personalproject.Exception.NotIDException;
import com.sparta.sparta_personalproject.Exception.NotPasswordException;
import com.sparta.sparta_personalproject.Jwt.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

   //private final LoginRequestDto loginRequestDto;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final blogRepository blogrepository;

    // 전체 조회
    @Transactional(readOnly = true)
    public List<Blog> getBlogs() {
        return blogrepository.findAllByOrderByModifiedAtDesc();
    }

    // 게시글 생성
    @Transactional
    public BlogResponseDto createBlog(BlogRequestDto blogRequestDto, HttpServletRequest request) {
        // Request 에서 토큰 가져오기
        String token = jwtUtil.resolveToken(request);
        Claims claims;

        // 토큰이 있는 경우에만 게시글 생성 가능
        if (token != null) {
            if (jwtUtil.validateToken(token)) {
                // 토큰에서 사용자 정보 가져오기
                claims = jwtUtil.getUserInfoFromToken(token);
            } else {
                throw new IllegalArgumentException("Token Error");
            }
            // 토큰에서 가져온 사용자 정보를 사용하여 DB 조회
                User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                  () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
         );
                Blog blog = blogrepository.saveAndFlush(new Blog(blogRequestDto,user.getId()));

                return new BlogResponseDto(blog);
        } else {
            return null;
        }
    }

    // 게시글 수정 ( 12/15 )
    @Transactional
    public Long updateBlog(Long id, BlogRequestDto blogRequestDto, HttpServletRequest request) {
        // Request에서 Token 가져오기
        String token = jwtUtil.resolveToken(request);
        Claims claims;
//        String password = loginRequestDto.getPassword();
//       String username = loginRequestDto.getUsername();

        // 토큰이 있는 경우에만 블로그 수정 가능
        if (token != null) {
            // Token 검증
            if (jwtUtil.validateToken(token)) {
                // 토큰에서 사용자 정보 가져오기
                claims = jwtUtil.getUserInfoFromToken(token);
            } else {
                throw new IllegalArgumentException("Token Error");
            }

            // 토큰에서 가져온 사용자 정보를 사용하여 DB 조회
            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
            );

            Blog blog = blogrepository.findByIdAndUserId(id, user.getId()).orElseThrow(
                    () -> new IllegalArgumentException("사용자가 일치하지 않습니다.")
            );
            // 비밀번호 획인
//            if (!user.getPassword().equals(password))
//                throw new IllegalArgumentException("비밀번호가 올바르지 않습니다.");

            blog.update(blogRequestDto);
            return blog.getId();

        } else {
            return null;
        }
    }

    //게시글 삭제 ( 12/15 )
    @Transactional
    public Long deleteBlog(Long id, HttpServletRequest request) {
        // Request에서 Token 가져오기 , 비밀번호도 필요하니 password도 가져오거
        String token = jwtUtil.resolveToken(request);
        Claims claims;
//        String password = loginRequestDto.getPassword();

        // Token이 있을 경우에만 게시글 삭제 가능
        if (token != null) {
            // Token 검증
            if (jwtUtil.validateToken(token)) {
                // 토큰에서 사용자 정보 가져오기
                claims = jwtUtil.getUserInfoFromToken(token);
            } else {
                throw new IllegalArgumentException("Token Error");
            }

            // 토큰에서 가져온 사용자 정보를 사용하여 DB 조회
            User user= userRepository.findByUsername(claims.getSubject()).orElseThrow(
                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
            );
            Blog blog =  blogrepository.findByIdAndUserId(id , user.getId()).orElseThrow(
                    () -> new IllegalArgumentException("사용자가 일치하지 않습니다")
            );
//             if (!user.getPassword().equals(password))
//                 throw new IllegalArgumentException("비밀번호가 일치하지 않습니다");
             blogrepository.deleteById(id);
             return id;
        } else {
            return null;
        }
    }

    // api/blogs/1 을 입력하면 게시글 정보, 내용, 글 작성자가 나와야한다.
    public List<Blog> selectBlog(Long id) {
        blogrepository.findById(id).orElseThrow(
                () -> new IllegalIdentifierException("아이디가 올바르지 않습니다.")
        );
        return getBlogs();

    }
}


