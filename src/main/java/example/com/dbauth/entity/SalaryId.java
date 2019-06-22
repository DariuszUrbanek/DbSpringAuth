package example.com.dbauth.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@Table(name = "salaries")
@Access(AccessType.FIELD)
@Getter
@Setter
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
