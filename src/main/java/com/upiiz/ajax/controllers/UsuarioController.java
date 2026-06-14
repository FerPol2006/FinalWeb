package com.upiiz.ajax.controllers;

import com.upiiz.ajax.models.Usuario;
import com.upiiz.ajax.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario loginRequest) {
        Optional<Usuario> usuario = usuarioService.authenticate(loginRequest.getUsuario(), loginRequest.getContrasenia());
        if (usuario.isPresent()) {
            return new ResponseEntity<>("Login exitoso", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Credenciales inválidas", HttpStatus.UNAUTHORIZED);
        }
    }
    //Funciona bien, pero cuando exista código requerirá
    //cambios
}
