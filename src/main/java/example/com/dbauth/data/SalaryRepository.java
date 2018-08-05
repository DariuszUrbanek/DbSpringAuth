package example.com.dbauth.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import example.com.dbauth.entity.Salary;
import example.com.dbauth.entity.SalaryId;

public interface SalaryRepository extends JpaRepository<Salary, SalaryId>{

	
	@Query("select s from Salary s where s.id.empNo = :empNo")
	List<Salary> findByIdEmpNo(@Param("empNo") Integer empNo);

}