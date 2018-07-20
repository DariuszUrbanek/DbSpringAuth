package example.com.dbauth.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import example.com.dbauth.dao.EmployeeDAO;
import example.com.dbauth.data.EmployeeRepository;
import example.com.dbauth.data.SalaryRepository;
import example.com.dbauth.entity.Employee;
import example.com.dbauth.entity.Salary;
import example.com.dbauth.entity.SalaryId;
import example.com.dbauth.form.EmployeeForm;
import example.com.dbauth.form.EmployeeSearchForm;
import example.com.dbauth.form.SalaryForm;
import example.com.dbauth.form.SalarySearchForm;

@Controller
@Secured({ "ROLE_USER", "ROLE_ADMIN" })
public class CompanyController {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	SalaryRepository salaryRepository;

	@Autowired
	EmployeeDAO employeeDAO;

	@GetMapping("/home")
	public String homePage() {		
		
		return "home";
	}
	
	@GetMapping("/employee/{empNo}")
	public ModelAndView employeeGet(@PathVariable String empNo) {
		Optional<Employee> employeeOpt = employeeRepository.findById(Integer.valueOf(empNo));
		if (employeeOpt.isPresent()) {
			ModelAndView mav = new ModelAndView("employee");
			mav.getModel().put("employee", new EmployeeForm(employeeOpt.get()));
			return mav;
		} else
			return new ModelAndView("redirect:/employeeSearch/notFound/" + empNo);
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

		if (bindingResult.hasErrors()) {
			model.addAttribute("form", form);
			return "employeeSearch";
		}

		return "redirect:/employee/" + form.getEmpNo();
	}

	@GetMapping("/salary/{empNo}/{fromDate}")
	public ModelAndView salaryGet(@PathVariable String empNo, @PathVariable String fromDate)
			throws NumberFormatException, ParseException {

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

		mav.addObject("form", new SalarySearchForm());
		mav.addObject("id", id);
		mav.setViewName("salarySearch");
		return mav;
	}

	@PostMapping("/salarySearch")
	public String salarySearchPost(@ModelAttribute SalarySearchForm form, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "salarySearch";
		}

		return "redirect:/salary/" + form.getEmpNo() + "/" + form.getFromDate();
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

	@GetMapping("/employee/named/{firstName}/{lastName}")
	public ModelAndView findEmployeesByNames(@PathVariable String firstName, @PathVariable String lastName) {
		ModelAndView mav = new ModelAndView("employees");
		List<Employee> list = employeeRepository.findByFirstNameAndLastName(firstName, lastName);
		mav.getModel().put("list", list);
		
		return mav;
	}
	
}
