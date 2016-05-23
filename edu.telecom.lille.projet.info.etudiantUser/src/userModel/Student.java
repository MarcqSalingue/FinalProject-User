/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;

import userModel.User;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Student.
 * 
 * @author humar
 */
public class Student extends User {
	/**
	 * Description of the property studentID.
	 */
	protected Integer studentID = Integer.valueOf(0);

	/**
	 * Description of the property groupID.
	 */
	protected String groupID = "";

	// Start of user code (user defined attributes for Student)

	// End of user code

	/**
	 * The constructor.
	 */
	public Student() {
		// Start of user code constructor for Student)
		super();
		// End of user code
	}

	/**
	 * Description of the method getStudentID.
	 * @param adminLogin 
	 * @param studentLogin 
	 */
	public void getStudentID(String adminLogin, String studentLogin) {
		// Start of user code for method getStudentID
		// End of user code
	}

	/**
	 * Description of the method getGroupID.
	 * @param adminLogin 
	 * @param studentLogin 
	 */
	public void getGroupID(String adminLogin, String studentLogin) {
		// Start of user code for method getGroupID
		// End of user code
	}

	// Start of user code (user defined methods for Student)

	// End of user code
	/**
	 * Returns studentID.
	 * @return studentID 
	 */
	public Integer getStudentID() {
		return this.studentID;
	}

	/**
	 * Sets a value to attribute studentID. 
	 * @param newStudentID 
	 */
	public void setStudentID(Integer newStudentID) {
		this.studentID = newStudentID;
	}

	/**
	 * Returns groupID.
	 * @return groupID 
	 */
	public String getGroupID() {
		return this.groupID;
	}

	/**
	 * Sets a value to attribute groupID. 
	 * @param newGroupID 
	 */
	public void setGroupID(String newGroupID) {
		this.groupID = newGroupID;
	}

}
