package example.com.dbauth.rest;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
//@XmlRootElement(name = "ctofservice") //comment out for json format
public class Response {
    private Double celsius;
    private String ctofoutput;
}
