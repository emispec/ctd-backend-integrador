package com.integrador.service;

import com.integrador.exception.NotFoundException;
import com.integrador.repository.OdontologoRepository;
import com.integrador.entity.Odontologo;
import com.integrador.exception.AlreadyExistException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OdontologoService {
    private OdontologoRepository odontologoRepository;
    public void agregar(Odontologo odontologo) throws AlreadyExistException {
        if (odontologoRepository.exists(Example.of(odontologo))) throw new AlreadyExistException("Odontologist already exist");
        odontologoRepository.save(odontologo);
    }
    public List<Odontologo> listar(){return odontologoRepository.findAll();}

    public void modificar(String matricula,Integer id) throws NotFoundException {
        if(buscar(id) == null) throw new NotFoundException("The odontologist to modify does not exist");
        odontologoRepository.modificar(matricula, id);
        ;}

    public void eliminar(int id) throws NotFoundException {
        if (buscar(id) ==null) throw new NotFoundException("The odontologist to delete does not exist");
        odontologoRepository.deleteById(id);
    }

    public Odontologo buscar(Integer id) throws NotFoundException {
        return odontologoRepository.findById(id).orElseThrow(() -> new NotFoundException("Odontologist not found"));
    }
}
