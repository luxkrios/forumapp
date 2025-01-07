package com.example.forumapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.forumapp.model.Post;
import com.example.forumapp.service.ForumService;

@Controller
@RequestMapping("/forum")
public class ForumController {

    
    @Autowired
    private ForumService forumService;

    @GetMapping
    public String showForumPage(Model model) {
        model.addAttribute("posts", forumService.getAllPosts());
        return "forum";
    }

    @GetMapping("/create")
    public String showCreatePostPage(Model model) {
        model.addAttribute("post", new Post());
        return "create";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute Post post) {
        forumService.createPost(post);
        return "redirect:/forum";
    }
}
