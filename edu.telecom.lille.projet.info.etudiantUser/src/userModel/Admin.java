/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;

import userModel.User;

/**
 * La classe Admin repr�sente les administrateurs.
 * Elle h�rite de "User" puiqu'un administrateur est simplement un utilisateur b�n�ficiant de fonctionnalit�s avanc�es.
 * 
 * @author Hugo Marcq
 * @version 06/2016
 * 
 */
public class Admin extends User {
	
	/**
	 * Contient l'identifiant de l'administrateur courant.
	 */
	private int adminID;

	/**
	 * Contructeur d'Admin permettant de cr�er un administrateur, qui contient toutes ses informations en param�tres.
	 * 
	 * @param adminID
	 * 		Entier correspondant � l'identifiant de l'administrateur.
	 * @param login
	 * 		Cha�ne de caract�res correspondant au login de l'administrateur.
	 * @param pwd
	 * 		Cha�ne de caract�res correspondant au mot de passe de l'administrateur.
	 * @param firstname
	 * 		Cha�ne de caract�res correspondant au pr�nom de l'administrateur.
	 * @param surname
	 * 		Cha�ne de caract�res correspondant au nom de l'administrateur.
	 */
	public Admin(int adminID, String login, String pwd, String firstname, String surname) {
		super(login, pwd, firstname, surname);
		this.adminID = adminID;
	}

	/**
	 * Retourne l'ID de l'administrateur, l'attribut adminID.
	 * 
	 * @return adminID.
	 */
	public int getAdminID() {
		return this.adminID;
	}

	/**
	 * Affecte une valeur � l'attribut adminID, l'ID d'administrateur.
	 * 
	 * @param newAdminID
	 * 		Entier correspondant � l'identifiant d'administrateur qui sera affect� � l'administrateur courant.
	 */
	public void setAdminID(int newAdminID) {
		this.adminID = newAdminID;
	}
	
}
