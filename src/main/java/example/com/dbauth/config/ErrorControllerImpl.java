package example.com.dbauth.config;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorControllerImpl implements ErrorController {

	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
		switch ((Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)) {
		case 403: //access forbidden, redirecting to login page
			return "redirect:/login";
		default:
			return "error";
		}

	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

}
