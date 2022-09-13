package com.alik.demo.controllers;

import com.alik.demo.models.Post;
import com.alik.demo.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {
    @Autowired
    private PostRepo postRepo;

    @GetMapping("/blog")
    public String blogMain (Model model){
        Iterable<Post> posts = postRepo.findAll();
        model.addAttribute("posts", posts);
        return "blog_main";
    }
    @GetMapping("/blog/add")
    public String blogAdd (Model model){

        return "blog_add";
    }
    @PostMapping("/blog/add")
    public String blogPostAdd (@RequestParam String title,
                               @RequestParam String onons,
                               @RequestParam String full_text,Model model){
        Post post = new Post(title, onons, full_text);
        postRepo.save(post);
        return "redirect:/blog";
    }

}
