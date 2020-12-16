package com.tumblebuck.web.dto;

import com.tumblebuck.domain.project.Project;
import com.tumblebuck.domain.project.Tag;
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
    private String picture;
    private Tag tag;
    private String str_tag;

    @Builder
    public ProjectSaveRequestDto(String title, String content, LocalDate endDate, Long currentFunding, Long goalFunding, Float percentage, String email, String picture, String str_tag) {
        this.title = title;
        this.content = content;
        this.endDate = endDate;
        this.currentFunding = currentFunding;
        this.goalFunding = goalFunding;
        this.percentage = percentage;
        this.email = email;
        this.picture = picture;
        this.str_tag = str_tag;
    }

    private Tag changeToTag(String string){
        switch (string){
            case "GAME":
                return Tag.GAME;
            case "CONCERT":
                return Tag.CONCERT;
            case "DESIGN":
                return Tag.DESIGN;
            case "CARTOON":
                return Tag.CARTOON;
            case "CRAFT":
                return Tag.CRAFT;
            default:
                return Tag.ETC;
        }
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
                .picture(picture)
                .tag(changeToTag(str_tag))
                .build();
    }
}
