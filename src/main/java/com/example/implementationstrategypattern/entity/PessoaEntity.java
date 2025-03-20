package com.example.implementationstrategypattern.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pessoas")
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public PessoaEntity(String nome) {
        this.nome = nome;
    }

    public PessoaEntity() {

    }
}

