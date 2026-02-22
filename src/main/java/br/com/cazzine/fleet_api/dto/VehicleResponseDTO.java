package br.com.cazzine.fleet_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class VehicleResponseDTO {
    private Integer id;
    private String plate;
    private String model;
    private Integer yearOfManufacture;
    private Integer mileage;

    public VehicleResponseDTO() {
    }

    public VehicleResponseDTO(Integer id, String plate, String model, Integer yearOfManufacture, Integer mileage) {
        this.id = id;
        this.plate = plate;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.mileage = mileage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(Integer yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }
}
