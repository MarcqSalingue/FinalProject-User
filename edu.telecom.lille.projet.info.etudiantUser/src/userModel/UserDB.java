package userModel;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Cette classe gére la base de données d'utilisateurs. Elle doit permettre de sauvegarder et charger les utilisateurs et les groupes à partir d'un fichier XML. 
 * La structure du fichier XML devra être la même que celle du fichier userDB.xml.
 * @see <a href="../../userDB.xml">userDB.xml</a> 
 * 
 * @author Jose Mennesson (Mettre à jour)
 * @version 04/2016 (Mettre à jour)
 * 
 */

//TODO Classe à modifier

public class UserDB {
	

	/**
	 * Description of the property groups.
	 */
	public List<Group> groupList = new LinkedList<Group>();

	/**
	 * Description of the property file.
	 */
	private String file = "";

	/**
	 * Description of the property users.
	 */
	public List<User> userList = new LinkedList<User>();

	// Start of user code (user defined attributes for UserDB)

	// End of user code
	
	/**
	 * 
	 * Constructeur de UserDB. 
	 * 
	 * !!!!!!!!!!!! PENSEZ À AJOUTER UN ADMINISTRATEUR (su par exemple) QUI VOUS PERMETTRA DE CHARGER LA BASE DE DONNÉES AU DEMARRAGE DE L'APPLICATION !!!!!!
	 * 
	 * @param file
	 * 		Le nom du fichier qui contient la base de données.
	 */
	public UserDB(String file){
		//TODO Fonction à modifier
		super();
		this.setFile(file);
	}
	
	/**
	 * Getter de file
	 * 
	 * @return 
	 * 		Le nom du fichier qui contient la base de données.
	 */
	
	public String getFile() {
		return file;
	}
	
	/**
	 * Setter de file
	 * 
	 * @param file
	 * 		Le nom du fichier qui contient la base de données.
	 */
	
	public void setFile(String file) {
		this.file = file;
	}
	
	/**
	 * Description of the method loadDB.
	 */
	public void loadDB() {
		// Start of user code for method loadDB
		// End of user code
	}

	/**
	 * Description of the method saveDB.
	 */
	public void saveDB() {
		// Start of user code for method saveDB
		// End of user code
	}

	/**
	 * Description of the method groupsIdToString.
	 */
	public void groupsIdToString() {
		// Start of user code for method groupsIdToString
		// End of user code
	}

	/**
	 * Description of the method usersLoginToString.
	 */
	public void usersLoginToString() {
		// Start of user code for method usersLoginToString
		//SAXBuilder builder = new SAXBuilder();
		//File xmlFile = new File(this.file);
		// End of user code
	}

	/**
	 * Description of the method studentsLoginToString.
	 */
	public void studentsLoginToString() {
		// Start of user code for method studentsLoginToString
		// End of user code
	}

	/**
	 * Description of the method usersToString.
	 */
	public void usersToString() {
		// Start of user code for method usersToString
		// End of user code
	}

	/**
	 * Description of the method groupsToString.
	 */
	public void groupsToString() {
		// Start of user code for method groupsToString
		// End of user code
	}

	/**
	 * Returns groups.
	 * @return groups 
	 */
	public List<Group> getGroups() {
		return this.groupList;
	}

	/**
	 * Returns users.
	 * @return users 
	 */
	public List<User> getUsers() {
		return this.userList;
	}
	
	/**
	 * Description of the method getUserName.
	 * @param userLogin 
	 */
	public void getUserName(String userLogin) {
		
	}

	/**
	 * Description of the method getUserClass.
	 * @param userLogin 
	 * @param userPwd 
	 */
	public String getUserClass(String userLogin, String userPwd) {
		String userClass = "";
		boolean isUserFound = false;
		User userFound = new User();
		
		for (int index = 0 ; index < this.userList.size() ; index++) {
			if (userLogin == this.userList.get(index).login && userPwd == this.userList.get(index).pwd) {
				userFound = this.userList.get(index);
				isUserFound = true;
			}
		}
		
		if (isUserFound == true) {
			if (userFound instanceof Student) {
				userClass = "Student";
			}
			if (userFound instanceof Teacher) {
				userClass = "Teacher";
			}
			if (userFound instanceof Admin) {
				userClass = "Administrator";
			}
		}
		
		return userClass;
	}
}
