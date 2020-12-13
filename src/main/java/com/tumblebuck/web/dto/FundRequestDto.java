package com.tumblebuck.web.dto;

import com.tumblebuck.domain.funding.Funding;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FundRequestDto {
    String title;
    String email;
    Long fundMoney;

    @Builder
    public FundRequestDto(String title, String email, Long fundMoney) {
        this.title = title;
        this.email = email;
        this.fundMoney = fundMoney;
    }

    public Funding toEntity(String email){
        return Funding.builder()
                .title(title)
                .email(email)
                .fundMoney(fundMoney)
                .build();
    }
}
