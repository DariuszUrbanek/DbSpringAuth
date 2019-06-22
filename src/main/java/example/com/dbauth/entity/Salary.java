package example.com.dbauth.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "salaries")
@Access(AccessType.FIELD)
public class Salary {

    @EmbeddedId
    public SalaryId id;

    @Column(name = "salary")
    public Integer salary;

    @Column(name = "to_date")
    public Date toDate;

    public SalaryId getId() {
        return id;
    }

    public void setId(SalaryId id) {
        this.id = id;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

}
