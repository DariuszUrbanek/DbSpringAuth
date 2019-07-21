package example.com.dbauth.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ctofservice")
public class CtoFService {

    
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response convertCtoF() {
        Double fahrenheit;
        Double celsius = 36.8;
        fahrenheit = ((celsius * 9) / 5) + 32;

        String result = "C to F Converter Output: " + fahrenheit;

        Response response = new Response();
        response.setCelsius(celsius);
        response.setCtofoutput(result);
        return response;
    }

    @GetMapping(value = "/{c}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response convertCtoFfromInput(@PathVariable("c") Double celsius) {
        Double fahrenheit;
        fahrenheit = ((celsius * 9) / 5) + 32;
        String result = "C to F Converter Output: " + fahrenheit;
        Response response = new Response();
        response.setCelsius(celsius);
        response.setCtofoutput(result);
        return response;
    }
}
