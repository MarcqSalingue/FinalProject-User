/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;

import userModel.User;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Teacher.
 * 
 * @author humar
 */
public class Teacher extends User {
	/**
	 * Description of the property teacherID.
	 */
	private int teacherID;

	// Start of user code (user defined attributes for Teacher)

	// End of user code

	/**
	 * The constructor.
	 */
	public Teacher(int teacherID, String login, String pwd, String firstname, String surname) {
		super(login, pwd, firstname, surname);
		this.teacherID = teacherID;
	}

	/**
	 * Returns teacherID.
	 * @return teacherID 
	 */
	public int getTeacherID() {
		return this.teacherID;
	}

	/**
	 * Sets a value to attribute teacherID. 
	 * @param newTeacherID 
	 */
	public void setTeacherID(Integer newTeacherID) {
		this.teacherID = newTeacherID;
	}

}
