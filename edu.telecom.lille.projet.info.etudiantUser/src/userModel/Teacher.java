/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;

import userModel.User;

/**
 * La classe Teacher repr�sente les professeurs.
 * Elle h�rite de "User" puiqu'un professeur est simplement un utilisateur b�n�ficiant de fonctionnalit�s particuli�res.
 * 
 * @author Hugo Marcq - Joffrey Salingue
 * @version 06/2016
 * 
 */
public class Teacher extends User {
	
	/**
	 * Contient l'identifiant du professeur courant.
	 */
	private int teacherID;
	
	/**
	 * Contructeur de Teacher permettant de cr�er un professeur, qui contient toutes ses informations en param�tres.
	 * 
	 * @param teacherID
	 * 		Entier correspondant � l'identifiant du professeur.
	 * @param login
	 * 		Cha�ne de caract�res correspondant au login du professeur.
	 * @param pwd
	 * 		Cha�ne de caract�res correspondant au mot de passe du professeur.
	 * @param firstname
	 * 		Cha�ne de caract�res correspondant au pr�nom du professeur.
	 * @param surname
	 * 		Cha�ne de caract�res correspondant au nom du professeur.
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
	 * Affecte une valeur � l'attribut teacherID, l'ID du professeur.
	 * 
	 * @param newTeacherID
	 * 		Entier correspondant � l'identifiant de professeur qui sera affect� au professeur courant.
	 */
	public void setTeacherID(Integer newTeacherID) {
		this.teacherID = newTeacherID;
	}

}
