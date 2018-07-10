package example.com.dbauth.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class SpringRole {
	@Id
	public String name;
	
	@ManyToMany(mappedBy="roles")
	List<SpringUser> users;
}
