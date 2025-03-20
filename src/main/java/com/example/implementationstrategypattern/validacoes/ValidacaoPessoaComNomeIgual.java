package com.example.implementationstrategypattern.validacoes;

import com.example.implementationstrategypattern.dto.CriacaoPessoaDto;
import com.example.implementationstrategypattern.exception.ValidacaoException;
import com.example.implementationstrategypattern.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoPessoaComNomeIgual implements ValidacaoCriacaoPessoa {

    @Autowired
    private PessoaRepository pessoaRepository;

    public void validar(CriacaoPessoaDto dto) {
        if(pessoaRepository.existsByNome(dto.nome())) {
            throw new ValidacaoException("Já existe uma pessoa com nome igual cadastrada");
        }
    }
}
