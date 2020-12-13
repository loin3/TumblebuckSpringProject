package com.tumblebuck.domain.funding;

import com.tumblebuck.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Funding extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(length = 500, nullable = false)
    private String title;

    @Column
    private Long fundMoney;

    @Builder
    public Funding(Long id, String email, String title, Long fundMoney) {
        this.id = id;
        this.email = email;
        this.title = title;
        this.fundMoney = fundMoney;
    }
}
