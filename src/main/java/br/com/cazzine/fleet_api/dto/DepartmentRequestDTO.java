package br.com.cazzine.fleet_api.dto;

import jakarta.validation.constraints.NotNull;

public class DepartmentRequestDTO {
    @NotNull(message = "O nome não pode ser vazio")
    private String name;

    public DepartmentRequestDTO(String name) {
        this.name = name;
    }

    public DepartmentRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
