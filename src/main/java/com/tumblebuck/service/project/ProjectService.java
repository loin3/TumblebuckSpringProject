package com.tumblebuck.service.project;

import com.tumblebuck.domain.funding.FundingRepository;
import com.tumblebuck.domain.project.Project;
import com.tumblebuck.domain.project.ProjectRepository;
import com.tumblebuck.web.dto.FundResponseDto;
import com.tumblebuck.web.dto.ProjectListResponseDto;
import com.tumblebuck.web.dto.ProjectResponseDto;
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

    @Transactional(readOnly = true)
    public List<ProjectListResponseDto> findAllDesc(){
        return projectRepository.findAllDesc().stream()
                .map(ProjectListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProjectResponseDto findById(Long id){
        Project entity = projectRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시물이 없습니다. id=" + id));
        return new ProjectResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public Long countDonateById(Long id){
        return projectRepository.countDonateById(id);
    }

    @Transactional(readOnly = true)
    public List<ProjectListResponseDto> findMineByEmail(String email){
        return projectRepository.findByEmail(email).stream()
                .map(ProjectListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProjectListResponseDto> findMyFundedByEmail(String email){
        return projectRepository.findFundedByEmail(email).stream()
                .map(ProjectListResponseDto::new)
                .collect(Collectors.toList());
    }

}
