/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;

import java.util.HashSet;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Group.
 * 
 * @author humar
 */
public class Group {
	/**
	 * Description of the property nbStudents.
	 */
	protected Integer nbStudents = Integer.valueOf(0);

	/**
	 * Description of the property students.
	 */
	public HashSet<Student> students = new HashSet<Student>();

	/**
	 * Description of the property groupID.
	 */
	protected Integer groupID = Integer.valueOf(0);

	// Start of user code (user defined attributes for Group)

	// End of user code

	/**
	 * The constructor.
	 */
	public Group() {
		// Start of user code constructor for Group)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Group)

	// End of user code
	/**
	 * Returns nbStudents.
	 * @return nbStudents 
	 */
	public Integer getNbStudents() {
		return this.nbStudents;
	}

	/**
	 * Sets a value to attribute nbStudents. 
	 * @param newNbStudents 
	 */
	public void setNbStudents(Integer newNbStudents) {
		this.nbStudents = newNbStudents;
	}

	/**
	 * Returns students.
	 * @return students 
	 */
	public HashSet<Student> getStudents() {
		return this.students;
	}

	/**
	 * Returns groupID.
	 * @return groupID 
	 */
	public Integer getGroupID() {
		return this.groupID;
	}

	/**
	 * Sets a value to attribute groupID. 
	 * @param newGroupID 
	 */
	public void setGroupID(Integer newGroupID) {
		this.groupID = newGroupID;
	}

}
