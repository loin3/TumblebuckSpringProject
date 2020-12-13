package com.tumblebuck.web.dto;

import com.tumblebuck.domain.project.Project;
import lombok.Getter;

@Getter
public class ProjectListResponseDto {
    private Long id;
    private String title;
    private String picture;
    private Long currentFunding;
    private Float percentage;

    public ProjectListResponseDto(Project entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.picture = entity.getPicture();
        this.currentFunding = entity.getCurrentFunding();
        this.percentage = entity.getPercentage();
    }
}
