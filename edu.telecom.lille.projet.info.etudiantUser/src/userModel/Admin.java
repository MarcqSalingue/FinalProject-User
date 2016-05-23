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
	protected Integer adminID = Integer.valueOf(0);

	// Start of user code (user defined attributes for Admin)

	// End of user code

	/**
	 * The constructor.
	 */
	public Admin(int adminID, String firstname, String surname, String login, String pwd) {
		super(firstname, surname, login, pwd, "Administrator");
	}


	/**
	 * Description of the method addAdmin.
	 * @param adminLogin 
	 * @param newAdminLogin 
	 * @param adminID 
	 * @param firstname 
	 * @param surname 
	 * @param pwd 
	 */
	public void addAdmin(String adminLogin, String newAdminLogin, Integer adminID, String firstname, String surname,
			String pwd) {
		// Start of user code for method addAdmin
		// End of user code
	}

	/**
	 * Description of the method addTeacher.
	 * @param adminLogin 
	 * @param newTeacherLogin 
	 * @param teacherID 
	 * @param firstname 
	 * @param surname 
	 */
	public void addTeacher(String adminLogin, String newTeacherLogin, Integer teacherID, String firstname,
			String surname) {
		// Start of user code for method addTeacher
		// End of user code
	}

	/**
	 * Description of the method addStudent.
	 * @param adminLogin 
	 * @param newStudentLogin 
	 * @param studentID 
	 * @param firstname 
	 * @param surname 
	 * @param pwd 
	 */
	public void addStudent(String adminLogin, String newStudentLogin, Integer studentID, String firstname,
			String surname, String pwd) {
		// Start of user code for method addStudent
		// End of user code
	}

	/**
	 * Description of the method removeUser.
	 * @param adminLogin 
	 * @param userLogin 
	 */
	public void removeUser(String adminLogin, String userLogin) {
		// Start of user code for method removeUser
		// End of user code
	}

	/**
	 * Description of the method addGroup.
	 * @param adminLogin 
	 * @param groupID 
	 */
	public void addGroup(String adminLogin, Integer groupID) {
		// Start of user code for method addGroup
		// End of user code
	}

	/**
	 * Description of the method removeGroup.
	 * @param adminLogin 
	 * @param groupID 
	 */
	public void removeGroup(String adminLogin, Integer groupID) {
		// Start of user code for method removeGroup
		// End of user code
	}

	/**
	 * Description of the method associateStudToGroup.
	 * @param adminLogin 
	 * @param studentLogin 
	 * @param groupID 
	 */
	public void associateStudToGroup(String adminLogin, String studentLogin, Integer groupID) {
		// Start of user code for method associateStudToGroup
		// End of user code
	}

	/**
	 * Description of the method getStudentGroup.
	 * @param studentLogin 
	 */
	public void getStudentGroup(String studentLogin) {
		// Start of user code for method getStudentGroup
		// End of user code
	}

	/**
	 * Returns adminID.
	 * @return adminID 
	 */
	public Integer getAdminID() {
		return this.adminID;
	}

	/**
	 * Sets a value to attribute adminID. 
	 * @param newAdminID 
	 */
	public void setAdminID(Integer newAdminID) {
		this.adminID = newAdminID;
	}

}
