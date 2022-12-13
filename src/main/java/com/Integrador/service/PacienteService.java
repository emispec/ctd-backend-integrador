package com.Integrador.service;

import com.Integrador.entity.Paciente;
import com.Integrador.exception.AlreadyExistException;
import com.Integrador.exception.NotFoundException;
import com.Integrador.repository.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PacienteService {
    private PacienteRepository pacienteRepository;

    public void agregar(Paciente paciente) throws AlreadyExistException {
        if (pacienteRepository.exists(Example.of(paciente)))throw new AlreadyExistException("Patient already exist");
        pacienteRepository.save(paciente);
    }
    public List<Paciente> listar(){return pacienteRepository.findAll();}

    public void modificar(String domicilio, Integer id)throws NotFoundException {
        if(buscar(id) == null) throw new NotFoundException("The patient to delete is non-existent");
        pacienteRepository.modificar(domicilio, id);
    }

    public Paciente buscar(Integer id) throws NotFoundException {
        return pacienteRepository.findById(id).orElseThrow(() -> new NotFoundException("Patient not found"));
    }
    public void eliminar(int id) throws NotFoundException {
        if(buscar(id) == null) throw new NotFoundException("Patient to delete not found");
        pacienteRepository.deleteById(id);
    }

}
