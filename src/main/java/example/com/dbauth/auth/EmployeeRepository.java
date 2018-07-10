package example.com.dbauth.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import example.com.dbauth.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
