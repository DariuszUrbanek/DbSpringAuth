package example.com.dbauth.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "salaries")
@Access(AccessType.FIELD)
@Data
public class Salary {

    @EmbeddedId
    public SalaryId id;

    @Column(name = "salary")
    public Integer salary;

    @Column(name = "to_date")
    public Date toDate;
}
