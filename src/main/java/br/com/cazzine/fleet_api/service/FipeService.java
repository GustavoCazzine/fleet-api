package br.com.cazzine.fleet_api.service;

import br.com.cazzine.fleet_api.dto.FipeBrandDTO;
import br.com.cazzine.fleet_api.dto.FipeModelsResponseDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestClient;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Service
public class FipeService {

    // Criamos o nosso Postman interno
    private final RestClient restClient = RestClient.create();

    public List<FipeBrandDTO> getAllBrands() {
        // Aqui nós configuramos a requisição exatamente igual no Postman:
        return restClient.get() // 1. Seleciona o método GET
                .uri("https://parallelum.com.br/fipe/api/v1/carros/marcas") // 2. Cola a URL
                .retrieve() // 3. Clica em "Send" (Enviar)
                .body(new ParameterizedTypeReference<List<FipeBrandDTO>>() {}); // 4. Converte o JSON de resposta para a nossa Lista de DTOs
    }

    public FipeModelsResponseDTO getModelByBrand(String brandId){
        return restClient.get()
            .uri("https://parallelum.com.br/fipe/api/v1/carros/marcas/{id}/modelos", brandId)
            .retrieve()
            .body(FipeModelsResponseDTO.class);

    }
}
