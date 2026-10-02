package com.bandesal.pruebajava_brandon.controller;

import com.bandesal.pruebajava_brandon.entity.Reader;
import com.bandesal.pruebajava_brandon.repository.ReaderRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/readers")
public class ReaderController {

    @Autowired
    private ReaderRepository readerRepository;

    @GetMapping
    public String listReaders(Model model) {
        model.addAttribute("readers", readerRepository.findAll());
        model.addAttribute("reader", new Reader());
        return "readers";
    }

    @PostMapping("/save")
    public String saveReader(@Valid @ModelAttribute("reader") Reader reader, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("readers", readerRepository.findAll());
            return "readers";
        }
        readerRepository.save(reader);
        return "redirect:/readers";
    }

    @GetMapping("/edit/{id}")
    public String editReader(@PathVariable Long id, Model model) {
        Reader reader = readerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("reader", reader);
        model.addAttribute("readers", readerRepository.findAll());
        return "readers";
    }

    @GetMapping("/delete/{id}")
    public String deleteReader(@PathVariable Long id) {
        readerRepository.deleteById(id);
        return "redirect:/readers";
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Retorna la vista login.html de templates
    }
}