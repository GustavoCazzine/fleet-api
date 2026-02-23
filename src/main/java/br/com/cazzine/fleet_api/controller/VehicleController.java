package br.com.cazzine.fleet_api.controller;

import br.com.cazzine.fleet_api.dto.VehicleRequestDTO;
import br.com.cazzine.fleet_api.dto.VehicleResponseDTO;
import br.com.cazzine.fleet_api.model.Vehicle;
import br.com.cazzine.fleet_api.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService service;

    @PostMapping
    public VehicleResponseDTO addVehicle(@RequestBody @Valid VehicleRequestDTO newVehicle){
        Vehicle newVeh = service.addVehicle(newVehicle);

        // Correção: pegando o getName() do departamento
        return new VehicleResponseDTO(
                newVeh.getId(),
                newVeh.getPlate(),
                newVeh.getModel(),
                newVeh.getYearOfManufacture(),
                newVeh.getMileage(),
                newVeh.getDepartment().getName()
        );
    }

    @GetMapping
    public List<VehicleResponseDTO> allVehicles(){
        List<Vehicle> vehicles = service.findAllVehicles();

        return vehicles.stream()
                .map(vehicle -> new VehicleResponseDTO(
                        vehicle.getId(),
                        vehicle.getPlate(),
                        vehicle.getModel(),
                        vehicle.getYearOfManufacture(),
                        vehicle.getMileage(),
                        vehicle.getDepartment().getName() // Correção aqui
                ))
                .toList();
    }

    @GetMapping("/{id}")
    public VehicleResponseDTO findById(@PathVariable Integer id){
        Vehicle vehicleFound = service.findById(id);

        return new VehicleResponseDTO(
                vehicleFound.getId(),
                vehicleFound.getPlate(),
                vehicleFound.getModel(),
                vehicleFound.getYearOfManufacture(),
                vehicleFound.getMileage(),
                vehicleFound.getDepartment().getName() // Parêntese arrumado!
        );
    }

    @PutMapping("/{id}")
    public VehicleResponseDTO updateVehicle(@PathVariable Integer id, @RequestBody @Valid VehicleRequestDTO updateVehicle){
        Vehicle editVehicle = service.updateVehicle(id, updateVehicle);

        return new VehicleResponseDTO(
                editVehicle.getId(),
                editVehicle.getPlate(),
                editVehicle.getModel(),
                editVehicle.getYearOfManufacture(),
                editVehicle.getMileage(),
                editVehicle.getDepartment().getName() // Parêntese arrumado!
        );
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }
}