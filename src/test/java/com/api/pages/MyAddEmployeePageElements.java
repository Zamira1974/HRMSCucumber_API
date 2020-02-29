package com.api.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.api.testbase.BaseClass;
import com.api.utils.CommonMethods;


public class MyAddEmployeePageElements extends CommonMethods{

	@FindBy(linkText = "Leave")
	public WebElement leaveLnk;

	@FindBy(linkText = "Leave List")
	public WebElement leaveList;
	
	@FindBy(linkText = "PIM")
	public WebElement pim;
	
	@FindBy(id="menu_pim_addEmployee")
	public WebElement addEmp;	
	
	@FindBy(id="firstName")
	public WebElement fName;
	
	@FindBy(id="middleName")
	public WebElement mName;
	
	@FindBy(id="lastName")
	public WebElement lName;
	
	@FindBy(id="employeeId")
	public WebElement empId;
	
	@FindBy(id="btnSave")
	public WebElement saveBtn;
	
	@FindBy(id="chkLogin")
	public WebElement chkLoginBtn;
	
	@FindBy (id="user_name")
	public WebElement userName;
	
	@FindBy(id="user_password")
	public WebElement userPwd;
	
	@FindBy(id="re_password")
	public WebElement confPwd;
	
	@FindBy(id="status")
	public WebElement status;
	
	public MyAddEmployeePageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}

	public void navigateToLeaveList() {
		jsClick(leaveLnk);
		jsClick(leaveList);
	}

	public void navigateToAddEmployee() {
		jsClick(pim);
		jsClick(addEmp);
	}
	
}
