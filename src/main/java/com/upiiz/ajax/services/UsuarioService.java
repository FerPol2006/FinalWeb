package com.upiiz.ajax.services;

import com.upiiz.ajax.models.Usuario;

import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> authenticate(String usuario, String contrasenia);
}
