package com.integrador.service;

import com.integrador.exception.AlreadyExistException;
import com.integrador.exception.NotFoundException;
import com.integrador.repository.TurnoRepository;
import com.integrador.entity.Turno;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TurnoService {
    private TurnoRepository turnoRepository;

    public void agregar(Turno turno) throws AlreadyExistException {
        if (turnoRepository.exists(Example.of(turno)))throw new AlreadyExistException("The apointment already exists");
        turnoRepository.save(turno);
    }

    public List<Turno> listar(){return turnoRepository.findAll();}

    public Turno buscar(Integer id) throws NotFoundException {
        return turnoRepository.findById(id).orElseThrow(() -> new NotFoundException("Apointment not found"));
    }

    public void eliminar(int id) throws NotFoundException {
        if(buscar(id) == null) throw new NotFoundException("The apointment to delete does not exist");
        turnoRepository.deleteById(id);
    }
}
