package org.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPages extends BaseClass {
	public LoginPages() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement txtusername;
	
	@FindBy(id="password")
	private WebElement txtPassword;
	
	@FindBy(id="login")
	private WebElement btnlogin;

	public WebElement getTxtusername() {
		return txtusername;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnlogin() {
		return btnlogin;
	}
	
	public void launch(String username,String password) {
   enterText(getTxtusername(), username);
   enterText(getTxtPassword(), password);
   submit(getBtnlogin());
	}
	
	
}
