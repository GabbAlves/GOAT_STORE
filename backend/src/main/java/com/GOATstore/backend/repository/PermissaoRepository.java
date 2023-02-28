package com.GOATstore.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GOATstore.backend.entity.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
    
}
