package example.com.dbauth.auth;

import javax.validation.constraints.NotEmpty;

public class UserDataForm {
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	@NotEmpty
	private String passwordRepeated;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRepeated() {
		return passwordRepeated;
	}

	public void setPasswordRepeated(String passwordRepeated) {
		this.passwordRepeated = passwordRepeated;
	}

}
