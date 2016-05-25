/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of User.
 * 
 * @author humar
 */
public class User {

	private String login = "";
	private String pwd = "";
	private String firstname = "";
	private String surname = "";
	
	public User(String login, String pwd, String firstname, String surname) {
		this.firstname = firstname;
		this.surname = surname;
		this.login = login;
		this.pwd = pwd;
	}
	
	public User() {
	}

	/**
	 * Returns login.
	 * @return login 
	 */
	public String getLogin() {
		return this.login;
	}

	/**
	 * Sets a value to attribute login. 
	 * @param newLogin 
	 */
	public void setLogin(String newLogin) {
		this.login = newLogin;
	}

	/**
	 * Returns pwd.
	 * @return pwd 
	 */
	public String getPwd() {
		return this.pwd;
	}

	/**
	 * Sets a value to attribute pwd. 
	 * @param newPwd 
	 */
	public void setPwd(String newPwd) {
		this.pwd = newPwd;
	}

	/**
	 * Returns firstname.
	 * @return firstname 
	 */
	public String getFirstname() {
		return this.firstname;
	}

	/**
	 * Sets a value to attribute firstname. 
	 * @param newFirstname 
	 */
	public void setFirstname(String newFirstname) {
		this.firstname = newFirstname;
	}

	/**
	 * Returns surname.
	 * @return surname 
	 */
	public String getSurname() {
		return this.surname;
	}

	/**
	 * Sets a value to attribute surname. 
	 * @param newSurname 
	 */
	public void setSurname(String newSurname) {
		this.surname = newSurname;
	}

}
