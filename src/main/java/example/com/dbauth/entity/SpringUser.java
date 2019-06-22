package example.com.dbauth.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class SpringUser {
    @Id
    public String username;

    public String password;

    @ManyToMany
    public List<SpringRole> roles;


}
