package com.GOATstore.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;





@Service
public class EmailService {
    
    @Autowired
    private JavaMailSender javaMailSender;

    //para preencher o email cadastrado no pom de forma automatica
    @Value("${spring.mail.username}")
    private String remetente ;

   public String enviarEmail(String destinatario, String titulo, String mensagem){

    try{

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(remetente);
        simpleMailMessage.setTo(destinatario);
        simpleMailMessage.setSubject(titulo);
        simpleMailMessage.setText(mensagem);
        javaMailSender.send(simpleMailMessage);
        return "Email Enviado";

    }catch(Exception ex){

        return "Erro ao enviar o email :(";

    }


    }

}
