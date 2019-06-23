package example.com.dbauth.form;

import example.com.dbauth.entity.Employee;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Data
public class EmployeeForm {

    private Integer empNo;

    @NotEmpty
    private String birthDate;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String hireDate;

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
}