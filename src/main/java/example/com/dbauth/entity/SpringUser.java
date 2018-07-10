package example.com.dbauth.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class SpringUser {
	@Id
	public String username;
	
	public String password;
	
	@ManyToMany
	public List<SpringRole> roles;


}
