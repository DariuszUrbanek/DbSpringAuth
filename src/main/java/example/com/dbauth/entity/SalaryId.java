package example.com.dbauth.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "salaries")
@Access(AccessType.FIELD)
public class SalaryId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "emp_no")
	private Integer empNo;

	@Column(name = "from_date")
	private Date fromDate;

	public SalaryId() {
	}

	public SalaryId(Integer empNo, Date fromDate) {
		super();
		this.empNo = empNo;
		this.fromDate = fromDate;
	}

	public Integer getEmpNo() {
		return empNo;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empNo == null) ? 0 : empNo.hashCode());
		result = prime * result + ((fromDate == null) ? 0 : fromDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalaryId other = (SalaryId) obj;
		if (empNo == null) {
			if (other.empNo != null)
				return false;
		} else if (!empNo.equals(other.empNo))
			return false;
		if (fromDate == null) {
			if (other.fromDate != null)
				return false;
		} else if (!fromDate.equals(other.fromDate))
			return false;
		return true;
	}

}
