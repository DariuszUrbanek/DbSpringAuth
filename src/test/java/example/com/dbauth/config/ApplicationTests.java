package example.com.dbauth.config;

import example.com.dbauth.dao.EmployeeDAO;
import example.com.dbauth.data.EmployeeRepository;
import example.com.dbauth.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
//	@Qualifier("EmployeeDaoImpl")
	private EmployeeDAO employeeDAO;
	
	
//	 @Autowired
//	 private MockMvc mockMvc;

	// @Test
	// public void loginWithValidUserThenAuthenticated() throws Exception {
	// FormLoginRequestBuilder login = formLogin()
	// .user("user")
	// .password("password");
	//
	// mockMvc.perform(login)
	// .andExpect(authenticated().withUsername("user"));
	// }
	//
	// @Test
	// public void loginWithInvalidUserThenUnauthenticated() throws Exception {
	// FormLoginRequestBuilder login = formLogin()
	// .user("invalid")
	// .password("invalidpassword");
	//
	// mockMvc.perform(login)
	// .andExpect(unauthenticated());
	// }
	//
	// @Test
	// public void accessUnsecuredResourceThenOk() throws Exception {
	// mockMvc.perform(get("/"))
	// .andExpect(status().isOk());
	// }
	//
	// @Test
	// public void accessSecuredResourceUnauthenticatedThenRedirectsToLogin() throws
	// Exception {
	// mockMvc.perform(get("/hello"))
	// .andExpect(status().is3xxRedirection())
	// .andExpect(redirectedUrlPattern("**/login"));
	// }
	//
//	 @Test
//	 @WithMockUser
//	 public void accessSecuredResourceAuthenticatedThenOk() throws Exception {
//	 mockMvc.perform(get("/hello"))
//	 .andExpect(status().isOk());
//	 }

	@Test
	public void test() {
		List<Employee> empList = employeeRepository.findByFirstNameAndLastName("Elvis", "Cardazo");
		// Elvis Cardazo
		empList.stream().forEach(e -> System.out.println(e.firstName + " " + e.lastName + ";"));
	}

	@Test
	public void test2() throws ParseException {
		List<Employee> empList;
		int page = 1;
		while ((empList = employeeRepository.findByBirthDateAfter(
				new SimpleDateFormat("yyyy-MM-dd").parse("1965-01-01"), PageRequest.of(page++, 5))).size() > 0) {
			System.out.println(page);
			empList.stream().forEach(e -> System.out.println(e.firstName + " " + e.lastName));
		}
		return;

	}
	
	@Test
	public void testFirst() {
		
		Employee emp = employeeRepository.findFirstByFirstName("Elvis");
		
		return;
	}
	
	@Test
	public void testContains() throws ParseException {
		List<Employee> empList;
		int page = 1;
		while ((empList = employeeRepository.findByFirstNameContainingIgnoreCase("dant", PageRequest.of(page++, 5))).size() > 0) {
			System.out.println(page);
			empList.stream().forEach(e -> System.out.println(e.firstName + " " + e.lastName));
		}
		return;

	}
	
	@Test
	public void testDAO() {
		
		List<Employee> empList = employeeDAO.getByFirstName("Elvis");
			
		empList.stream().forEach(e -> System.out.println(e.firstName + " " + e.lastName));
		
	}
	

	@Test
	public void testNativeDAO() {
		
		List<Employee> empList = employeeDAO.getByFirstNameNativeSQL("Elvis");
			
		empList.stream().forEach(e -> System.out.println(e.firstName + " " + e.lastName));
		
	}
	
	@Test
	public void testNamedQuery() {
		
		List<Employee> empList = employeeDAO.getByFirstNameNamedQuery("Elvis");
			
		empList.stream().forEach(e -> System.out.println(e.firstName + " " + e.lastName));
		
	}
	
	@Test
	public void testNamedNativeQuery() {
		
		List<Employee> empList = employeeDAO.getByFirstNameNamedNativeQuery("Elvis");
			
		empList.stream().forEach(e -> System.out.println(e.firstName + " " + e.lastName));
		
	}
	
	@Test
	public void testElvis() {
		
		List<Employee> empList = employeeDAO.addModifyNameEmployeesNamedElvisAndReturnThem();
			
		empList.stream().forEach(e -> System.out.println(e.firstName + " " + e.lastName));
		
	}
	
}
