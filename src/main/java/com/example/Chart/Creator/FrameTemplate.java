package com.example.Chart.Creator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@Controller
public class FrameTemplate {
    @Autowired
    private PostService postService;

    @Autowired
    private UserRepository userRepo;
    private CustomUserDetailsService userService;


    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/home")
    public String getHome() {
        return "home.html";
    }

    @GetMapping("/posts")
    public List<Post> posts(){
        return postService.getAllPosts();
    }

    @RequestMapping(value="/post_success", method= RequestMethod.POST)
    public String savePost(@ModelAttribute("post") Post post){
        if(post.getDateCreated() == null){
            post.setDateCreated(new Date());
        }
       postService.insert(post);

        return "redirect:/home";
    }

    @GetMapping("/post")
    public String publishPost(Model model) {
        model.addAttribute("post", new Post());
        return "post";
    }
//    @GetMapping(value="/the_post/{id}")
//    public Post getPostById(@PathVariable Long id){
//        return postService.getPost(id);
//    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    @PostMapping("/register_success")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);

        return "register_success";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

//    @GetMapping("/home")
//    public String listPosts(Model model) {
//        List<User> listPosts = userRepo.findAll();
//        model.addAttribute("listPosts", listPosts);
//
//        return "posts";
//    }

//    @GetMapping("/post")
//    public String showPostForm(Model model) {
//        model.addAttribute("post", new Post());
//        return "post";
//    }




}
