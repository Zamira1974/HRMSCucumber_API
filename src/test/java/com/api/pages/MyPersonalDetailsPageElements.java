package com.api.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.api.testbase.BaseClass;

public class MyPersonalDetailsPageElements {

	@FindBy(id="empPic")
	public WebElement empPicture;
	
	@FindBy(xpath="//div[@id='profile-pic']/h1")
	public WebElement nameOnPicture;
	
	@FindBy(xpath="//span[contains(@for, 'personal_txtEmpFirstName')]")
	public WebElement requiredFN;
	
	@FindBy(xpath="//span[contains(@for, 'personal_txtEmpLastName')]")
	public WebElement requiredLN;
	
	@FindBy(id="personal_txtEmployeeId")
	public WebElement empId;
	
	@FindBy(id="personal_txtLicenNo")
	public WebElement licenseNum;
	
	@FindBy(id="personal_txtLicExpDate")
	public WebElement licExpDate;
	
	@FindBy(id="personal_txtNICNo")
	public WebElement SSN;
	
	@FindBy(id="personal_txtSINNo")
	public WebElement SIN;
	
	@FindBy(xpath="//label[contains(@for, 'personal_optGender')]")
	public List<WebElement> gender;
	
	@FindBy(id="personal_cmbMarital")
	public WebElement maritalStatus;
	
	@FindBy(id="personal_cmbNation")
	public WebElement nationality;
	
	@FindBy(id="personal_DOB")
	public WebElement DOB;
	
	@FindBy(id="btnSave")
	public WebElement edit_saveBtn;
	
	
	public MyPersonalDetailsPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
}
