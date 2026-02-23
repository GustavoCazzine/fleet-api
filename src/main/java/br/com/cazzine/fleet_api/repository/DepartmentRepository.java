package br.com.cazzine.fleet_api.repository;

import br.com.cazzine.fleet_api.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
