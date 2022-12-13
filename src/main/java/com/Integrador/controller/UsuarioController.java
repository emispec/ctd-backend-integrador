package com.Integrador.controller;

import com.Integrador.exception.NotFoundException;
import com.Integrador.entity.Usuario;
import com.Integrador.exception.AlreadyExistException;
import com.Integrador.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class UsuarioController {
    private UsuarioService usuarioService;
    @PostMapping("/register")
    public ResponseEntity<String> agregar(@RequestBody Usuario usuario) throws AlreadyExistException, NotFoundException {
        usuarioService.guardar(usuario);
        return new ResponseEntity<>("Se agrego el usuario de forma exitosa!",null, HttpStatus.CREATED);
    }
}
