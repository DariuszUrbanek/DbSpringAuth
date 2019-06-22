package example.com.dbauth.auth;

import example.com.dbauth.entity.SpringRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<SpringRole, String> {

}
