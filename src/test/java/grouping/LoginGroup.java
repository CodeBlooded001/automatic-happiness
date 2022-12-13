package grouping;

import org.testng.annotations.Test;

public class LoginGroup {

	@Test(priority=1,groups= {"smoke","sanity","regression","login","all"})
	public void LoginWithValidCredentials() {
		System.err.println("Login With Valid Credentials - Login");
	}
	@Test(priority=2,groups= {"sanity","regression","login","all"})
	public void LoginWithInValidCredentials() {
		System.err.println("Login With Invalid Credentials - Login");
	}
	@Test(priority=3,groups= {"sanity","regression","login","all"})
	public void LoginWithValidUserNameAndInvalidPassword() {
		System.err.println("Login With Valid UserName And Invalid Password- Login");
	}
	@Test(priority=4,groups= {"sanity","regression","login","all"})
	public void LoginWithInValidUserNameAndValidPassword() {
		System.err.println("Login With InValid UserName And Valid Password - Login");
	}
	@Test(priority=5,groups= {"smoke","regression","login","all"})
	public void LoginWithNoCredentials() {
		System.err.println("Login With No Credentials - Login");
	}
	
}
