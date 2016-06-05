/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;

import userModel.User;

/**
 * La classe Student repr�sente les �tudiants.
 * Elle h�rite de "User" puiqu'un �tudiant est simplement un utilisateur b�n�ficiant de fonctionnalit�s particuli�res.
 * 
 * @author Hugo Marcq
 * @version 06/2016
 * 
 */
public class Student extends User {

	/**
	 * Contient l'identifiant de l'�tudiant courant.
	 */
	protected int studentID;
	/**
	 * Contient l'identifiant de groupe de l'�tudiant courant.
	 */
	protected int groupID;

	/**
	 * Contructeur de Student permettant la cr�ation d'un �tudiant n'appartenant pas � un groupe, qui contient toutes ses informations en param�tres.
	 * 
	 * @param studentID
	 * 		Entier correspondant � l'identifiant de l'�tudiant.
	 * @param login
	 * 		Cha�ne de caract�res correspondant au login de l'�tudiant.
	 * @param pwd
	 * 		Cha�ne de caract�res correspondant au mot de passe de l'�tudiant.
	 * @param firstname
	 * 		Cha�ne de caract�res correspondant au pr�nom de l'�tudiant.
	 * @param surname
	 * 		Cha�ne de caract�res correspondant au nom de l'�tudiant.
	 */
	public Student(int studentID, String login, String pwd, String firstname, String surname) {
		super(login, pwd, firstname, surname);
		this.studentID = studentID;
		this.groupID = -1;
	}
	
	/**
	 * Contructeur de Student permettant la cr�ation d'un �tudiant appartenant � un groupe, qui contient toutes ses informations en param�tres.
	 * 
	 * @param studentID
	 * 		Entier correspondant � l'identifiant de l'�tudiant.
	 * @param login
	 * 		Cha�ne de caract�res correspondant au login de l'�tudiant.
	 * @param pwd
	 * 		Cha�ne de caract�res correspondant au mot de passe de l'�tudiant.
	 * @param firstname
	 * 		Cha�ne de caract�res correspondant au pr�nom de l'�tudiant.
	 * @param surname
	 * 		Cha�ne de caract�res correspondant au nom de l'�tudiant.
	 * @param groupID
	 * 		Entier correspondant au groupe auquel appartient l'�tudiant.
	 */
	public Student(int studentID, String login, String pwd, String firstname, String surname, int groupID) {
		super(login, pwd, firstname, surname);
		this.studentID = studentID;
		this.groupID = groupID;
	}

	/**
	 * Retourne l'ID de l'�tudiant, l'attribut studentID.
	 * 
	 * @return studentID.
	 */
	public int getStudentID() {
		return this.studentID;
	}

	/**
	 * Affecte une valeur � l'attribut studentID, l'ID de l'�tudiant.
	 * 
	 * @param newStudentID
	 * 		Entier correspondant � l'identifiant d'�tudiant qui sera affect� � l'�tudiant courant.
	 */
	public void setStudentID(Integer newStudentID) {
		this.studentID = newStudentID;
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
	 * Affecte une valeur � l'attribut groupID, l'ID du groupe.
	 * 
	 * @param newGroupID
	 * 		Entier correspondant � l'identifiant de groupe qui sera affect� au groupe courant.
	 */
	public void setGroupID(int newGroupID) {
		this.groupID = newGroupID;
	}

}
