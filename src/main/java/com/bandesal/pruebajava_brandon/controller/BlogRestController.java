package com.bandesal.pruebajava_brandon.controller;

import com.bandesal.pruebajava_brandon.entity.Blog;
import com.bandesal.pruebajava_brandon.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class BlogRestController {

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping
    public List<Blog> getBlogs(@RequestParam(required = false) String title) {
        if (title != null && !title.trim().isEmpty()) {
            return blogRepository.findByTitleContainingIgnoreCase(title);
        }
        return blogRepository.findAll();
    }
}