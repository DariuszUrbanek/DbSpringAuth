package example.com.dbauth.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import example.com.dbauth.entity.SpringRole;

public interface RoleRepository extends JpaRepository<SpringRole, String> {
	

}
