package training.employees.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import training.employees.employees.entity.Address;

public interface AddressesRepository extends JpaRepository<Address, Long> {
}
