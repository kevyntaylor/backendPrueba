package com.example.pruebaamaris.controller;

import com.example.pruebaamaris.domain.EmpleadoDTO;
import com.example.pruebaamaris.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    //get all empleados code here
    @GetMapping("/empleados")
    public List<EmpleadoDTO> getAllEmpleados(){
        return empleadoService.getAllEmpleados();
    }

    //get empleado by id code here
    @GetMapping("/empleados/{id}")
    public List<EmpleadoDTO> getEmpleadoById(@PathVariable Long id){
        return empleadoService.getEmpleadoById(Long.valueOf(id));
    }

}
