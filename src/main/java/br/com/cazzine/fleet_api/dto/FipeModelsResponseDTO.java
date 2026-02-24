package br.com.cazzine.fleet_api.dto;

import java.util.List;

public class FipeModelsResponseDTO {
    private List<FipeModelDTO> modelos;

    public FipeModelsResponseDTO(List<FipeModelDTO> modelos) {
        this.modelos = modelos;
    }

    public List<FipeModelDTO> getModelos() {
        return modelos;
    }

    public void setModelos(List<FipeModelDTO> modelos) {
        this.modelos = modelos;
    }
}
