package example.com.dbauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

    @GetMapping("/add/{number1}/{number2}")
    public ModelAndView addTwoNumbers(@PathVariable String number1, @PathVariable String number2) {

        ModelAndView mav = new ModelAndView("addition");
        mav.getModel().put("number1", number1);
        mav.getModel().put("number2", number2);

        return mav;
    }

    @GetMapping("/multiply/{number1}/{number2}")
    public String multiplyTwoNumbers(@PathVariable Integer number1, @PathVariable Integer number2, Model model) {

        // model.addAttribute(number1); // not needed as numbers are passed by arguments
        // model.addAttribute(number2);
        int result = number1 * number2;
        model.addAttribute("result", result);

        return "multiply";
    }

}
