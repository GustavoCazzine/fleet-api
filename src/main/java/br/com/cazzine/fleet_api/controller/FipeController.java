package br.com.cazzine.fleet_api.controller;

import br.com.cazzine.fleet_api.dto.FipeBrandDTO;
import br.com.cazzine.fleet_api.dto.FipeModelsResponseDTO;
import br.com.cazzine.fleet_api.service.FipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fipe")
public class FipeController {
    @Autowired
    private FipeService fipeService;

    @GetMapping("/brands")
    public List<FipeBrandDTO> getBrands(){
        return fipeService.getAllBrands();
    }

    @GetMapping("/brands/{brandId}/models")
    public FipeModelsResponseDTO getModels(@PathVariable String brandId){
        return fipeService.getModelByBrand(brandId);
    }
}
