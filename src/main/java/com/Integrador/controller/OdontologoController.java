package com.Integrador.controller;

import com.Integrador.entity.Odontologo;
import com.Integrador.exception.AlreadyExistException;
import com.Integrador.exception.NotFoundException;
import com.Integrador.service.OdontologoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@AllArgsConstructor
@RequestMapping("odontologos")
public class OdontologoController {
    private OdontologoService odontologoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Odontologo>> listar(){
        if (odontologoService.listar().isEmpty())return new ResponseEntity<>(null,null,HttpStatus.NOT_FOUND);
        return ResponseEntity.ok( odontologoService.listar());
    }
    @PostMapping("/nuevoOdontologo")
    public ResponseEntity<String> agregar(@RequestBody Odontologo odontologo) throws AlreadyExistException, NotFoundException {
            odontologoService.agregar(odontologo);
            return new ResponseEntity<>("Se creo exitosamente", HttpStatus.CREATED);
    }
    @Transactional
    @PutMapping("/modificarOdontologo/{matricula}/{id}")
    public ResponseEntity<String>actualizar(@PathVariable String matricula, @PathVariable Integer id) throws NotFoundException{
        odontologoService.modificar(matricula,id);
        return new ResponseEntity<>("Se actualizo el odontologo",HttpStatus.OK);
    }


    @GetMapping("/buscar/{id}")
    public ResponseEntity<Odontologo> buscar(@PathVariable Integer id) throws NotFoundException {
        return new ResponseEntity<>(odontologoService.buscar(id), null, HttpStatus.OK);
    }


    @DeleteMapping("/borrarOdontologo/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) throws NotFoundException{
        odontologoService.eliminar(id);
        return new ResponseEntity<>("Odontologo eliminado exitosamente",HttpStatus.OK);
    }
}
