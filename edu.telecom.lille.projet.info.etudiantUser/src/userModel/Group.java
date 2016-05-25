/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;

import java.util.Hashtable;
import java.util.Map;

import userModel.Student;

/**
 * Description of Group.
 * 
 * @author humar
 */
public class Group {
	
	public Hashtable groupTable;
	private int groupID;
	private int nbStudents;

	/**
	 * The constructor.
	 */
	public Group(int groupID) {
		this.groupID = groupID;
		this.nbStudents = 0;
		this.groupTable = new Hashtable();
	}

	/**
	 * Returns groupID.
	 * @return groupID 
	 */
	public int getGroupID() {
		return this.groupID;
	}
	
	/**
	 * Returns nbStudents.
	 * @return nbStudents 
	 */
	public int getNbStudents() {//Attention, ajouter ceux déjà présents dans la DB
		return this.nbStudents;
	}
	
	public void addStudentToGroup(Student studentToAdd) {
		if (this.groupTable.get(studentToAdd.getStudentID()) == null) {
			this.groupTable.put(studentToAdd.getStudentID(), studentToAdd);
			studentToAdd.setGroupID(this.groupID);
			++this.nbStudents;
		}
	}
	
	public void removeStudentFromGroup(Student studentToRemove) {
		if (this.groupTable.get(studentToRemove.getStudentID()) != null) {
			System.out.println("Je suis rentré ds Groue");
			studentToRemove.setGroupID(-1);
			this.groupTable.remove(studentToRemove.getStudentID());
			--this.nbStudents;
		}
	}

	public Hashtable getStudentsFromGroup() {
		return this.groupTable;
	}
	
}
