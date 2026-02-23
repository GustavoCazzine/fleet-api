package br.com.cazzine.fleet_api.service;

import br.com.cazzine.fleet_api.dto.DepartmentRequestDTO;
import br.com.cazzine.fleet_api.model.Department;
import br.com.cazzine.fleet_api.repository.DepartmentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository depRepository;

    public Department addDepartment(String name){
        Department newDepartment = new Department();
        newDepartment.setName(name);
        return depRepository.save(newDepartment);
    }
}
