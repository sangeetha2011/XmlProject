package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.Dashboardpage;
import page.LoginPage;
import util.BrowserFactory;


public class Logintest {
	WebDriver driver;
	
	@Test
	@Parameters({"username","password"})
	public void validUserShouldBeAbleToLogin(String userName ,String password) {
		driver = BrowserFactory.init();
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.enterUsername(userName);
		loginpage.enterPassword(password);
		loginpage.signInButtonToLogin();
		Dashboardpage dashboardpage = PageFactory.initElements(driver,Dashboardpage.class);
		 dashboardpage.verifyDashBoardPage();
		 
	
	
	
	}
	
}
