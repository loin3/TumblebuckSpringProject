package com.tumblebuck.service.project;

import com.tumblebuck.domain.project.Project;
import com.tumblebuck.domain.project.ProjectRepository;
import com.tumblebuck.web.dto.ProjectListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    @Transactional(readOnly = true)
    public List<ProjectListResponseDto> findHotProject(){
        return projectRepository.findHotProject().stream()
                .map(ProjectListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProjectListResponseDto> findImpendingProject(){
        return projectRepository.findImpendingProject().stream()
                .map(ProjectListResponseDto::new)
                .collect(Collectors.toList());
    }
}
