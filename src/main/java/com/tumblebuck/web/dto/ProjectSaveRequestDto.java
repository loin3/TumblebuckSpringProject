package com.tumblebuck.web.dto;

import com.tumblebuck.domain.project.Project;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class ProjectSaveRequestDto {
    private String title;
    private String content;
    private LocalDate endDate;
    private Long currentFunding;
    private Long goalFunding;
    private Float percentage;

    @Builder
    public ProjectSaveRequestDto(String title, String content, LocalDate endDate, Long currentFunding, Long goalFunding, Float percentage) {
        this.title = title;
        this.content = content;
        this.endDate = endDate;
        this.currentFunding = currentFunding;
        this.goalFunding = goalFunding;
        this.percentage = percentage;
    }

    public Project toEntity(){
        return Project.builder()
                .title(title)
                .content(content)
                .endDate(endDate)
                .currentFunding(currentFunding)
                .goalFunding(goalFunding)
                .percentage(percentage)
                .build();
    }
}
