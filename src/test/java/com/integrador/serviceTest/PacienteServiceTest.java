package com.integrador.serviceTest;

import com.integrador.exception.NotFoundException;
import com.integrador.repository.PacienteRepository;
import com.integrador.service.PacienteService;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PacienteServiceTest {
    @Test
    public void buscarPaciente(){
        var repository = mock(PacienteRepository.class);
        when(repository.findById(anyInt())).thenReturn(Optional.empty());
        var service = new PacienteService(repository);

        assertThrows(NotFoundException.class, ()-> service.buscar(5));
    }
}
