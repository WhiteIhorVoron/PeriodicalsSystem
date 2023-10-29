package com.voron.controllers;

import com.voron.models.Publication;
import com.voron.services.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PublicationController {
    @Autowired
    private PublicationService publicationService;

    @GetMapping("/publications")
    public String getAllPublications(Model model) {
        model.addAttribute("publications", publicationService.getAll());
        return "publication-list";
    }

    @GetMapping("/publications/{id}")
    public String publicationInfo (@PathVariable("id") Long id,Model model){
        model.addAttribute("publication",publicationService.getById(id));
        return "publication-info";
    }

    @PostMapping("/publications/create")
    public String createPublication(@ModelAttribute Publication publication) {
        publicationService.save(publication);
        return "redirect:/publications";
    }

    @PostMapping("/publication/{id}/edit")
    public String showEditPublicationForm(@PathVariable("id") Long id, Model model) {
        Publication publication = publicationService.getById(id);
        model.addAttribute("publication", publication);
        return "publication-edit-form";
    }


    @PostMapping("/publication/{id}/delete")
    public String deletePublication(@PathVariable("id") Long id) {
        publicationService.delete(id);
        return "redirect:/publications";
    }
}
