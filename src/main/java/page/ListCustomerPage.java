package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ListCustomerPage extends BasePage {
	WebDriver driver;
	public ListCustomerPage (WebDriver driver) {
		this.driver = driver;
	}
	@FindBy(how = How.XPATH, using = "//input[@id='account']")WebElement FULLNAME_FIELD;
	@FindBy(how = How.XPATH, using ="//select[@id='cid']")WebElement COMPANYNAME_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='email']")WebElement EMAILID_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']")WebElement PHONE_NUM_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='address']")WebElement ADDRESS_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='city']")WebElement CITY_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='state']")WebElement STATE_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']")WebElement ZIP_CODE_FIELD;
	@FindBy(how = How.XPATH, using = "//select[@id='country']")WebElement COUNTRY_FIELD;
	@FindBy(how = How.XPATH, using = "//button[@class='md-btn md-btn-primary waves-effect waves-light']")WebElement SAVE_BUTTON_FIELD;
	@FindBy(how = How.XPATH, using = "//a[@id='summary']")WebElement SUMMARY_FIELD;
	@FindBy(how = How.XPATH, using = "//a[@class ='btn btn-success']")WebElement ADD_CUSTOMER_ON_LISTCUSTOMER ;
	@FindBy(how = How.XPATH, using = "//input[@class ='form-control']") WebElement SEARCH_BAR_ON_LIST_CUSTOMER;
	//@FindBy(how = How.XPATH, using = "//i[@class='fa fa-search']") WebElement SUMMARY_BUTTON_ON_LISTCUSTOMERS;
	String enteredname;
	
	public void enterFullName(String fullname) {
		waitforElement(driver,10,FULLNAME_FIELD);
		enteredname =	fullname + generaterandomNumber(999);
		FULLNAME_FIELD.sendKeys( enteredname );	
	}
	
	public void enterCompany(String company) {
		selectDropDown(COMPANYNAME_FIELD,company);
	}
	public void enterEmailId(String email) {
		EMAILID_FIELD.sendKeys(generaterandomNumber(999)+email);
	}
	
	
	public void enterPhoneNumber(String phonenum) {
		PHONE_NUM_FIELD.sendKeys(phonenum+generaterandomNumber(999));
	}
	public void enterAddress(String address) {
		ADDRESS_FIELD.sendKeys(address);
	}
	
	public void enterCity(String city) {
		CITY_FIELD.sendKeys(city);
	}
	public void enterState(String state) {
		STATE_FIELD.sendKeys(state);
	}
	public void enterZipcode(String zipcode) {
		ZIP_CODE_FIELD.sendKeys(zipcode);
	}
	public void selectCountry(String country) {
		selectDropDown(COUNTRY_FIELD,country);
	}
	public void clickSaveButton() {
		SAVE_BUTTON_FIELD.click();
	
	}
public void clickAddCustomerOnListCustomer() {
	ADD_CUSTOMER_ON_LISTCUSTOMER.click();
		
	}
	
 public void insertNameOnSearchBar() {	
   SEARCH_BAR_ON_LIST_CUSTOMER.sendKeys(enteredname);
  }
	
	
 public void testListCustomerSummaryButton() {
		String before_xpath = "//tbody/tr[";
	    String after_xpath	= "]/td[3]"	;
		for (int i=1;i<=10;i++) {
			String name = driver.findElement(By.xpath(before_xpath+i+ after_xpath)).getText();
			/*System.out.println(name_xpath);
			Assert.assertEquals(name_xpath, entername, "entered name doesnot exist");
			break;*/
			if (name.contains(enteredname)) {
				
				System.out.println("entered name doesnot exist");
				driver.findElement(By.xpath(before_xpath + i +  "]/td[3]/following-sibling::td[4]/a[1]")).click();
				break;
			}
			}
		 }

	

}
