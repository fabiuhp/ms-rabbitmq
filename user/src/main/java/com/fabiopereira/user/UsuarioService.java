package com.fabiopereira.user;

import com.fabiopereira.user.producers.UsuarioProducer;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private UsuarioProducer usuarioProducer;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioProducer usuarioProducer) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioProducer = usuarioProducer;
    }

    @Transactional
    public Usuario salvar(UsuarioRecord usuarioRecord) {
        Usuario usuario = Usuario
                .builder()
                .nome(usuarioRecord.nome())
                .email(usuarioRecord.email()).build();

        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        publicarMensagem(usuarioSalvo);

        return usuarioSalvo;
    }

    private void publicarMensagem(Usuario usuario) {
        usuarioProducer.publicarMensagemEmail(usuario);
    }
}
