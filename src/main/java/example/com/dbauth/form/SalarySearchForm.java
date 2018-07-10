package example.com.dbauth.form;

import javax.validation.constraints.NotEmpty;

public class SalarySearchForm {
	
	@NotEmpty
	public String empNo;
	
	@NotEmpty
	public String fromDate;

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

}
