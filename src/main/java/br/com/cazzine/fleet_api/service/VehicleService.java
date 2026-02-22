package br.com.cazzine.fleet_api.service;

import br.com.cazzine.fleet_api.dto.VehicleRequestDTO;
import br.com.cazzine.fleet_api.exceptions.VehicleNotFoundException;
import br.com.cazzine.fleet_api.model.Vehicle;
import br.com.cazzine.fleet_api.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository repository;

    public Vehicle addVehicle(VehicleRequestDTO vehicle){
        return repository.save(new Vehicle(
                vehicle.getPlate(),
                vehicle.getModel(),
                vehicle.getYearOfManufacture(),
                vehicle.getMileage()
                ));
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
