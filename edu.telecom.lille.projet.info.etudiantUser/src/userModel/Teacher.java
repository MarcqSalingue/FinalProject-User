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
	protected Integer teacherID = Integer.valueOf(0);

	// Start of user code (user defined attributes for Teacher)

	// End of user code

	/**
	 * The constructor.
	 */
	public Teacher() {
		// Start of user code constructor for Teacher)
		super();
		// End of user code
	}

	/**
	 * Description of the method getTeacherID.
	 * @param adminLogin 
	 * @param teacherLogin 
	 */
	public void getTeacherID(String adminLogin, Integer teacherLogin) {
		// Start of user code for method getTeacherID
		// End of user code
	}

	// Start of user code (user defined methods for Teacher)

	// End of user code
	/**
	 * Returns teacherID.
	 * @return teacherID 
	 */
	public Integer getTeacherID() {
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
