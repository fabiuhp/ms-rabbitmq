package com.fabiopereira.user.producers;

import com.fabiopereira.user.Usuario;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UsuarioProducer {

    private final RabbitTemplate rabbitTemplate;

    public UsuarioProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${broker.queue.email.name}")
    private String routingKey;

    public void publicarMensagemEmail(Usuario usuario) {
        var emailRecord = EmailRecord.fromUsuario(usuario, "Cadastro realizado com sucesso!", usuario.getNome() + " seja bem vindo!");

        rabbitTemplate.convertAndSend("", routingKey, emailRecord);
    }
}
