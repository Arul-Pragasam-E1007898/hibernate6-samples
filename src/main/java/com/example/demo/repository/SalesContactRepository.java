package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.SalesContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesContactRepository
        extends JpaRepository<SalesContact, Long> {
    Optional<SalesContact> findByIdAndAccountId(Long id, Long account);

    List<SalesContact> findAllByAccountId(Long account);
}
