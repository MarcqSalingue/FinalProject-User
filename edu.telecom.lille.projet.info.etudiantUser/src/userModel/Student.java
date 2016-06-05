/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;

import userModel.User;

/**
 * La classe Student représente les étudiants.
 * Elle hérite de "User" puiqu'un étudiant est simplement un utilisateur bénéficiant de fonctionnalités particulières.
 * 
 * @author Hugo Marcq - Joffrey Salingue
 * @version 06/2016
 * 
 */
public class Student extends User {

	/**
	 * Contient l'identifiant de l'étudiant courant.
	 */
	protected int studentID;
	/**
	 * Contient l'identifiant de groupe de l'étudiant courant.
	 */
	protected int groupID;

	/**
	 * Contructeur de Student permettant la création d'un étudiant n'appartenant pas à un groupe, qui contient toutes ses informations en paramètres.
	 * 
	 * @param studentID
	 * 		Entier correspondant à l'identifiant de l'étudiant.
	 * @param login
	 * 		Chaîne de caractères correspondant au login de l'étudiant.
	 * @param pwd
	 * 		Chaîne de caractères correspondant au mot de passe de l'étudiant.
	 * @param firstname
	 * 		Chaîne de caractères correspondant au prénom de l'étudiant.
	 * @param surname
	 * 		Chaîne de caractères correspondant au nom de l'étudiant.
	 */
	public Student(int studentID, String login, String pwd, String firstname, String surname) {
		super(login, pwd, firstname, surname);
		this.studentID = studentID;
		this.groupID = -1;
	}
	
	/**
	 * Contructeur de Student permettant la création d'un étudiant appartenant à un groupe, qui contient toutes ses informations en paramètres.
	 * 
	 * @param studentID
	 * 		Entier correspondant à l'identifiant de l'étudiant.
	 * @param login
	 * 		Chaîne de caractères correspondant au login de l'étudiant.
	 * @param pwd
	 * 		Chaîne de caractères correspondant au mot de passe de l'étudiant.
	 * @param firstname
	 * 		Chaîne de caractères correspondant au prénom de l'étudiant.
	 * @param surname
	 * 		Chaîne de caractères correspondant au nom de l'étudiant.
	 * @param groupID
	 * 		Entier correspondant au groupe auquel appartient l'étudiant.
	 */
	public Student(int studentID, String login, String pwd, String firstname, String surname, int groupID) {
		super(login, pwd, firstname, surname);
		this.studentID = studentID;
		this.groupID = groupID;
	}

	/**
	 * Retourne l'ID de l'étudiant, l'attribut studentID.
	 * 
	 * @return studentID.
	 */
	public int getStudentID() {
		return this.studentID;
	}

	/**
	 * Affecte une valeur à l'attribut studentID, l'ID de l'étudiant.
	 * 
	 * @param newStudentID
	 * 		Entier correspondant à l'identifiant d'étudiant qui sera affecté à l'étudiant courant.
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
	 * Affecte une valeur à l'attribut groupID, l'ID du groupe.
	 * 
	 * @param newGroupID
	 * 		Entier correspondant à l'identifiant de groupe qui sera affecté au groupe courant.
	 */
	public void setGroupID(int newGroupID) {
		this.groupID = newGroupID;
	}

}
