/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;

/**
 * La classe User repr�sente tous les utilisateurs qui se connectent au gestionnaire d'emplois du temps.
 * Chaque utilisateur poss�de son login, mot de passe, pr�nom et nom.
 * User est une classe m�re de Student (�tudiants), Teacher (professeurs), et Admin (administrateurs).
 * En effet, chacun de ces types d'utilisateurs poss�de la m�me architecture (login, mot de passe, etc.) mais dispose de fonctionnalit�s particuli�res.
 * 
 * @author Hugo Marcq
 * @version 06/2016
 * 
 */
public class User {

	/**
	 * Cha�ne de caract�res contenant le login de l'utilisateur courant.
	 */
	private String login = "";
	
	/**
	 * Cha�ne de caract�res contenant le mot de passe de l'utilisateur courant.
	 */
	private String pwd = "";
	
	/**
	 * Cha�ne de caract�res contenant le pr�nom de l'utilisateur courant.
	 */
	private String firstname = "";
	
	/**
	 * Cha�ne de caract�res contenant le nom de l'utilisateur courant.
	 */
	private String surname = "";
	
	/**
	 * Contructeur de User permettant de d�finir un utilisateur, qui contient toutes ses informations en param�tres.
	 *
	 * @param login
	 * 		Cha�ne de caract�res correspondant au login de l'utilisateur.
	 * @param pwd
	 * 		Cha�ne de caract�res correspondant au mot de passe de l'utilisateur.
	 * @param firstname
	 * 		Cha�ne de caract�res correspondant au pr�nom de l'utilisateur.
	 * @param surname
	 * 		Cha�ne de caract�res correspondant au nom de l'utilisateur.
	 */
	public User(String login, String pwd, String firstname, String surname) {
		this.firstname = firstname;
		this.surname = surname;
		this.login = login;
		this.pwd = pwd;
	}
	
	/**
	 * Contructeur vide de User. Ce sont les classes filles qui vont permettre de cr�er les �tudiants, professeurs et administrateurs.
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
	 * Affecte une valeur � l'attribut login, le login de l'utilisateur.
	 * 
	 * @param newLogin
	 * 		Cha�ne de caract�res correspondant au login de l'utilisateur qui sera affect� � l'utilisateur courant.
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
	 * Affecte une valeur � l'attribut pwd, le mot de passe de l'utilisateur.
	 * 
	 * @param newPwd
	 * 		Cha�ne de caract�res correspondant au mot de passe de l'utilisateur qui sera affect� � l'utilisateur courant.
	 */
	public void setPwd(String newPwd) {
		this.pwd = newPwd;
	}

	/**
	 * Retourne le pr�nom de l'utilisateur, l'attribut firstname.
	 * 
	 * @return firstname.
	 */
	public String getFirstname() {
		return this.firstname;
	}

	/**
	 * Affecte une valeur � l'attribut firstname, le pr�nom de l'utilisateur.
	 * 
	 * @param newFirstname
	 * 		Cha�ne de caract�res correspondant au pr�nom de l'utilisateur qui sera affect� � l'utilisateur courant.
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
	 * Affecte une valeur � l'attribut surname, le nom de l'utilisateur.
	 * 
	 * @param newSurname
	 * 		Cha�ne de caract�res correspondant au nom de l'utilisateur qui sera affect� � l'utilisateur courant.
	 */
	public void setSurname(String newSurname) {
		this.surname = newSurname;
	}

}
