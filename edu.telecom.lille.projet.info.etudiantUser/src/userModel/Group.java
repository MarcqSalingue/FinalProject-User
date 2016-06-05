/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;

import java.util.Hashtable;
import java.util.Map;
import userModel.Student;

/**
 * La classe Group représente les groupes d'étudiants.
 * 
 * @author Hugo Marcq - Joffrey Salingue
 * @version 06/2016
 * 
 */
public class Group {
	
	/**
	 * Contient la table d'étudiants appartenant au groupe courant.
	 */
	private Hashtable groupTable;
	
	/**
	 * Contient l'identifiant du groupe courant.
	 */
	private int groupID;
	
	/**
	 * Contient le nombre d'étudiants du groupe courant.
	 */
	private int nbStudents;

	/**
	 * Contructeur de Group permettant de créer un groupe d'étudiants, qui contient son identifiant en paramètre.
	 * 
	 * @param groupID
	 * 		Entier correspondant à l'identifiant du groupe.
	 * 
	 */
	public Group(int groupID) {
		this.groupID = groupID;
		this.nbStudents = 0;
		this.groupTable = new Hashtable();
	}

	/**
	 * Retourne l'ID du groupe, l'attribut groupID.
	 * 
	 * @return groupID.
	 */
	public int getGroupID() {
		return this.groupID;
	}
	
	/**
	 * Retourne le nombre d'étudiants présents dans le groupe courant.
	 * 
	 * @return nbStudents 
	 */
	public int getNbStudents() {//Attention, ajouter ceux déjà présents dans la DB
		return this.nbStudents;
	}
	
	/**
	 * Méthode permettant d'ajouter un étudiant à la Hashtable contenant les étudiants du groupe.
	 * 
	 * @param studentToAdd 
	 * 		L'objet étudiant à ajouter au groupe.
	 */
	public void addStudentToGroup(Student studentToAdd) {
		if (this.groupTable.get(studentToAdd.getStudentID()) == null) {
			this.groupTable.put(studentToAdd.getStudentID(), studentToAdd);
			studentToAdd.setGroupID(this.groupID);
			++this.nbStudents;
		}
	}
	
	/**
	 * Méthode permettant de retirer un étudiant de la Hashtable contenant les étudiants du groupe.
	 * 
	 * @param studentToRemove 
	 * 		L'objet étudiant à supprimer du groupe.
	 */
	public void removeStudentFromGroup(Student studentToRemove) {
		if (this.groupTable.get(studentToRemove.getStudentID()) != null) {
			studentToRemove.setGroupID(-1);
			this.groupTable.remove(studentToRemove.getStudentID());
			--this.nbStudents;
		}
	}

	/**
	 * Incrémente le nombre d'étudiants dans le groupe. 
	 */
	public void IncrementStudentNb() {
		this.nbStudents = this.nbStudents + 1;
	}
	
	/**
	 * Décrémente le nombre d'étudiants dans le groupe.
	 */
	public void DecrementStudentNb() {
		this.nbStudents = this.nbStudents - 1;
	}
	
	/**
	 * Initialise la table contenant les étudiants appartenant au groupe.
	 * 
	 * @param groupTable
	 * 		Hashtable contenant les utilisateurs du groupe, à affecter à l'attribut groupTable.
	 */
	public void setGroupTable(Hashtable groupTable) {
		this.groupTable = groupTable;
	}
	
	/**
	 * Retourne la table contenant les étudiants appartenant au groupe.
	 * 
	 * @return groupTable 
	 */
	public Hashtable getStudentsFromGroup() {
		return this.groupTable;
	}
	
}
