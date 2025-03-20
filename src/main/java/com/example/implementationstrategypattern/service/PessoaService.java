package com.example.implementationstrategypattern.service;

import com.example.implementationstrategypattern.dto.CriacaoPessoaDto;
import com.example.implementationstrategypattern.entity.PessoaEntity;
import com.example.implementationstrategypattern.repository.PessoaRepository;
import com.example.implementationstrategypattern.validacoes.ValidacaoCriacaoPessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private List<ValidacaoCriacaoPessoa> validacoes;

    public void criarPessoa(CriacaoPessoaDto dto) {
        validacoes.forEach(v -> v.validar(dto));

        PessoaEntity pessoa = new PessoaEntity(dto.nome());

        pessoaRepository.save(pessoa);
    }
}
