package com.sparta.sparta_personalproject.BlogController;

import com.sparta.sparta_personalproject.BlogDto.BlogRequestDto;
import com.sparta.sparta_personalproject.BlogDto.BlogResponseDto;
import com.sparta.sparta_personalproject.BlogEntity.Blog;
import com.sparta.sparta_personalproject.BlogService.BlogService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class blogController {

    private final BlogService blogService;

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    //전체 조회 구현 완료 ㅠㅠ
    @GetMapping("/blogs")
    public List<Blog> getBlogs() {
        return blogService.getBlogs();
    }

    // 게시글 작성 ( 12/15 )
    @PostMapping("/blog")
    public BlogResponseDto createBlog(@RequestBody BlogRequestDto blogRequestDto, HttpServletRequest request){
        // 응답 보내기
        return blogService.createBlog(blogRequestDto,request);
    }

    //선택 게시글 조회해주는 코드 (미완성)
    @GetMapping("/api/blog/{id}")
    public List<Blog> getSelectBlog(@PathVariable Long id, @RequestBody BlogRequestDto blogRequestDto){
        return blogService.selectBlog(id);
    }

    //게시글 수정 (12/15)
    @PutMapping("/api/blog/{id}")
    private Long updateBlog(@PathVariable Long id , @RequestBody BlogRequestDto blogRequestDto, HttpServletRequest request){
        // 응답 보내기
        return blogService.updateBlog(id,blogRequestDto, request);
    }

    // 게시글 삭제 (구현 완료.. 아마도) ( 12/ 15 )
    @DeleteMapping("/api/blog/{id}")
    private Long deleteBlog(@PathVariable Long id , HttpServletRequest request){
       return blogService.deleteBlog(id,request);
    }

}
