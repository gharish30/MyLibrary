package com.hash.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hash.main.entity.Borrower;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {

	boolean existsByEmail(String email);

}
