package com.sparta.sparta_personalproject.BlogController;

import com.sparta.sparta_personalproject.BlogDto.BlogRequestDto;
import com.sparta.sparta_personalproject.BlogEntity.Blog;
import com.sparta.sparta_personalproject.BlogService.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class blogController {

    private final BlogService blogService;

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    //전체 조회 구현 완료 ㅠㅠ
    @GetMapping("/api/blogs")
    public List<Blog> getBlogs() {
        return blogService.getBlogs();
    }

    // 게시글 작성 아마 post? 구현 완료 ㅠㅠ
    @PostMapping("/api/blogs")
    public Blog createBlog(@RequestBody BlogRequestDto blogRequestDto) {
        return blogService.createBlog(blogRequestDto);
    }

    //선택 게시글 조회해주는 코드 (미완성)
    @GetMapping("/api/blogs/{id}")
    public Long getSelectBlog(@PathVariable Long id){
        return blogService.selectBlog(id);
    }

    //게시글 수정 비밀번호를 어케하지.. 구현 안됨..ㅠㅠ
    @PutMapping("/api/blogs/{id}")
    private Long updateBlog(@PathVariable Long id , @RequestBody BlogRequestDto blogRequestDto){
        return blogService.update(id,blogRequestDto, blogRequestDto.getPassword());
    }

    // 게시글 삭제
    @DeleteMapping("/api/blogs/{id}")
    private Long deleteBlog(@PathVariable Long id , @RequestBody BlogRequestDto blogRequestDto){
        return blogService.deleteBlog(id, blogRequestDto.getPassword());
    }

}
