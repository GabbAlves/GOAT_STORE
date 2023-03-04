package com.GOATstore.backend.entity;



import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "email")
@Data

public class Email {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //gerar chave automaticamente
    private long id;

    private String destinatario;
    private String remetente;
    private String titulo;
    private String mensagem;

    @Temporal(TemporalType.TIME) // informar que vai armazenar data e hr no banco
    private Date dataCriação;
    @Temporal(TemporalType.TIME)
    private Date dataAtualização;
}
