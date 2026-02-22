package br.com.cazzine.fleet_api.repository;

import br.com.cazzine.fleet_api.model.Vehicle;
import jakarta.persistence.Id;
import org.hibernate.boot.jaxb.mapping.spi.JaxbPersistentAttribute;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}
