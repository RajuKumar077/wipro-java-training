package objectrepository;

import java.util.Properties;

import org.openqa.selenium.By;

import utils.PropertyReader;

public class Locators {
	static Properties prop = PropertyReader.readProperty();
	static String year = prop.getProperty("Year");

	// locators for login page
	public static By signin_button = By.id("signin_button");
	public static By user_name = By.xpath("//input[@id='user_login']");
	public static By user_password = By.id("user_password");
	public static By submit = By.xpath("//input[@name='submit']");
	public static By invalid_alert = By.xpath("//div[@class='alert alert-error']");

	// Locators for Home Page
	public static By Home = By.xpath("//strong[contains(text(), 'Home')]");
	public static By OnlineBanking = By.xpath("//strong[text()='Online Banking']");

	// Locators for OnlineBanking Page
	public static By Account_Summery = By.id("account_summary_link");
	public static By Transfer_fund = By.id("transfer_funds_link");
	public static By Pay_bills = By.id("pay_bills_link");
	public static By Online_Statement = By.id("online_statements_link");
	
	//Locators for Account Summary Page
	   
    public static final By ACCOUNT_SUMMARY_LINK = By.id("account_summary_link");
    public static final By CASH_ACCOUNTS = By.xpath("//h2[text()='Cash Accounts']");
    public static final By INVESTMENT_ACCOUNTS = By.xpath("//h2[text()='Investment Accounts']");
    public static final By CREDIT_ACCOUNTS = By.xpath("//h2[text()='Credit Accounts']");
    public static final By LOAN_ACCOUNTS = By.xpath("//h2[text()='Loan Accounts']");
    

	// Locators for Transfer Fund Page
	public static By From_Account = By.id("tf_fromAccountId");
	public static By To_Account = By.id("tf_toAccountId");
	public static By Amount = By.cssSelector("input[required]");
	public static By Continue = By.xpath("//button[text()='Continue']");
	public static By TF_submit = By.xpath("//button[text()='Submit']");
	public static By Success_msg = By.xpath("//div[@class='alert alert-success']");

	// Locators for Pay Bill
	public static By Pay_Bill = By.xpath("//a[contains(@href, 'pay-bills.html')]");
	public static By Payee_Dropdown = By.id("sp_payee");
	public static By Account_Dropdown = By.id("sp_account");
	public static By Amount_Input = By.id("sp_amount");
	public static By Date_Input = By.id("sp_date");
	public static By Calendar_Next = By.xpath("//a[@class='ui-datepicker-next']");
	public static By Calendar_Title = By.className("ui-datepicker-title");
	public static By Calendar_Day_27 = By
			.xpath("//td[@data-handler='selectDay' and @data-month='2' and @data-year='2025']/a[text()='27']");
	public static By Pay_Button = By.id("pay_saved_payees");
	public static By Confirmation_Message = By
			.xpath("//span[contains(text(), 'The payment was successfully submitted.')]");

	// Locator for the "Add New Payee"
	public static By Add_New_Payee_Tab = By.xpath("//a[@href='#ui-tabs-2']");
	public static By New_Payee_Name = By.id("np_new_payee_name");
	public static By New_Payee_Address = By.id("np_new_payee_address");
	public static By New_Payee_Account = By.id("np_new_payee_account");
	public static By Add_New_Payee_Button = By.id("add_new_payee");
	public static final By New_Payee_Confirmation = By.id("alert_content");

	// Locators for Online Statement
	public static By OnlineStatement = By.id("online_statements_link");
	public static By OnlineStatementLoadSuccess = By.xpath("//h2[text()='Statements & Documents']");
	public static By AccountTypeOnlineStatment = By.id("os_accountId");
	public static By StatementDiv = By.id("online_statements_for_account");
	public static By StatementYear = By.xpath("(//li)/child::a[text()='" + year + "']");
	public static By StatementYearVerifier = By.xpath("//li[@class='active']/a[text()='" + year + "']");
	public static By StatementDownloadLink = By.xpath("(//td/a[contains(text(),11)])[1]");

}