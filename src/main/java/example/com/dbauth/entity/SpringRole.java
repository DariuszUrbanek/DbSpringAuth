package example.com.dbauth.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class SpringRole {
    @Id
    public String name;

    @ManyToMany(mappedBy = "roles")
    List<SpringUser> users;
}
