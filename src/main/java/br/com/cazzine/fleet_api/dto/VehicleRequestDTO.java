package br.com.cazzine.fleet_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class VehicleRequestDTO {

    @NotBlank(message = "A placa do veiculo não pode estar em branco")
    private String plate;

    @NotBlank(message = "O modelo do veiculo não pode estar em branco")
    private String model;

    @NotNull(message = "O ano da fabricação não pode ser vazio")
    @Positive(message = "O ano de fabricação não pode ser negativo")
    private Integer yearOfManufacture;

    @NotNull(message = "A quilometragem não pode ser vazio")
    @PositiveOrZero(message = "A quilometragem tem que ser maior ou igual a zero")
    private Integer mileage;

    public VehicleRequestDTO() {
    }

    public VehicleRequestDTO(String plate, String model, Integer yearOfManufacture, Integer mileage) {
        this.plate = plate;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.mileage = mileage;
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
