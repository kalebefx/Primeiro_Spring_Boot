package com.example.meu_primeiro_springboot.service;

import org.springframework.stereotype.Service;

import com.example.meu_primeiro_springboot.repository.MensagemRepository;

@Service // Indica que esta classe é um serviço, responsável pela lógica de negócios da aplicação e pode ser injetada em outros componentes do Spring
public class MensagemService {
    private final MensagemRepository mensagemRepository;

    public MensagemService(MensagemRepository mensagemRepository) {
        this.mensagemRepository = mensagemRepository;
    }

    public String obterMensagem() {
        return mensagemRepository.getMensagem();
    }
}
