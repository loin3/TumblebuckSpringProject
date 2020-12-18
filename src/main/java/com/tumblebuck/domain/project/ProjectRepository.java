package com.tumblebuck.domain.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query("SELECT p FROM Project p where p.tag = ?1 ORDER BY p.id DESC")
    List<Project> findAllByTagDesc(Tag tag);

    @Query("SELECT p FROM Project p ORDER BY p.id DESC")
    List<Project> findAllDesc();

    @Query(nativeQuery = true, value = "select * from project p where p.percentage > 100 order by p.percentage desc")
    List<Project> findHotProject();

    @Query(nativeQuery = true, value = "select * from project p where p.percentage > 95 and p.end_date between now() and date_Add(now(), interval 1 day)")
    List<Project> findImpendingProject();

    @Query(nativeQuery = true, value = "select * from project p where p.email = ?1")
    List<Project> findByEmail(String email);

    @Query(nativeQuery = true, value = "select * from project p where p.id in (select pid from funding where email = ?1)")
    List<Project> findFundedByEmail(String email);

    @Query(nativeQuery = true, value = "select * from project p where p.title = ?1")
    Optional<Project> findByTitle(String title);

    @Query(nativeQuery = true, value = "select count(*) from funding f where f.pid = ?1 ")
    Long countDonateById(Long id);

    @Query
    Optional<Project> findById(Long id);
}
