package example.com.dbauth.dao;

import example.com.dbauth.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getByFirstName(String firstName);

    List<Employee> getByFirstNameNativeSQL(String firstName);

    List<Employee> getByFirstNameNamedQuery(String firstName);

    List<Employee> getByFirstNameNamedNativeQuery(String firstName);

    List<Employee> addModifyNameEmployeesNamedElvisAndReturnThem();

    void changeElvises();

}