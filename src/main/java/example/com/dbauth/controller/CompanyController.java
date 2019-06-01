package example.com.dbauth.controller;

import example.com.dbauth.dao.EmployeeDAO;
import example.com.dbauth.data.EmployeeRepository;
import example.com.dbauth.data.SalaryRepository;
import example.com.dbauth.entity.Employee;
import example.com.dbauth.entity.Salary;
import example.com.dbauth.entity.SalaryId;
import example.com.dbauth.form.*;
import example.com.dbauth.util.DateContainer;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@Secured({ "ROLE_USER", "ROLE_ADMIN" })
public class CompanyController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private SalaryRepository salaryRepository;

	@Autowired
	private EmployeeDAO employeeDAO;

	@GetMapping("/home")
	public String homePage() {

		return "home";
	}

	@GetMapping({ "/employee/{empNo}", "/employee/{empNo}/{success}" })
	public ModelAndView employeeGet(@PathVariable String empNo, @PathVariable(required = false) String success) {
		Optional<Employee> employeeOpt = employeeRepository.findById(Integer.valueOf(empNo));
		if (employeeOpt.isPresent()) {
			ModelAndView mav = new ModelAndView("employee");
			mav.getModel().put("employee", new EmployeeForm(employeeOpt.get()));
			return mav;
		} else
			return new ModelAndView("redirect:/employeeSearch/notFound/" + empNo);
	}

	@PostMapping("/employee")
	public String employeePostGate(@ModelAttribute EmployeeForm employee, BindingResult result) throws ParseException {

		employeeRepository.save(employee.convertToEntity());

		return "redirect:/employee/" + employee.getEmpNo() + "/success";
	}

	@PostMapping("/employee/{empNo}")
	public String employeePost(@PathVariable String empNo, @ModelAttribute EmployeeForm employee, BindingResult result)
			throws ParseException {
		employeeRepository.save(employee.convertToEntity());
		return "redirect:/employeeSearch";
	}

	@GetMapping({ "/employeeSearch", "/employeeSearch/{message}/{incorrectNo}" })
	public ModelAndView employeeSearchGet(@PathVariable(required = false) String message,
			@PathVariable(required = false) String incorrectNo) {

		ModelAndView mav = new ModelAndView();
		if ("notFound".equals(message)) {
			mav.getModel().put("notFound", "true");
			mav.getModel().put("incorrectNo", incorrectNo);
		}

		mav.getModel().put("form", new EmployeeSearchForm());
		mav.setViewName("employeeSearch");
		return mav;
	}

	@PostMapping("/employeeSearch")
	public String employeeSearchPost(@ModelAttribute @Valid EmployeeSearchForm form, Model model,
			BindingResult bindingResult) {

		if (form.getEmpNo() == null || bindingResult.hasErrors()) {
			model.addAttribute("form", form);
			return "employeeSearch";
		}

		return "redirect:/employee/" + form.getEmpNo();
	}

	@GetMapping("/employeeSearchByName")
	public ModelAndView employeeSearchByNameGet() {
		ModelAndView mav = new ModelAndView("employeeSearchByName");
		mav.addObject("form", new EmployeeSearchByNameForm());

		return mav;
	}

	@PostMapping("/employeeSearchByName")
	public String employeeSearchByNamePost(@ModelAttribute @Valid EmployeeSearchByNameForm form, Model model,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("form", form);
			return "employeeSearchByName";
		}

		if (Strings.isBlank(form.getFirstName()))
			form.setFirstName("*");

		if (Strings.isBlank(form.getLastName()))
			form.setLastName("*");

		return "redirect:/employee/named/" + form.getFirstName() + "/" + form.getLastName();
	}

	@GetMapping({ "/salary/{empNo}/{fromDate}", "/salary/{empNo}/{fromDate}/{success}" })
	public ModelAndView salaryGet(@PathVariable String empNo, @PathVariable String fromDate,
			@PathVariable String success) throws NumberFormatException, ParseException {

		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");

		Optional<Salary> salaryOpt = salaryRepository
				.findById(new SalaryId(Integer.valueOf(empNo), sdFormat.parse(fromDate)));

		if (salaryOpt.isPresent()) {
			ModelAndView mav = new ModelAndView("salary");
			mav.getModel().put("salary", new SalaryForm(salaryOpt.get()));
			return mav;
		} else
			return new ModelAndView("redirect:/salarySearch/" + empNo + "/notFound");
	}

	@PostMapping("/salary/{empNo}/{fromDate}")
	public String salaryPost(@PathVariable String empNo, @PathVariable String fromDate,
			@ModelAttribute SalaryForm salary, BindingResult result) throws ParseException {

		salaryRepository.save(salary.convertToEntity());

		return "redirect:/salarySearch";
	}

	@GetMapping({ "/salarySearch", "/salarySearch/{id}", "/salarySearch/{id}/{message}" })
	public ModelAndView salarySearchGet(@PathVariable(required = false) String message,
			@PathVariable(required = false) Integer id) {

		ModelAndView mav = new ModelAndView();
		if ("notFound".equals(message)) {
			mav.addObject("notFound", "true");
		}

		if (mav.getModel().get("form") == null) {
			mav.addObject("form", new SalarySearchForm());
			mav.addObject("id", id);
		}
		mav.setViewName("salarySearch");
		return mav;
	}

	@PostMapping("/salarySearch")
	public ModelAndView salarySearchPost(@ModelAttribute SalarySearchForm form, BindingResult bindingResult) {

		if (Strings.isBlank(form.getFromDate()) || Strings.isBlank(form.getEmpNo()) || bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("salarySearch");
			mav.addObject("form", form);
			return mav;
		}

		return new ModelAndView("redirect:/salary/" + form.getEmpNo() + "/" + form.getFromDate());
	}

	@GetMapping("/elvis")
	public ModelAndView listElvisEmployees() {
		ModelAndView mav = new ModelAndView("elvis");
		List<Employee> elvisList = employeeRepository.findByFirstNameContainingIgnoreCase("Elvis",
				PageRequest.of(0, 1000));
		mav.addObject("elvisList", elvisList);

		return mav;
	}

	@GetMapping("/elvis/change")
	public String changeElvisEmployeesGet() {
		return "changeElvis";
	}

	@PostMapping("/elvis/change")
	public String changeElvisEmployeesPost() {
		employeeDAO.changeElvises();

		return "redirect:/elvis";
	}

	@GetMapping({ "/employee/named/{firstName}/{lastName}", "/employee/named/{firstName}" })
	public ModelAndView findEmployeesByNames(@PathVariable String firstName,
			@PathVariable(required = false) String lastName) {
		if (lastName == null)
			lastName = "*";

		ModelAndView mav = new ModelAndView("employees");
		List<EmployeeForm> list;

		if ("*".equals(firstName)) {
			if ("*".equals(lastName)) {
				list = employeeRepository.findTop100By().stream().map(EmployeeForm::new).collect(Collectors.toList());
			} else {
				list = employeeRepository.findByLastName(lastName).stream().map(EmployeeForm::new)
						.collect(Collectors.toList());
			}
		} else {
			if ("*".equals(lastName)) {
				list = employeeRepository.findByFirstName(firstName).stream().map(EmployeeForm::new)
						.collect(Collectors.toList());
			} else {
				list = employeeRepository.findByFirstNameAndLastName(firstName, lastName).stream()
						.map(EmployeeForm::new).collect(Collectors.toList());
			}
		}
		mav.getModel().put("list", list);

		for (EmployeeForm employeeForm : list) {
			mav.addObject(employeeForm.getEmpNo().toString(), employeeForm);
		}

		return mav;
	}

	@PostMapping("/deleteEmployee/{empNo}")
	public String deleteEmployeePost(HttpServletRequest request, @PathVariable Integer empNo) {

		employeeRepository.deleteByEmpNo(empNo);
		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}

	@GetMapping("/salaries/{empNo}")
	public ModelAndView showSalariesGet(HttpServletRequest request, @PathVariable Integer empNo) {

		ModelAndView mav = new ModelAndView();
		List<SalaryForm> salaries = salaryRepository.findByIdEmpNo(empNo).stream().map(SalaryForm::new)
				.collect(Collectors.toList());
		mav.addObject("salaries", salaries);
		mav.setViewName("salaries");
		mav.addObject("employee", employeeRepository.findById(empNo).get());

		for (SalaryForm salary : salaries) {
			mav.addObject(salary.getFromDate(), salary);
		}

		return mav;
	}

	@PostMapping("/salary")
	public String salaryPost(@ModelAttribute SalaryForm salary, BindingResult result) throws ParseException {

		salaryRepository.save(salary.convertToEntity());

		return "redirect:/salary/" + salary.getEmpNo() + "/" + salary.getFromDate() + "/success";
	}
	
	@PostMapping("/deleteSalary/{empNo}/{fromDate}")
	public String deleteSalaryFromDatePost(HttpServletRequest request, @PathVariable Integer empNo, @PathVariable String fromDate) throws ParseException {
		
		salaryRepository.deleteById(new SalaryId(empNo, DateContainer.valueOf(fromDate).date));
		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}
	
}
