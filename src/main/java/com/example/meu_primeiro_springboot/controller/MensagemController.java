package com.example.meu_primeiro_springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.meu_primeiro_springboot.service.MensagemService;

@RestController
@RequestMapping("/api/mensagem")
public class MensagemController {
    private final MensagemService mensagemService;

    public MensagemController(MensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }

    @GetMapping // Endpoint para obter a mensagem
    public String getMensagem() {
        return mensagemService.obterMensagem();
    }

}
