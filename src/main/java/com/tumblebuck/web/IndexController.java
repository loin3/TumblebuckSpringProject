package com.tumblebuck.web;

import com.tumblebuck.config.auth.dto.SessionUser;
import com.tumblebuck.service.funding.FundingService;
import com.tumblebuck.service.posts.PostsService;
import com.tumblebuck.service.project.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;
    private final ProjectService projectService;
    private final FundingService fundingService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("hotProject", projectService.findHotProject());
        //model.addAttribute("impendingProject", projectService.findImpendingProject());
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("name", user.getName());
            model.addAttribute("userEmail", user.getEmail());
        }
        return "main";
    }

    @GetMapping("/")
    public String showMainPage(Model model){
        model.addAttribute("hotProject", projectService.findHotProject());
        //model.addAttribute("impendingProject", projectService.findImpendingProject());
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("name", user.getName());
            model.addAttribute("userEmail", user.getEmail());
        }
        return "main";
    }

//    @GetMapping("/posts/save")
//    public String postsSave(){
//        return "posts-save";
//    }

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



    @GetMapping("/all")
    public String showAllProject(@RequestParam String tag, Model model){
        if(tag.equals("all")){
            model.addAttribute("project", projectService.findAllDesc());
        }else{
            model.addAttribute("project", projectService.findAllByTagDesc(tag));
        }
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("name", user.getName());
            model.addAttribute("userEmail", user.getEmail());
        }
        return "project-all";
    }

//    @GetMapping("/posts/update/{id}")
//    public String postsUpdate(@PathVariable Long id, Model model){
//        PostsResponseDto dto = postsService.findById(id);
//        model.addAttribute("post", dto);
//        return "posts-update";
//    }

    @GetMapping("/project/post")
    public String showProjectPost(Model model){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("name", user.getName());
            model.addAttribute("userEmail", user.getEmail());
        }
        return "project-post";
    }

    @GetMapping("/project/detail")
    public String showProjectDetail(@RequestParam String id, Model model){
        model.addAttribute("project", projectService.findById(Long.parseLong(id)));
        model.addAttribute("donate", projectService.countDonateById(Long.parseLong(id)));
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("name", user.getName());
            model.addAttribute("userEmail", user.getEmail());
        }
        return "project-detail";
    }

    @GetMapping("/project/funding")
    public String showProjectFunding(@RequestParam("id") Long id, @RequestParam("title") String title, Model model){
        model.addAttribute("title", title);
        model.addAttribute("id", id);
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("name", user.getName());
            model.addAttribute("userEmail", user.getEmail());
        }
        return "project-funding";
    }

    @GetMapping("/project/v1/myFunded")
    public String showProjectMyFunded(Model model){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("name", user.getName());
            model.addAttribute("userEmail", user.getEmail());
            model.addAttribute("project", projectService.findMyFundedByEmail(user.getEmail()));
        }

        return "project-myFunded";
    }

    @GetMapping("project/v1/mine/manage")
    public String showFundingMyFunded(@RequestParam("id") Long id, @RequestParam("arrange") int arrange,Model model){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("name", user.getName());
            model.addAttribute("userEmail", user.getEmail());

            model.addAttribute("id", id);
        }
        if(arrange == 2){
            model.addAttribute("funding", fundingService.findMyFundedByIdMost(id));
        }else{
            model.addAttribute("funding", fundingService.findMyFundedByIdDesc(id));
        }


        return "funding-myFunded";
    }

    @GetMapping("project/v1/mine")
    public String showProjectMine(Model model){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("name", user.getName());
            model.addAttribute("userEmail", user.getEmail());
            model.addAttribute("project", projectService.findMineByEmail(user.getEmail()));
        }

        return "project-mine";
    }
}
