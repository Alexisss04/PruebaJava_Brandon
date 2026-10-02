package com.bandesal.pruebajava_brandon.repository;

import com.bandesal.pruebajava_brandon.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
    List<Reader> findByNameContainingIgnoreCase(String name);
}