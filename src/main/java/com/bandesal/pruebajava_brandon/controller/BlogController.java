package com.bandesal.pruebajava_brandon.controller;

import com.bandesal.pruebajava_brandon.entity.Blog;
import com.bandesal.pruebajava_brandon.entity.Reader;
import com.bandesal.pruebajava_brandon.repository.BlogRepository;
import com.bandesal.pruebajava_brandon.repository.ReaderRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private ReaderRepository readerRepository;

    @GetMapping("/blogs")
    public String listBlogs(Model model) {
        model.addAttribute("blogs", blogRepository.findAll());
        model.addAttribute("blog", new Blog());
        return "blogs";
    }

    @PostMapping("/blogs/save")
    public String saveBlog(@Valid @ModelAttribute("blog") Blog blog, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("blogs", blogRepository.findAll());
            return "blogs";
        }
        blogRepository.save(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/blogs/edit/{id}")
    public String editBlog(@PathVariable Long id, Model model) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("blog", blog);
        model.addAttribute("blogs", blogRepository.findAll());
        return "blogs";
    }

    @GetMapping("/blogs/delete/{id}")
    public String deleteBlog(@PathVariable Long id) {
        blogRepository.deleteById(id);
        return "redirect:/blogs";
    }

    @GetMapping("/blogs-readers")
    public String listBlogsReaders(Model model) {
        model.addAttribute("blogs", blogRepository.findAll());
        model.addAttribute("allReaders", readerRepository.findAll());
        return "blogs-readers";
    }

    @PostMapping("/blogs-readers/save")
    public String saveBlogReaders(@RequestParam Long blogId, @RequestParam(required = false) List<Long> readerIds) {
        Blog blog = blogRepository.findById(blogId)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + blogId));
        if (readerIds != null) {
            List<Reader> readers = readerRepository.findAllById(readerIds);
            blog.setReaders(new HashSet<>(readers));
        } else {
            blog.getReaders().clear();
        }
        blogRepository.save(blog);
        return "redirect:/blogs-readers";
    }
}