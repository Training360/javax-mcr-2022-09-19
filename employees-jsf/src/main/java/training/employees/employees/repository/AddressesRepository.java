package training.employees.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import training.employees.employees.entity.Address;

import java.util.List;

public interface AddressesRepository extends JpaRepository<Address, Long> {

    List<Address> findAddressByEmployeeId(long employeeId);
}
