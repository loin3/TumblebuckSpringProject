package com.tumblebuck.web.dto;

import com.tumblebuck.domain.project.Project;
import com.tumblebuck.domain.project.Tag;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ProjectResponseDto {
    private Long id;
    private String content;
    private LocalDate endDate;
    private Long goalFunding;
    private String email;
    private String title;
    private String picture;
    private Long currentFunding;
    private Float percentage;
    private Tag tag;

    public ProjectResponseDto(Project entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.endDate = entity.getEndDate();
        this.goalFunding = entity.getGoalFunding();
        this.currentFunding = entity.getCurrentFunding();
        this.percentage = entity.getPercentage();
        this.email = entity.getEmail();
        this.picture = entity.getPicture();
        this.tag = entity.getTag();
    }
}
