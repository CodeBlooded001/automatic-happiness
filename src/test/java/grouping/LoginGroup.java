package grouping;

import org.testng.annotations.Test;

public class LoginGroup {

	@Test
	public void LoginWithValidCredentials() {
		System.err.println("Login With Valid Credentials - Login");
	}
	@Test
	public void LoginWithInValidCredentials() {
		System.err.println("Login With Invalid Credentials - Login");
	}
	@Test
	public void LoginWithValidUserNameAndInvalidPassword() {
		System.err.println("Login With Valid UserName And Invalid Password- Login");
	}
	@Test
	public void LoginWithInValidUserNameAndValidPassword() {
		System.err.println("Login With InValid UserName And Valid Password - Login");
	}
	@Test
	public void LoginWithNoCredentials() {
		System.err.println("Login With No Credentials - Login");
	}
	
}
