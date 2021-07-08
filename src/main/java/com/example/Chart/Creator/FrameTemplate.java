package com.example.Chart.Creator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;


@Controller
public class FrameTemplate {
//    @Autowired
//    private HttpServletRequest request;
//
//    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//    String loggedUser=request.getUserPrincipal().getName();

    @Autowired
    private PostService postService;

    @Autowired
    private CheckedService checkedService;

    @Autowired
    private CheckedRepository checkedRepository;

    @Autowired
    private CustomUserDetailsService userService;


    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/home")
    public String getHome(Model model) {
        List<Post> listPost = postService.getAllPosts();
        model.addAttribute("listPosts", listPost);
        return "home";
    }

    @GetMapping(value="/post_detail/{id}")
    public String viewPost(@PathVariable("id") Long id,
                           Model model,
                           @AuthenticationPrincipal CustomUserDetails userDetails){
        Post post = postService.getPost(id).get();
        model.addAttribute("post", post);
        List<Checked> listCheckedUser = checkedService.getAllUsersJoined();
        model.addAttribute("listCheckedUser", listCheckedUser);

        User user = userDetails.getUser(userDetails.getUsername());

        for (Checked names: listCheckedUser) {
            if(user.getUserName().equals(names.getName())&& post == names.post){
                return "post_detail_edit";
            }
        }
        return "post_detail";
    }

//    @RequestMapping(value="/edit_success", method= RequestMethod.POST)
//    public String saveChecked(@PathParam(value = "id") Long id,
//                              @AuthenticationPrincipal CustomUserDetails userDetails
//                              ,@ModelAttribute("checked") Checked checked,
//                              Model model){
//        Checked oldcheck = checkedService.get(checked.getId());
//        System.out.println(oldcheck);
//        List<Checked> listCheckedUser = checkedService.getAllUsersJoined();
//        model.addAttribute("listCheckedUser", listCheckedUser);
//        User user = userDetails.getUser(userDetails.getUsername());
//
//
//
//        for (Checked userCheck: listCheckedUser) {
//            if (user.getUserName().equals(userCheck.getName())){
//                oldcheck.setName(userCheck.getName());
//                oldcheck.setCheck1(checked.check1);
//            }
//        }
//        checkedService.save(oldcheck);
//
//
//        return "redirect:/home";
//    }

    @RequestMapping(value="/edit_success", method= RequestMethod.POST)
    public String saveChecked(Checked newCheck){
       Optional<Checked> oldCheckOptional = checkedRepository.findByPostId(newCheck.getPostId());
       if (oldCheckOptional.isPresent()) {
           Checked oldCheck = oldCheckOptional.get();
           oldCheck.setCheck1(newCheck.isCheck1());
           checkedService.save(oldCheck);
       }

       return "redirect:/home";
    }




    @GetMapping("/posts")
    public List<Post> posts(){
        return postService.getAllPosts();
    }

    @RequestMapping(value="/post_success", method= RequestMethod.POST)
    public String savePost(@AuthenticationPrincipal CustomUserDetails userDetails , @ModelAttribute("post") Post post){
        post.setCreator(userDetails.getUser(userDetails.getUsername()));
        postService.insert(post);

        return "redirect:/home";
    }

    @RequestMapping(value="/join_success", method= RequestMethod.POST)
    public String joinTable(@AuthenticationPrincipal CustomUserDetails userDetails ,
                            @ModelAttribute("checked") Checked checked,
                            @PathParam(value = "postId") Long postId){

        Optional<Post> possiblePost = postService.getPost(postId);
        Post post;

        if (possiblePost.isPresent()) {
            post = postService.getPost(postId).get();
            checked.setPost(post);
            checked.setUser(userDetails.getUser(userDetails.getUsername()));
            checked.setJoined(true);
            checked.setName(userDetails.getUsername());

            checkedService.save(checked);
        }

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

        userService.save(user);

        return "register_success";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userService.getAllUsers();
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
