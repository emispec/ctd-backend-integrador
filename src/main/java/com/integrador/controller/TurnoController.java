package com.integrador.controller;

import com.integrador.exception.NotFoundException;
import com.integrador.entity.Turno;
import com.integrador.exception.AlreadyExistException;
import com.integrador.service.TurnoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@AllArgsConstructor
@RequestMapping("/turnos")
public class TurnoController {

    private TurnoService turnoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Turno>> listar(){return ResponseEntity.ok( turnoService.listar());}

    @PostMapping("/nuevoTurno")
    public ResponseEntity<String> agregar(@RequestBody Turno turno) throws AlreadyExistException {
        turnoService.agregar(turno);
        return new ResponseEntity<>("El turno se creo de forma exitosa",null, HttpStatus.CREATED);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Turno> buscar(@PathVariable Integer id) throws NotFoundException {
        return new ResponseEntity<>(turnoService.buscar(id), null, HttpStatus.OK);
    }

    @DeleteMapping("/eliminarTurno/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) throws NotFoundException {
        turnoService.eliminar(id);
        return new ResponseEntity<>("Turno eliminado exitosamente",null,HttpStatus.OK);
    }
}
