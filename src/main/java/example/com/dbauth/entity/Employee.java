package example.com.dbauth.entity;

import javax.persistence.*;
import java.util.Date;

@NamedQuery(name = "employees.by.name", query = "select e from Employee e where e.firstName = :firstName")
@NamedNativeQuery(name = "employees.by.name.native", query = "select * from emp.dbo.employees where first_name = ?1", resultClass = Employee.class)
@Entity
@Table(name = "employees")
@Access(AccessType.FIELD)
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "emp_no")
    public Integer empNo;

    @Column(name = "birth_date")
    public Date birthDate;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    public String lastName;

    @Column(name = "hire_date")
    public Date hireDate;

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
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

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }


}
