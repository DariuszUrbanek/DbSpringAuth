package example.com.dbauth.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import example.com.dbauth.entity.Salary;
import example.com.dbauth.entity.SalaryId;

public interface SalaryRepository extends JpaRepository<Salary, SalaryId>{

}
