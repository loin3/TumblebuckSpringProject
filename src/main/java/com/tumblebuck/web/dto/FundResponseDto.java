package com.tumblebuck.web.dto;

import com.tumblebuck.domain.funding.Funding;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class FundResponseDto {
    private Long id;
    private LocalDateTime createDate;
    private String email;
    private Long fundMoney;
    private Long pid;

    public FundResponseDto(Funding entity){
        this.id = entity.getId();
        this.createDate = entity.getCreatedDate();
        this.email = entity.getEmail();
        this.fundMoney = entity.getFundMoney();
        this.pid = entity.getPid();
    }
}
