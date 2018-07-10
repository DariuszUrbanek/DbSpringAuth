package example.com.dbauth.auth;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import example.com.dbauth.entity.SpringUser;

public class UserPrincipal implements UserDetails {
	private static final long serialVersionUID = -2971393542317040515L;

	private SpringUser user;

	@Autowired
	UserRepository userRepository;

	public UserPrincipal(SpringUser user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return user.roles.stream().map(role -> new SimpleGrantedAuthority(role.name.toUpperCase())).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return user.password;
	}

	@Override
	public String getUsername() {
		return user.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}

