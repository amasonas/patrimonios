package com.navita.exam.usuario.service;

import com.navita.exam.config.BCryptPasswordEncoderService;
import com.navita.exam.usuario.Usuario;
import com.navita.exam.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoderService bCryptPasswordEncoderService;

    @Override
    public Usuario save(Usuario usuario) {
        BCryptPasswordEncoder encoder = bCryptPasswordEncoderService.get();

        usuario.setSenha(encoder.encode(usuario.getSenha()));

        return usuarioRepository.save(usuario);
    }
}
