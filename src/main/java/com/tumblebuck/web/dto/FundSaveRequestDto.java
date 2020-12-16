package com.tumblebuck.web.dto;

import com.tumblebuck.domain.funding.Funding;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FundSaveRequestDto {
    Long pid;
    String email;
    Long fundMoney;

    @Builder
    public FundSaveRequestDto(Long pid, String email, Long fundMoney) {
        this.pid = pid;
        this.email = email;
        this.fundMoney = fundMoney;
    }

    public Funding toEntity(String email){
        return Funding.builder()
                .pid(pid)
                .email(email)
                .fundMoney(fundMoney)
                .build();
    }
}
