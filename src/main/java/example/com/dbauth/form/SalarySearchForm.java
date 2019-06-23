package example.com.dbauth.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SalarySearchForm {

    @NotEmpty
    private String empNo;

    @NotEmpty
    private String fromDate;
}
