package example.com.dbauth.auth;

import example.com.dbauth.entity.SpringUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SpringUser, String> {

    SpringUser findByUsername(String username);
}
