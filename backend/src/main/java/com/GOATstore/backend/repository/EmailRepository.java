package com.GOATstore.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.GOATstore.backend.entity.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {
    
}
