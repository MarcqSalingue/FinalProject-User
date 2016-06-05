/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;

/**
 * La classe User représente tous les utilisateurs qui se connectent au gestionnaire d'emplois du temps.
 * Chaque utilisateur possède son login, mot de passe, prénom et nom.
 * User est une classe mère de Student (étudiants), Teacher (professeurs), et Admin (administrateurs).
 * En effet, chacun de ces types d'utilisateurs possède la même architecture (login, mot de passe, etc.) mais dispose de fonctionnalités particulières.
 * 
 * @author Hugo Marcq
 * @version 06/2016
 * 
 */
public class User {

	/**
	 * Chaîne de caractères contenant le login de l'utilisateur courant.
	 */
	private String login = "";
	
	/**
	 * Chaîne de caractères contenant le mot de passe de l'utilisateur courant.
	 */
	private String pwd = "";
	
	/**
	 * Chaîne de caractères contenant le prénom de l'utilisateur courant.
	 */
	private String firstname = "";
	
	/**
	 * Chaîne de caractères contenant le nom de l'utilisateur courant.
	 */
	private String surname = "";
	
	/**
	 * Contructeur de User permettant de définir un utilisateur, qui contient toutes ses informations en paramètres.
	 *
	 * @param login
	 * 		Chaîne de caractères correspondant au login de l'utilisateur.
	 * @param pwd
	 * 		Chaîne de caractères correspondant au mot de passe de l'utilisateur.
	 * @param firstname
	 * 		Chaîne de caractères correspondant au prénom de l'utilisateur.
	 * @param surname
	 * 		Chaîne de caractères correspondant au nom de l'utilisateur.
	 */
	public User(String login, String pwd, String firstname, String surname) {
		this.firstname = firstname;
		this.surname = surname;
		this.login = login;
		this.pwd = pwd;
	}
	
	/**
	 * Contructeur vide de User. Ce sont les classes filles qui vont permettre de créer les étudiants, professeurs et administrateurs.
	 */
	public User() {
	}

	/**
	 * Retourne le login de l'utilisateur, l'attribut login.
	 * 
	 * @return login.
	 */
	public String getLogin() {
		return this.login;
	}

	/**
	 * Affecte une valeur à l'attribut login, le login de l'utilisateur.
	 * 
	 * @param newLogin
	 * 		Chaîne de caractères correspondant au login de l'utilisateur qui sera affecté à l'utilisateur courant.
	 */
	public void setLogin(String newLogin) {
		this.login = newLogin;
	}

	/**
	 * Retourne le mot de passe de l'utilisateur, l'attribut pwd.
	 * 
	 * @return pwd.
	 */
	public String getPwd() {
		return this.pwd;
	}

	/**
	 * Affecte une valeur à l'attribut pwd, le mot de passe de l'utilisateur.
	 * 
	 * @param newPwd
	 * 		Chaîne de caractères correspondant au mot de passe de l'utilisateur qui sera affecté à l'utilisateur courant.
	 */
	public void setPwd(String newPwd) {
		this.pwd = newPwd;
	}

	/**
	 * Retourne le prénom de l'utilisateur, l'attribut firstname.
	 * 
	 * @return firstname.
	 */
	public String getFirstname() {
		return this.firstname;
	}

	/**
	 * Affecte une valeur à l'attribut firstname, le prénom de l'utilisateur.
	 * 
	 * @param newFirstname
	 * 		Chaîne de caractères correspondant au prénom de l'utilisateur qui sera affecté à l'utilisateur courant.
	 */
	public void setFirstname(String newFirstname) {
		this.firstname = newFirstname;
	}

	/**
	 * Retourne le nom de l'utilisateur, l'attribut surname.
	 * 
	 * @return surname.
	 */
	public String getSurname() {
		return this.surname;
	}

	/**
	 * Affecte une valeur à l'attribut surname, le nom de l'utilisateur.
	 * 
	 * @param newSurname
	 * 		Chaîne de caractères correspondant au nom de l'utilisateur qui sera affecté à l'utilisateur courant.
	 */
	public void setSurname(String newSurname) {
		this.surname = newSurname;
	}

}
