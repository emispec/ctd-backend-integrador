package com.Integrador.controller;

import com.Integrador.entity.Paciente;
import com.Integrador.exception.AlreadyExistException;
import com.Integrador.exception.NotFoundException;
import com.Integrador.service.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@AllArgsConstructor
@RequestMapping("/pacientes")
public class PacienteController {
    private PacienteService pacienteService;

    @GetMapping("/list")
    public ResponseEntity<List<Paciente>> listar(){return ResponseEntity.ok( pacienteService.listar());}

    @PostMapping("/newPatient")
    public ResponseEntity<String> agregar(@RequestBody Paciente paciente) throws AlreadyExistException {
        pacienteService.agregar(paciente);
        return new ResponseEntity<>("El paciente fue creado de manera exitosa", HttpStatus.CREATED);
    }
    @PutMapping("/updatePatient/{domicilio}/{id}")
    public ResponseEntity<String>actualizar(@PathVariable String domicilio, @PathVariable Integer id) throws NotFoundException {
        pacienteService.modificar(domicilio,id);
        return new ResponseEntity<>("El paciente fue actualizado",HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Paciente> buscar(@PathVariable Integer id) throws NotFoundException {
        return new ResponseEntity<>(pacienteService.buscar(id), null, HttpStatus.OK);
    }
    @DeleteMapping("/deletePatient/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) throws NotFoundException {
        pacienteService.eliminar(id);
        return new ResponseEntity<>("Se elimino el paciente",HttpStatus.OK);
    }
}
