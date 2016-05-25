/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;

import userModel.User;
// Start of user code  (user defined imports)

// End of user code

/**
 * Description of Admin.
 * 
 * @author humar
 */
public class Admin extends User {
	/**
	 * Description of the property adminID.
	 */
	private int adminID;

	// Start of user code (user defined attributes for Admin)

	// End of user code

	/**
	 * The constructor.
	 */
	public Admin(int adminID, String login, String pwd, String firstname, String surname) {
		super(login, pwd, firstname, surname);
		this.adminID = adminID;
	}

	/**
	 * Returns adminID.
	 * @return adminID 
	 */
	public int getAdminID() {
		return this.adminID;
	}

	/**
	 * Sets a value to attribute adminID. 
	 * @param newAdminID 
	 */
	public void setAdminID(int newAdminID) {
		this.adminID = newAdminID;
	}
	
}
