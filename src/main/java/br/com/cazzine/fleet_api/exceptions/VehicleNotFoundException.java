package br.com.cazzine.fleet_api.exceptions;

import org.springframework.http.HttpStatus;

@HttpStatus.NOT_FOUND
public class VehicleNotFoundException extends RuntimeException{
    public VehicleNotFoundException(String message) {
        super(message);
    }
}
