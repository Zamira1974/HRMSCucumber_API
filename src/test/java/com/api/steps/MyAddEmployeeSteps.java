package com.api.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.api.utils.CommonMethods;
import com.api.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class MyAddEmployeeSteps extends CommonMethods {

	String empId;

	@Given("I am logged into HRMS")
	public void i_am_logged_into_HRMS() {
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}

	@Given("I navigated to Add Employee Page")
	public void i_navigated_to_Add_Employee_Page() {
		addEmployee.navigateToAddEmployee();
	}

	@When("I add {string}, {string} and {string}")
	public void i_add_and(String firstN, String middleN, String lastN) {
		sendText(addEmployee.fName, firstN);
		sendText(addEmployee.mName, middleN);
		sendText(addEmployee.lName, lastN);
		empId = addEmployee.empId.getText();
	}

	@When("I click Save")
	public void i_click_Save() {
		click(addEmployee.saveBtn);
	}

	@Then("I see Employee has been succesfully added")
	public void i_see_Employee_has_been_succesfully_added() {
		Assert.assertEquals("Employee is NOT being added", myPersonDet.empId.getText(), empId);
	}

	@Then("I see Employee with {string}, {string} and {string} is displayed")
	public void i_see_Employee_with_and_is_displayed(String fName, String mName, String lName) {
		boolean FNdisplayed = addEmployee.fName.isDisplayed();
		Assert.assertTrue("Employee with First name is NOT displayed", FNdisplayed);

		boolean MNdisplayed = addEmployee.mName.isDisplayed();
		Assert.assertTrue("Employee with Middle name is NOT displayed", MNdisplayed);

		boolean LNdisplayed = addEmployee.lName.isDisplayed();
		Assert.assertTrue("Employee with Last name is NOT displayed", LNdisplayed);
	}

	@When("I enter employee details")
	public void i_enter_employee_details(DataTable empDetails) {
		List<Map<String, String>> empDetList = empDetails.asMaps();

		for (Map<String, String> map : empDetList) {
			sendText(addEmployee.fName, map.get("FirstName"));
			sendText(addEmployee.mName, map.get("MiddleName"));
			sendText(addEmployee.lName, map.get("LastName"));
		}
	}

	@When("I click on Edit")
	public void clickOnEdit_SaveButton() {
		click(myPersonDet.edit_saveBtn);
	}

	@Then("I am able to modify Employee Details")
	public void modifyEmployeeDetails(DataTable modifyEmpDetails) throws InterruptedException {

		List<Map<String, String>> modifyList = modifyEmpDetails.asMaps();
		for (Map<String, String> map : modifyList) {
			click(myPersonDet.edit_saveBtn);

			// passing new details to the employee
			sendText(myPersonDet.licenseNum, map.get("DriverLicense"));
			sendText(myPersonDet.licExpDate, map.get("ExpirationDate"));
			sendText(myPersonDet.SSN, map.get("SIN"));
			clickRadio(myPersonDet.gender, map.get("Gender"));
			Thread.sleep(5000);

			selectDdValue(myPersonDet.maritalStatus, map.get("MaritalStatus"));
			selectDdValue(myPersonDet.nationality, map.get("DOB"));
			sendText(myPersonDet.DOB, map.get("DOB"));
			// click on save button
			click(myPersonDet.edit_saveBtn);
		}
	}

	@When("I add firstName, middleName and last name")
	public void I_add_FN_MN_LN(String firstN, String middleN, String lastN) {
		sendText(addEmployee.fName, firstN);
		sendText(addEmployee.mName, middleN);
		sendText(addEmployee.lName, lastN);
		empId = addEmployee.empId.getText();
	}

	@When("I delete employee id")
	public void i_delete_employee_id() {
		addEmployee.empId.clear();
		click(myPersonDet.edit_saveBtn);
	}

	@Then("I see employee without employee id is being added")
	public void i_see_employee_without_employee_id_is_being_added() {

		boolean persInitials = myPersonDet.nameOnPicture.isDisplayed();
		Assert.assertTrue("Name initials is NOT displayed", persInitials);
	}

	@Then("I see required error message next to the first and last name")
	public void i_see_required_error_message_next_to_the_first_and_last_name() {
		addEmployee.fName.clear();
		boolean firstNrequired = myPersonDet.requiredFN.isDisplayed();
		Assert.assertTrue("First name Required is Not displayed", firstNrequired);

		addEmployee.lName.clear();
		boolean lastNrequired = myPersonDet.requiredLN.isDisplayed();
		Assert.assertTrue("Last name Required is Not displayed", lastNrequired);
	}

	@When("I click on create login checkbox")
	public void i_click_on_create_login_checkbox() {
		addEmployee.chkLoginBtn.click();
	}

	@When("I enter username, password and confirm password")
	public void IenterUsernamePasswordConfirm_password(DataTable userDetails) {

		List<Map<String, String>> userDList = userDetails.asMaps();
		for (Map<String, String> map : userDList) {
			sendText(addEmployee.userName, map.get("UserName"));
			sendText(addEmployee.userPwd, map.get("Password"));
			sendText(addEmployee.confPwd, map.get("ConfirmPassword"));
		}
	}
}
