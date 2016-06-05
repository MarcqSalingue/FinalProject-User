/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;

import userModel.User;

/**
 * La classe Teacher représente les professeurs.
 * Elle hérite de "User" puiqu'un professeur est simplement un utilisateur bénéficiant de fonctionnalités particulières.
 * 
 * @author Hugo Marcq
 * @version 06/2016
 * 
 */
public class Teacher extends User {
	
	/**
	 * Contient l'identifiant du professeur courant.
	 */
	private int teacherID;
	
	/**
	 * Contructeur de Teacher permettant de créer un professeur, qui contient toutes ses informations en paramètres.
	 * 
	 * @param teacherID
	 * 		Entier correspondant à l'identifiant du professeur.
	 * @param login
	 * 		Chaîne de caractères correspondant au login du professeur.
	 * @param pwd
	 * 		Chaîne de caractères correspondant au mot de passe du professeur.
	 * @param firstname
	 * 		Chaîne de caractères correspondant au prénom du professeur.
	 * @param surname
	 * 		Chaîne de caractères correspondant au nom du professeur.
	 */
	public Teacher(int teacherID, String login, String pwd, String firstname, String surname) {
		super(login, pwd, firstname, surname);
		this.teacherID = teacherID;
	}

	/**
	 * Retourne l'ID du professeur, l'attribut teacherID.
	 * 
	 * @return teacherID.
	 */
	public int getTeacherID() {
		return this.teacherID;
	}

	/**
	 * Affecte une valeur à l'attribut teacherID, l'ID du professeur.
	 * 
	 * @param newTeacherID
	 * 		Entier correspondant à l'identifiant de professeur qui sera affecté au professeur courant.
	 */
	public void setTeacherID(Integer newTeacherID) {
		this.teacherID = newTeacherID;
	}

}
