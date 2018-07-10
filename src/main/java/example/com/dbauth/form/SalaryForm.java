package example.com.dbauth.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.constraints.NotEmpty;

import example.com.dbauth.entity.Salary;
import example.com.dbauth.entity.SalaryId;
import example.com.dbauth.util.DateContainer;

public class SalaryForm {

	private String empNo;
	
	private String fromDate;
		
	@NotEmpty
	public String salary;

	@NotEmpty
	public String toDate;
	
	public DateContainer dateContainer;

	public SalaryForm() {

	}

	public SalaryForm(Salary salary) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		this.empNo = salary.id.getEmpNo().toString();
		this.fromDate = dateFormat.format(salary.id.getFromDate());
		this.salary = salary.salary.toString();
		this.toDate = dateFormat.format(salary.toDate);
		this.dateContainer = new DateContainer(salary.id.getFromDate());
	}

	public Salary convertToEntity() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Salary target = new Salary();
		target.id = new SalaryId(Integer.valueOf(empNo), dateFormat.parse(fromDate));
		target.salary = Integer.valueOf(salary);
		target.toDate = dateFormat.parse(toDate);

		return target;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public DateContainer getDateContainer() {
		return dateContainer;
	}

	public void setDateContainer(DateContainer dateContainer) {
		this.dateContainer = dateContainer;
	}

}
