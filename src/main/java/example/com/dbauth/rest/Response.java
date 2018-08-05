package example.com.dbauth.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ctofservice") //comment out for json format
public class Response {
	private Double celsius;
	private String ctofoutput;
	
	public Double getCelsius() {
		return celsius;
	}
	public void setCelsius(Double celsius) {
		this.celsius = celsius;
	}
	public String getCtofoutput() {
		return ctofoutput;
	}
	public void setCtofoutput(String ctofoutput) {
		this.ctofoutput = ctofoutput;
	}
}
