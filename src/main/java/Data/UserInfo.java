package Data;

import com.github.javafaker.Faker;

import Utilities.Log;

public class UserInfo {
	Faker fakeData = new Faker();
	String email = fakeData.internet().emailAddress();
	String firstname = fakeData.name().firstName();
	String lastName = fakeData.name().lastName();
	String password = fakeData.number().digits(5).toString();
	// int day = fakeData.number().randomDigit();
	String day = fakeData.name().name();// fakeData.date().birthday().toString();
	String month = fakeData.name().name();
	String year = fakeData.name().name();// fakeData.number().digits(4).toString();
	String company = fakeData.company().name();
	String mainAddress = fakeData.address().fullAddress();
	String secondAddress = fakeData.address().secondaryAddress();
	String cityField = fakeData.address().city();
	String stateField = fakeData.address().state();
	String postCode = fakeData.number().digits(5).toString();
	// private String other;
	// private String phone;
	String mobile = fakeData.phoneNumber().cellPhone();
	String addressAlias = fakeData.name().username();

	public void userInfo(String firstname, String lastname, String pw, String aDay, String aMonth, String aYear,
			String companyName, String address1, String address2, String city, String state, String postcode,
			String mobileNumber, String addressNiceName) {
		this.firstname = firstname;
		this.lastName = lastname;
		this.password = pw;
		this.day = aDay;
		this.month = aMonth;
		this.year = aYear;
		this.company = companyName;
		this.mainAddress = address1;
		this.secondAddress = address2;
		this.cityField = city;
		this.stateField = state;
		this.postCode = postcode;
		this.mobile = mobileNumber;
		this.addressAlias = addressNiceName;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		Log.info("email" + email.toString());

	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;

	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getMainAddress() {
		return mainAddress;
	}

	public void setMainAddress(String mainAddress) {
		this.mainAddress = mainAddress;
	}

	public String getSecondAddress() {
		return secondAddress;
	}

	public void setSecondAddress(String secondAddress) {
		this.secondAddress = secondAddress;
	}

	public String getCityField() {
		return cityField;
	}

	public void setCityField(String cityField) {
		this.cityField = cityField;
	}

	public String getStateField() {
		return stateField;
	}

	public void setStateField(String stateField) {
		this.stateField = stateField;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddressAlias() {
		return addressAlias;
	}

	public void setAddressAlias(String addressAlias) {
		this.addressAlias = addressAlias;
	}

}
