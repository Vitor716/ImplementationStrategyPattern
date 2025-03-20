package com.example.implementationstrategypattern.controller;

import com.example.implementationstrategypattern.dto.CriacaoPessoaDto;
import com.example.implementationstrategypattern.service.PessoaService;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    @Transactional
    public ResponseEntity<String> criar (@RequestBody @Valid CriacaoPessoaDto dto) {
        try {
            this.pessoaService.criarPessoa(dto);
            return ResponseEntity.ok("Pessoa criada com sucesso!");
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
