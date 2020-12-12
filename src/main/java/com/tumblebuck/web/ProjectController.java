package com.tumblebuck.web;

import com.tumblebuck.domain.project.ProjectRepository;
import com.tumblebuck.web.dto.ProjectSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProjectController {
    private final ProjectRepository projectRepository;



    @PostMapping("/api/v2/save")
    public Long save(@RequestBody ProjectSaveRequestDto requestDto){ return projectRepository.save(requestDto.toEntity()).getId();}
}
