package com.hospital_management_system.repository;

import org.springframework.stereotype.Repository;
import com.hospital_management_system.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

}
