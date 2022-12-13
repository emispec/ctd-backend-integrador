package com.integrador.controller;

import com.integrador.exception.NotFoundException;
import com.integrador.entity.Usuario;
import com.integrador.exception.AlreadyExistException;
import com.integrador.service.UsuarioService;
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
    @PostMapping("/registro")
    public ResponseEntity<String> agregar(@RequestBody Usuario usuario) throws AlreadyExistException, NotFoundException {
        usuarioService.guardar(usuario);
        return new ResponseEntity<>("Se agrego el usuario de forma exitosa!",null, HttpStatus.CREATED);
    }
}
