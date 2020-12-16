package com.tumblebuck.web;

import com.tumblebuck.config.auth.dto.SessionUser;
import com.tumblebuck.domain.funding.FundingRepository;
import com.tumblebuck.domain.project.ProjectRepository;
import com.tumblebuck.domain.project.Tag;
import com.tumblebuck.web.dto.FundRequestDto;
import com.tumblebuck.web.dto.ProjectSaveRequestDto;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
public class ProjectController {
    private final ProjectRepository projectRepository;
    private final HttpSession httpSession;
    private final FundingRepository fundingRepository;


    @PostMapping("/api/v2/save")
    public Long save(@RequestBody ProjectSaveRequestDto requestDto){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        String email = user.getEmail();
        return projectRepository.save(requestDto.toEntity(email)).getId();
    }

    @PostMapping("/api/v2/funding")
    public Long fund(@RequestBody FundRequestDto requestDto){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        String email = user.getEmail();
        return fundingRepository.save(requestDto.toEntity(email)).getId();
    }
}
