package com.api.testbase;

import com.api.pages.MyAddEmployeePageElements;
import com.api.pages.MyLoginPageElements;
import com.api.pages.MyPersonalDetailsPageElements;


public class PageInitializer extends BaseClass {

	protected static MyLoginPageElements login;
	protected static MyAddEmployeePageElements addEmployee;
	protected static MyPersonalDetailsPageElements myPersonDet;

	public static void initializeAllPage() {

		login = new MyLoginPageElements();
		addEmployee = new MyAddEmployeePageElements();
		myPersonDet = new MyPersonalDetailsPageElements();
	}
}