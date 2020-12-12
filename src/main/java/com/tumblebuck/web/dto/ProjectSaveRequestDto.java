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
    private String email;

    @Builder
    public ProjectSaveRequestDto(String title, String content, LocalDate endDate, Long currentFunding, Long goalFunding, Float percentage, String email) {
        this.title = title;
        this.content = content;
        this.endDate = endDate;
        this.currentFunding = currentFunding;
        this.goalFunding = goalFunding;
        this.percentage = percentage;
        this.email = email;
    }

    public Project toEntity(String email){
        return Project.builder()
                .title(title)
                .content(content)
                .endDate(endDate)
                .currentFunding(currentFunding)
                .goalFunding(goalFunding)
                .percentage(percentage)
                .email(email)
                .build();
    }
}
