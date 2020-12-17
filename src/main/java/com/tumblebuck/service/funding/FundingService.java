package com.tumblebuck.service.funding;

import com.tumblebuck.domain.funding.FundingRepository;
import com.tumblebuck.web.dto.FundResponseDto;
import com.tumblebuck.web.dto.ProjectListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FundingService {
    private final FundingRepository fundingRepository;

    @Transactional(readOnly = true)
    public List<FundResponseDto> findMyFundedByIdDesc(Long id){
        return fundingRepository.findByProjectDescCurrent(id).stream()
                .map(FundResponseDto::new)
                .collect(Collectors.toList());
    }
}
