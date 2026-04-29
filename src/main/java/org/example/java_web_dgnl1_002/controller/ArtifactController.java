package org.example.java_web_dgnl1_002.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.java_web_dgnl1_002.model.Artifact;
import org.example.java_web_dgnl1_002.service.ArtifactService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class ArtifactController {

    private final ArtifactService service;

    @GetMapping
    public String list(
            @RequestParam(required = false) String keyword,
            @RequestParam(defaultValue = "0") int page,
            Model model
    ){
        Pageable pageable = PageRequest.of(page, 5);
        Page<Artifact> artifactPage = service.getAll(keyword, pageable);
        model.addAttribute("list", artifactPage.getContent());
        model.addAttribute("keyword", keyword);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", artifactPage.getTotalPages());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("artifact", new Artifact());
        return "form";
    }

    @PostMapping("/save")
    public String save(
            @Valid @ModelAttribute Artifact artifact,
            BindingResult result
    ){
        if (result.hasErrors()){
            return "form";
        }
        service.save(artifact);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable Long id,
            Model model
    ){
        model.addAttribute("artifact", service.findById(id));
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable Long id
    ){
        service.delete(id);
        return "redirect:/";
    }
}
