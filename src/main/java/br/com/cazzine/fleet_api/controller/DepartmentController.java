package br.com.cazzine.fleet_api.controller;


import br.com.cazzine.fleet_api.dto.DepartmentRequestDTO;
import br.com.cazzine.fleet_api.model.Department;
import br.com.cazzine.fleet_api.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping
    public Department newDepartment(@RequestBody DepartmentRequestDTO newDepartment){
        return departmentService.addDepartment(newDepartment.getName());
    }
}
