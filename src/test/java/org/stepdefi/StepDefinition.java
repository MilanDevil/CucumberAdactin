package org.stepdefi;

import org.test.BaseClass;
import org.test.LoginPages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition extends BaseClass {

	@Given("User is on the Adactin page")
	public void user_is_on_the_Adactin_page() {
	getDriver();
	url("https://adactinhotelapp.com/");
	
	  
	    
	}

	@When("User try to login {string} and {string}")
	public void user_try_to_login_and(String username, String password) {
		LoginPages lp = new LoginPages();
		lp.launch(username, password);
	}

	@Then("User should verify success messsage")
	public void user_should_verify_success_messsage() {
	    
	}


}
