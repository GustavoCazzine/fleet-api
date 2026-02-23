package br.com.cazzine.fleet_api.service;

import br.com.cazzine.fleet_api.dto.VehicleRequestDTO;
import br.com.cazzine.fleet_api.exceptions.DepartmentNotFoundException;
import br.com.cazzine.fleet_api.exceptions.VehicleNotFoundException;
import br.com.cazzine.fleet_api.model.Department;
import br.com.cazzine.fleet_api.model.Vehicle;
import br.com.cazzine.fleet_api.repository.DepartmentRepository;
import br.com.cazzine.fleet_api.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository repository;
    @Autowired
    private DepartmentRepository departmentRepo;

    public Vehicle addVehicle(VehicleRequestDTO vehicle){
        Department departmentFound = departmentRepo.findById(vehicle.getDepartmentId()).orElseThrow(() -> new DepartmentNotFoundException("Departamento não encontrado."));

        Vehicle newVehicle = new Vehicle(
                vehicle.getPlate(),
                vehicle.getModel(),
                vehicle.getYearOfManufacture(),
                vehicle.getMileage()
        );

        newVehicle.setDepartment(departmentFound);

        return repository.save(newVehicle);

    }

    public List<Vehicle> findAllVehicles(){
        return repository.findAll();
    }

    public Vehicle findById(Integer id){
        return repository.findById(id).orElseThrow(() -> new VehicleNotFoundException("Vehicle not found."));
    }

    public Vehicle updateVehicle(Integer id, VehicleRequestDTO updateVehicle){
        Vehicle vehicleFound = findById(id);

        vehicleFound.setMileage(updateVehicle.getMileage());
        vehicleFound.setModel(updateVehicle.getModel());
        vehicleFound.setPlate(updateVehicle.getPlate());
        vehicleFound.setYearOfManufacture(updateVehicle.getYearOfManufacture());

        return repository.save(vehicleFound);
    }

    public void deleteById(Integer id){
        findById(id);
        repository.deleteById(id);
    }
}
