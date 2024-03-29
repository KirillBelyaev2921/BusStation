package ua.bieliaiev.busstation.repostitories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.bieliaiev.busstation.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}