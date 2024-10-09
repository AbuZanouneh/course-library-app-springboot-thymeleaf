package com.ats.courselibrary.controller;

import com.ats.courselibrary.entity.Author;
import com.ats.courselibrary.entity.Publisher;
import com.ats.courselibrary.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/publishers")
    public String findAllPublishers(Model model){
        List<Publisher> publishers = publisherService.findAllPublishers();
        model.addAttribute("publishers", publishers);
        return "publishers";
    }

    @GetMapping("/add-publisher")
    public String showCreatePublisher(Publisher publisher){
        return "add-publisher";
    }

    @PostMapping("/save-publisher")
    public String createPublisher(Publisher publisher, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-publisher";
        }
        publisherService.createPublisher(publisher);
        model.addAttribute("publishers", publisherService.findAllPublishers());
        return "redirect:/publishers";
    }

    @GetMapping("/remove-publisher/{publisherId}")
    public String deletePublisher(@PathVariable Long publisherId, Model model){
        publisherService.deletePublisher(publisherId);
        model.addAttribute("publishers", publisherService.findAllPublishers());
        return "publishers";
    }

    @GetMapping("update-publisher/{publisherId}")
    public String updatePublisher(@PathVariable Long publisherId, Model model){
        model.addAttribute("publisher", publisherService.findPublisherById(publisherId));
        return "update-publisher";
    }

    @PostMapping("/update-publisher/{publisherId}")
    public String saveUpdatePublisher(@PathVariable Long publisherId, Publisher publisher, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors())
            return "update-publisher";
        publisherService.updatePublisher(publisher);
        model.addAttribute("publishers", publisherService.findAllPublishers());
        return "redirect:/publishers";
    }

}


