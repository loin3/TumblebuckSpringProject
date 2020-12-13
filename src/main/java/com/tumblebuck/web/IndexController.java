package com.tumblebuck.web;

import com.tumblebuck.config.auth.dto.SessionUser;
import com.tumblebuck.service.posts.PostsService;
import com.tumblebuck.service.project.ProjectService;
import com.tumblebuck.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;
    private final ProjectService projectService;

    @GetMapping
    public String index(){
        return "main";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

//    @GetMapping("/")
//    public String index(Model model){
//        model.addAttribute("posts", postsService.findAllDesc());
//        SessionUser user = (SessionUser) httpSession.getAttribute("user");
//        if (user != null) {
//            model.addAttribute("name", user.getName());
//            model.addAttribute("userEmail", user.getEmail());
//        }
//        return "index";
//    }

    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("hotProject", projectService.findHotProject());
        //model.addAttribute("impendingProject", projectService.findImpendingProject());
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("name", user.getName());
            model.addAttribute("userEmail", user.getEmail());
        }
        return "main";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }

    @GetMapping("/project/post")
    public String projectPost(){
        return "project-post";
    }
}
