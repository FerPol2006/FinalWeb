package com.upiiz.ajax.services;

import com.upiiz.ajax.models.Usuario;
import com.upiiz.ajax.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Optional<Usuario> authenticate(String usuario, String contrasenia) {
        return usuarioRepository.findByUsuarioAndContrasenia(usuario, contrasenia);
    }
}
