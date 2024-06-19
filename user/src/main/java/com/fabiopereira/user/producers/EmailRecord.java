package com.fabiopereira.user.producers;

import com.fabiopereira.user.Usuario;

import java.util.UUID;

public record EmailRecord(
        UUID userId,
        String emailTo,
        String subject,
        String text
) {
    public static EmailRecord fromUsuario(Usuario usuario, String subject, String text) {
        return new EmailRecord(usuario.getId(), usuario.getEmail(), subject, text);
    }
}