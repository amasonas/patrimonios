package com.navita.exam.usuario.service;

import com.navita.exam.config.BCryptPasswordEncoderService;
import com.navita.exam.role.Role;
import com.navita.exam.role.service.RoleService;
import com.navita.exam.usuario.Usuario;
import com.navita.exam.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    RoleService roleService;

    @Autowired
    private BCryptPasswordEncoderService bCryptPasswordEncoderService;

    @Override
    public Usuario save(Usuario usuario) {
        BCryptPasswordEncoder encoder = bCryptPasswordEncoderService.get();

        usuario.setSenha(encoder.encode(usuario.getSenha()));

        if (usuario.getRoles() == null || usuario.getRoles().isEmpty()) {
            List<Role> roles = new ArrayList<>();

            roles.add(roleService.findById(1l));

            usuario.setRoles(roles);
        }

        return usuarioRepository.save(usuario);
    }
}
