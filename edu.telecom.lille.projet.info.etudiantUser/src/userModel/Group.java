/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;

import java.util.Hashtable;
import java.util.Map;
import userModel.Student;

/**
 * La classe Group repr�sente les groupes d'�tudiants.
 * 
 * @author Hugo Marcq
 * @version 06/2016
 * 
 */
public class Group {
	
	/**
	 * Contient la table d'�tudiants appartenant au groupe courant.
	 */
	public Hashtable groupTable;
	
	/**
	 * Contient l'identifiant du groupe courant.
	 */
	private int groupID;
	
	/**
	 * Contient le nombre d'�tudiants du groupe courant.
	 */
	private int nbStudents;

	/**
	 * Contructeur de Group permettant de cr�er un groupe d'�tudiants, qui contient son identifiant en param�tre.
	 * 
	 * @param groupID
	 * 		Entier correspondant � l'identifiant du groupe.
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
	 * Retourne le nombre d'�tudiants pr�sents dans le groupe courant.
	 * 
	 * @return nbStudents 
	 */
	public int getNbStudents() {//Attention, ajouter ceux d�j� pr�sents dans la DB
		return this.nbStudents;
	}
	
	/**
	 * M�thode permettant d'ajouter un �tudiant � la Hashtable contenant les �tudiants du groupe.
	 * 
	 * @param studentToAdd 
	 * 		L'objet �tudiant � ajouter au groupe.
	 */
	public void addStudentToGroup(Student studentToAdd) {
		if (this.groupTable.get(studentToAdd.getStudentID()) == null) {
			this.groupTable.put(studentToAdd.getStudentID(), studentToAdd);
			studentToAdd.setGroupID(this.groupID);
			++this.nbStudents;
		}
	}
	
	/**
	 * M�thode permettant de retirer un �tudiant de la Hashtable contenant les �tudiants du groupe.
	 * 
	 * @param studentToRemove 
	 * 		L'objet �tudiant � supprimer du groupe.
	 */
	public void removeStudentFromGroup(Student studentToRemove) {
		if (this.groupTable.get(studentToRemove.getStudentID()) != null) {
			studentToRemove.setGroupID(-1);
			this.groupTable.remove(studentToRemove.getStudentID());
			--this.nbStudents;
		}
	}

	/**
	 * Retourne la table contenant les �tudiants appartenant au groupe.
	 * 
	 * @return groupTable 
	 */
	public Hashtable getStudentsFromGroup() {
		return this.groupTable;
	}
	
}
