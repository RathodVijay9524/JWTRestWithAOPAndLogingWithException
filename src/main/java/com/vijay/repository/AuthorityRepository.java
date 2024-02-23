package com.vijay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijay.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
