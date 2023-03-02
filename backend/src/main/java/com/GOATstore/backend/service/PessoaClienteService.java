package com.GOATstore.backend.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GOATstore.backend.entity.Pessoa;
import com.GOATstore.backend.repository.PessoaClienteRepository;


import dto.PessoaClienteRequestDTO;

@Service
public class PessoaClienteService{

    @Autowired
    private PessoaClienteRepository pessoaRepository;
    
    @Autowired
    private PermissaoPessoaService permissaoPessoaService;

    public Pessoa inserir(PessoaClienteRequestDTO pessoaClienteRequestDTO){
        Pessoa pessoa = new PessoaClienteRequestDTO().converter(pessoaClienteRequestDTO);  
        
        pessoa.setDataCriacao(new Date());
        Pessoa pessoaNovo = pessoaRepository.saveAndFlush(pessoa);
        permissaoPessoaService.vincularPessoaPermissaoCliente(pessoaNovo);
        return pessoaNovo;
    }



}