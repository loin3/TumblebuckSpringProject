package com.tumblebuck.domain.project;

import com.tumblebuck.domain.BaseTimeEntity;
import com.tumblebuck.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
public class Project extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column
    private LocalDate endDate;

    @Column
    private Long goalFunding;

    @Column
    private Long currentFunding;

    @Column
    private Float percentage;

    @Builder
    public Project(Long id, String title, String content, LocalDate endDate, Long goalFunding, Long currentFunding, Float percentage) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.endDate = endDate;
        this.goalFunding = goalFunding;
        this.currentFunding = currentFunding;
        this.percentage = percentage;
    }
}
