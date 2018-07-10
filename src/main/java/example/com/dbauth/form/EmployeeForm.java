package example.com.dbauth.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.constraints.NotEmpty;

import example.com.dbauth.entity.Employee;

public class EmployeeForm {
	
	public Integer empNo;

	@NotEmpty
	public String birthDate;

	@NotEmpty
	public String firstName;

	@NotEmpty
	public String lastName;

	@NotEmpty
	public String hireDate;

	public EmployeeForm() {
	}
	
	public EmployeeForm(Employee source) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		this.empNo = source.empNo;		
		this.birthDate = dateFormat.format(source.birthDate);
		this.firstName = source.firstName;
		this.lastName = source.lastName;
		this.hireDate = dateFormat.format(source.hireDate);
		
	}
	
	public Employee convertToEntity() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Employee target = new Employee();
		target.birthDate = dateFormat.parse(birthDate);
		target.empNo = empNo;
		target.firstName = firstName;
		target.hireDate = dateFormat.parse(hireDate);
		target.lastName = lastName;
		
		return target;
		
	}
	
	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}


}
