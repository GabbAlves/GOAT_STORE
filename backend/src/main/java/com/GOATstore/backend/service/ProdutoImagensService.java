package com.GOATstore.backend.service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.GOATstore.backend.entity.Produto;
import com.GOATstore.backend.entity.ProdutoImagens;
import com.GOATstore.backend.repository.ProdutoImagensRepository;
import com.GOATstore.backend.repository.ProdutoRepository;

@Service
public class ProdutoImagensService {
    
    @Autowired
    ProdutoImagensRepository produtoImagensRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    public List<ProdutoImagens> buscarTodos(){
        return produtoImagensRepository.findAll();
    }

    public ProdutoImagens inserir(Long idProduto, MultipartFile file){
        Produto produto = produtoRepository.findById(idProduto).get();
        ProdutoImagens produtoImagens = new ProdutoImagens();


        try {
            if(!file.isEmpty()){
                byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(produto.getId()) + file.getOriginalFilename();
                Path caminho = Paths
                .get("C:/Imagens/" + nomeImagem);
                Files.write(caminho, bytes);
                produtoImagens.setNome(nomeImagem);
             
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        produtoImagens.setProduto(produto);
        produtoImagens.setDataCriacao(new Date());
        produtoImagens = produtoImagensRepository.saveAndFlush(produtoImagens);
        return produtoImagens;
    }

    public ProdutoImagens alterar(ProdutoImagens produtoImagens){
        produtoImagens.setDataAtualizacao(new Date());
        return produtoImagensRepository.saveAndFlush(produtoImagens);
    }

    public void excluir(Long id){
        ProdutoImagens produtoImagens = produtoImagensRepository.findById(id).get();
        produtoImagensRepository.delete(produtoImagens);
        
    }
}
