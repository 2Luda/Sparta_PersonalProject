package com.sparta.sparta_personalproject.BlogRepository;

import com.sparta.sparta_personalproject.BlogEntity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface blogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findAllByOrderByModifiedAtDesc();

    Optional<Blog> findByIdAndUserId(Long id, Long userId);

}
