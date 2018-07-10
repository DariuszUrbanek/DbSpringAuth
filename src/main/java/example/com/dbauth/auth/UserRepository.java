package example.com.dbauth.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import example.com.dbauth.entity.SpringUser;

public interface UserRepository extends JpaRepository<SpringUser, String> {
	
	SpringUser findByUsername(String username);
}
