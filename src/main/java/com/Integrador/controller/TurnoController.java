package com.Integrador.controller;

import com.Integrador.exception.NotFoundException;
import com.Integrador.entity.Turno;
import com.Integrador.exception.AlreadyExistException;
import com.Integrador.service.TurnoService;
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

    @GetMapping("/list")
    public ResponseEntity<List<Turno>> listar(){return ResponseEntity.ok( turnoService.listar());}

    @PostMapping("/newApointment")
    public ResponseEntity<String> agregar(@RequestBody Turno turno) throws AlreadyExistException {
        turnoService.agregar(turno);
        return new ResponseEntity<>("El turno se creo de forma exitosa",null, HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Turno> buscar(@PathVariable Integer id) throws NotFoundException {
        return new ResponseEntity<>(turnoService.buscar(id), null, HttpStatus.OK);
    }

    @DeleteMapping("/deleteApointment/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) throws NotFoundException {
        turnoService.eliminar(id);
        return new ResponseEntity<>("Turno eliminado exitosamente",null,HttpStatus.OK);
    }
}
