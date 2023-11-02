package com.example.pruebaamaris.service;

import com.example.pruebaamaris.domain.EmpleadoDTO;
import com.example.pruebaamaris.domain.EmployeeResponse;
import com.example.pruebaamaris.domain.EmployeeListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${empleados}")
    private String apiUrl;

    @Value("${empleadosbyid}")
    private String apiUrlById;

    @Override
    public List<EmpleadoDTO> getAllEmpleados() {
        EmployeeListResponse response = restTemplate.getForObject(apiUrl , EmployeeListResponse.class);
        List<EmpleadoDTO> empleadoDTOS = new ArrayList<>();
        for (int i = 0; i < response.getData().size(); i++) {
            EmpleadoDTO empleadoDTO = new EmpleadoDTO();
            empleadoDTO.setId(response.getData().get(i).getId());
            empleadoDTO.setEmployee_name(response.getData().get(i).getEmployee_name());
            empleadoDTO.setEmployee_salary(response.getData().get(i).getEmployee_salary());
            empleadoDTO.setEmployee_age(response.getData().get(i).getEmployee_age());
            empleadoDTO.setProfile_image(response.getData().get(i).getProfile_image());
            empleadoDTO.setAnualSalary(response.getData().get(i).getEmployee_salary() * 12);
            empleadoDTOS.add(empleadoDTO);
        }
        return empleadoDTOS;
    }


    @Override
    public List<EmpleadoDTO> getEmpleadoById(Long id) {
        EmployeeResponse response = restTemplate.getForObject(apiUrlById + id, EmployeeResponse.class);
        List<EmpleadoDTO> empleadoDTOS = new ArrayList<>();
        EmpleadoDTO empleadoDTO = new EmpleadoDTO();
        empleadoDTO.setId(response.getData().getId());
        empleadoDTO.setEmployee_name(response.getData().getEmployee_name());
        empleadoDTO.setEmployee_salary(response.getData().getEmployee_salary());
        empleadoDTO.setEmployee_age(response.getData().getEmployee_age());
        empleadoDTO.setProfile_image(response.getData().getProfile_image());
        empleadoDTO.setAnualSalary(response.getData().getEmployee_salary() * 12);
        empleadoDTOS.add(empleadoDTO);
        return empleadoDTOS;
    }
}
