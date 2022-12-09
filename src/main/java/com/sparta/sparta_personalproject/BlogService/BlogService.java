package com.sparta.sparta_personalproject.BlogService;

import com.sparta.sparta_personalproject.BlogDto.BlogRequestDto;
import com.sparta.sparta_personalproject.BlogEntity.Blog;
import com.sparta.sparta_personalproject.BlogRepository.blogRepository;
import com.sparta.sparta_personalproject.Exception.NotIDException;
import com.sparta.sparta_personalproject.Exception.NotPasswordException;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final blogRepository blogrepository;

    // 전체 조회
    @Transactional(readOnly = true)
    public List<Blog> getBlogs() {
        return blogrepository.findAllByOrderByModifiedAtDesc();
    }

    // 게시글 생성
    @Transactional
    public Blog createBlog(BlogRequestDto blogRequestDto) {
        Blog blog = new Blog(blogRequestDto);
        blogrepository.save(blog);
        return blog;
    }

    // 게시글 수정
    @Transactional
    public Long update(Long id, BlogRequestDto blogRequestDto , String password) {
        try {
            Blog blog = blogrepository.findById(id).orElseThrow(
                    () -> new NotIDException("아이디가 올바르지 않습니다.")
            );
            if(!blog.checkPassword(password))
                throw new NotPasswordException("비밀번호가 올바르지 않습니다.");
            blog.update(blogRequestDto);
            return blog.getId();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1L;
        }
    }


     //게시글 삭제
    @Transactional
    public Long deleteBlog(Long id, String password) {
        blogrepository.deleteById(id);
        return id;
    }

    public Long selectBlog(Long id) {
        Blog blog = blogrepository.findById(id).orElseThrow(
                () -> new IllegalIdentifierException("아이디가 존재하지 않습니다")
        );
            return blog.getId();
    }
}
