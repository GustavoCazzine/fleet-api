package br.com.cazzine.fleet_api.model;

import jakarta.persistence.*;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String plate;
    private String model;
    private Integer yearOfManufacture;
    private Integer mileage;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Vehicle() {
    }

    public Vehicle( String plate, String model, Integer yearOfManufacture, Integer mileage) {
        this.plate = plate;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.mileage = mileage;
        this.department = department;
    }

    public Vehicle(Integer id, String plate, String model, Integer yearOfManufacture, Integer mileage, Department department) {
        this.id = id;
        this.plate = plate;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.mileage = mileage;
        this.department = department;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
