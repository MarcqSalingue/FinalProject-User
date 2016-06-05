package userController;

import userModel.UserDB;
/**
 * Cette classe represente le contrÃ´leur d'utilisateurs
 * Elle contient un attribut correspondant Ã  la base de donnÃ©es utilisateurs.
 * Elle contient toutes les fonctions de l'interface IUserController.
 * 
 * @author Hugo Marcq - Joffrey Salingue
 * @version 06/2016
 * 
 */

public class UserController implements IUserController
{
	
	/**
	 * Contient une instance de base de donnÃ©es d'utilisateurs
	 * 
	 */
	private UserDB userDB=null;
	
	
	/**
	 * Constructeur de controleur d'utilisateurs crÃ©ant la base de donnÃ©es d'utilisateurs
	 * 
	 * @param userfile
	 * 		Fichier XML contenant la base de donnÃ©es d'utilisateurs
	 */
	public UserController(String userfile){
		UserDB userDB = new UserDB(userfile);
		this.setUserDB(userDB);
	}

	@Override
	public String getUserName(String userLogin) {
		return userDB.getUserName(userLogin);
	}

	@Override
	public String getUserClass(String userLogin, String userPwd) {
		return userDB.getUserClass(userLogin, userPwd);
	}

	@Override
	public int getStudentGroup(String studentLogin) {
		return userDB.getStudentGroup(studentLogin);
	}

	@Override
	public boolean addAdmin(String adminLogin, String newAdminLogin, int adminID, String firstname, String surname,
			String pwd) {
		return userDB.addAdmin(adminLogin, newAdminLogin, adminID, firstname, surname, pwd);
	}

	@Override
	public boolean addTeacher(String adminLogin, String newTeacherLogin, int teacherID, String firstname,
			String surname, String pwd) {
		return userDB.addTeacher(adminLogin, newTeacherLogin, teacherID, firstname, surname, pwd);
	}

	@Override
	public boolean addStudent(String adminLogin, String newStudentLogin, int studentID, String firstname,
			String surname, String pwd) {
		return userDB.addStudent(adminLogin, newStudentLogin, studentID, firstname, surname, pwd);
	}

	@Override
	public boolean removeUser(String adminLogin, String userLogin) {
		return userDB.removeUser(adminLogin, userLogin);
	}

	@Override
	public boolean addGroup(String adminLogin, int groupID) {
		return userDB.addGroup(adminLogin, groupID);
	}

	@Override
	public boolean removeGroup(String adminLogin, int groupID) {
		return userDB.removeGroup(adminLogin, groupID);
	}

	@Override
	public boolean associateStudToGroup(String adminLogin, String studentLogin, int groupID) {
		return userDB.associateStudToGroup(adminLogin, studentLogin, groupID);
	}

	@Override
	public String[] usersToString() {
		return userDB.usersToString();
	}

	@Override
	public String[] usersLoginToString() {
		return userDB.usersLoginToString();
	}

	@Override
	public String[] studentsLoginToString() {
		return userDB.studentsLoginToString();
	}

	@Override
	public String[] groupsIdToString() {
		return userDB.groupsIdToString();
	}

	@Override
	public String[] groupsToString() {
		return userDB.groupsToString();
	}

	@Override
	public boolean loadDB() {
		return userDB.loadDB();
	}

	@Override
	public boolean saveDB() {
		return userDB.saveDB();
	}

	/**
	 * Méthode permettant de récupérer l'objet base de données utilisateur.
	 * 
	 * @return L'instance de base de données utilisateurs.
	 */
	public UserDB getUserDB() {
		return userDB;
	}

	/**
	 * Méthode permettant d'affecter un objet base de données utilisateurs à l'attribut userDB de cette classe.
	 * 
	 * @param userDB
	 * 		Objet de type UserDB correspondant à l'instance de base de données utilisateurs qui sera affectée au contrôleur.
	 */
	public void setUserDB(UserDB userDB) {
		this.userDB = userDB;
	}
	
}

