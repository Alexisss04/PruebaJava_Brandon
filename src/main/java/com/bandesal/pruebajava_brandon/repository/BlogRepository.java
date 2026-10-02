package com.bandesal.pruebajava_brandon.repository;

import com.bandesal.pruebajava_brandon.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findByTitleContainingIgnoreCase(String title);
}