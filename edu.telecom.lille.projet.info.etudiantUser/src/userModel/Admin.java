/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;

import userModel.User;

/**
 * La classe Admin représente les administrateurs.
 * Elle hérite de "User" puiqu'un administrateur est simplement un utilisateur bénéficiant de fonctionnalités avancées.
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
	 * Contructeur d'Admin permettant de créer un administrateur, qui contient toutes ses informations en paramètres.
	 * 
	 * @param adminID
	 * 		Entier correspondant à l'identifiant de l'administrateur.
	 * @param login
	 * 		Chaîne de caractères correspondant au login de l'administrateur.
	 * @param pwd
	 * 		Chaîne de caractères correspondant au mot de passe de l'administrateur.
	 * @param firstname
	 * 		Chaîne de caractères correspondant au prénom de l'administrateur.
	 * @param surname
	 * 		Chaîne de caractères correspondant au nom de l'administrateur.
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
	 * Affecte une valeur à l'attribut adminID, l'ID d'administrateur.
	 * 
	 * @param newAdminID
	 * 		Entier correspondant à l'identifiant d'administrateur qui sera affecté à l'administrateur courant.
	 */
	public void setAdminID(int newAdminID) {
		this.adminID = newAdminID;
	}
	
}
