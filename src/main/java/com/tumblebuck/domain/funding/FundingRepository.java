package com.tumblebuck.domain.funding;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FundingRepository extends JpaRepository<Funding, Long> {
    @Query(nativeQuery = true, value = "select * from funding f where f.email = ?0")
    List<Funding> findByEmail(String email);

    @Query(nativeQuery = true, value = "select * from funding f where f.title = (select title from project p where p.id = ?0) order by f.created_date desc")
    List<Funding> findByProjectDescCurrent(Long id);

    @Query(nativeQuery = true, value = "select * from funding f where f.title = (select title from project p where p.id = ?0) order by f.fundMoney desc")
    List<Funding> findByProjectDescFundMoney(Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM funding f where month(f.created_date) = ?0")
    List<Funding> findByMonth(int month);
}
