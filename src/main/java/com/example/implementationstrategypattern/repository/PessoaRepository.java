package com.example.implementationstrategypattern.repository;

import com.example.implementationstrategypattern.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
    boolean existsByNome(String nome);
}
