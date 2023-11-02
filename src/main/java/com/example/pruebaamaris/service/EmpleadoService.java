package com.example.pruebaamaris.service;

import com.example.pruebaamaris.domain.EmpleadoDTO;

import java.util.List;

public interface EmpleadoService {
    public List<EmpleadoDTO> getAllEmpleados();
    public List<EmpleadoDTO> getEmpleadoById(Long id);
}
