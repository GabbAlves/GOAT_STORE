
package com.GOATstore.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GOATstore.backend.entity.Pessoa;
     import com.GOATstore.backend.service.PessoaService;

import dto.PessoaClienteRequestDTO;

@RestController
@RequestMapping("/api/cliente")
public class PessoaClienteController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/")
    public Pessoa inserir(@RequestBody PessoaClienteRequestDTO pessoaClienteRequestDTO) {
        Pessoa pessoa = new PessoaClienteRequestDTO().converter(pessoaClienteRequestDTO);
        return pessoaService.inserir(pessoa);
    }

}
