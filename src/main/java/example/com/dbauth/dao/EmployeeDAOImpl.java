package example.com.dbauth.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import example.com.dbauth.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> getByFirstName(String firstName) {

		return em.createQuery("select e from Employee e where e.firstName = :firstName")
				.setParameter("firstName", firstName).getResultList();

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> getByFirstNameNativeSQL(String firstName) {

		return em.createNativeQuery("select * from emp.dbo.employees where first_name = ?1", Employee.class)
				.setParameter(1, firstName).getResultList();

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> getByFirstNameNamedQuery(String firstName) {

		return em.createNamedQuery("employees.by.name").setParameter("firstName", firstName).getResultList();

	}

	@Override
	public List<Employee> getByFirstNameNamedNativeQuery(String firstName) {

		return em.createNamedQuery("employees.by.name.native", Employee.class).setParameter(1, firstName)
				.getResultList();

	}

	@Transactional
	@Modifying
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> addModifyNameEmployeesNamedElvisAndReturnThem() {
		return em.createNativeQuery("update emp.dbo.employees set first_name = 'Elvis' " //
				+ "output inserted.* " //
				+ "where first_name = 'Elvis2' ", Employee.class).getResultList();
	}

	@Override
	@Transactional // kiedy dokonujesz zmian w bazie danych
	public void changeElvises() {
		List<Employee> elvisList = getByFirstName("Elvis");
		List<Employee> elvis2List = getByFirstName("Elvis2");

		for (Employee elvis : elvisList) {
			elvis.firstName = "Elvis2";
		}
		for (Employee elvis2 : elvis2List) {
			elvis2.firstName = "Elvis";
		}

	}
}
