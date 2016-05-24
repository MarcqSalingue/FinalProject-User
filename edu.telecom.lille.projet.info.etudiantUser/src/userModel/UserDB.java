package userModel;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.io.File;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import userModel.Admin;
import userModel.Student;
import userModel.Group;
import userModel.Teacher;
import userModel.User;

/**
 * 
 * Cette classe gÃ©re la base de donnÃ©es d'utilisateurs. Elle doit permettre de sauvegarder et charger les utilisateurs et les groupes Ã  partir d'un fichier XML. 
 * La structure du fichier XML devra Ãªtre la mÃªme que celle du fichier userDB.xml.
 * @see <a href="../../userDB.xml">userDB.xml</a> 
 * 
 * @author Jose Mennesson (Mettre Ã  jour)
 * @version 04/2016 (Mettre Ã  jour)
 * 
 */

//TODO Classe Ã  modifier

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
	 * !!!!!!!!!!!! PENSEZ Ã€ AJOUTER UN ADMINISTRATEUR (su par exemple) QUI VOUS PERMETTRA DE CHARGER LA BASE DE DONNÃ‰ES AU DEMARRAGE DE L'APPLICATION !!!!!!
	 * 
	 * @param file
	 * 		Le nom du fichier qui contient la base de donnÃ©es.
	 */
	public UserDB(String file){
		super();
		this.setFile(file);
		loadDB();
	}
	
	/**
	 * Getter de file
	 * 
	 * @return 
	 * 		Le nom du fichier qui contient la base de donnÃ©es.
	 */
	
	public String getFile() {
		return this.file;
	}
	
	/**
	 * Setter de file
	 * 
	 * @param file
	 * 		Le nom du fichier qui contient la base de donnÃ©es.
	 */
	
	public void setFile(String file) {
		this.file = file;
	}
	
	/**
	 * Description of the method loadDB.
	 */
	public boolean loadDB() {

		SAXBuilder sax;
		sax = new SAXBuilder();
		Document document;
		document = null;
		Element roof;
		String login, pwd, firstname, surname, id, group;
		//Object object;
			        
		try { //on essaye d'ouvrir le fichier
			document = sax.build(new File(this.file));
		} catch (Exception v0) {}
			  
		if(document != null) { //si on arrive à ouvrir le fichier
			//On initialise un nouvel élément racine avec l'élément racine du document.
		    roof = document.getRootElement();
			//On descend d'un cran
		    Element roofStudent = roof.getChild("Students");   
		    Element roofAdmin = roof.getChild("Administrators");
		    Element roofTeacher = roof.getChild("Teachers");
			//on récupère la liste des étudiants
			List<Element> studentList = roofStudent.getChildren("Student");
			List<Element> adminList = roofAdmin.getChildren("Administrator");
			List<Element> teacherList = roofTeacher.getChildren("Teacher");

			for(int i = 0 ; i < studentList.size() ; i++) {
				List<Element> student = studentList.get(i).getChildren();
				//On enregistre dans les variables
				login = student.get(0).getText();
				firstname = student.get(1).getText();
				surname = student.get(2).getText();
				pwd = student.get(3).getText();
				id = student.get(4).getText();
				group = student.get(5).getText();
				//on crée l'objet Etudiant
				Student studentCreated = new Student(Integer.parseInt(id), firstname, surname, login, pwd, Integer.parseInt(group));
				//on l'ajoute dans la liste des Utilisateurs
				userList.add(studentCreated);
				if (group != "-1") {
					//associateStudToGroup(login, group);
				}
			}	
			
			for(int i = 0 ; i < adminList.size() ; i++) {
				List<Element> admin = adminList.get(i).getChildren();
				//On enregistre dans les variables
				login = admin.get(0).getText();
				firstname = admin.get(1).getText();
				surname = admin.get(2).getText();
				pwd = admin.get(3).getText();
				id = admin.get(4).getText();
				//on crée l'objet Etudiant
				Admin adminCreated = new Admin(Integer.parseInt(id), firstname, surname, login, pwd);
				//on l'ajoute dans la liste des Utilisateurs
				userList.add(adminCreated);
			}
				
			for(int i = 0 ; i < teacherList.size() ; i++) {
				List<Element> teacher = teacherList.get(i).getChildren();
				//On enregistre dans les variables
				login = teacher.get(0).getText();
				firstname = teacher.get(1).getText();
				surname = teacher.get(2).getText();
				pwd = teacher.get(3).getText();
				id = teacher.get(4).getText();
				//on crée l'objet Etudiant
				Teacher teacherCreated = new Teacher(Integer.parseInt(id), firstname, surname, login, pwd);
				//on l'ajoute dans la liste des Utilisateurs
				userList.add(teacherCreated);
			}
			return true;
		}
		return false;
	}

	/**
	 * Description of the method saveDB.
	 */
	public void saveDB() {
		// Start of user code for method saveDB
		// End of user code
	}
	
	/**
	 * Description of the method.
	 * 
	 * 
	 */
	public User findUserByLogin(String login) {
		int i = 0;
		
	    for(i=0; i<userList.size(); i++) {
	    	
	    	if(userList.get(i).getLogin() == login) { return userList.get(i); }
	    
	    }
	    
	    return null;
	    
	}
	  
	/**
	 * Description of the method.
	 * 
	 * 
	 */
	public Group findGroupByID(int groupID) {
		int i = 0;
		
		for(i=0; i<groupList.size(); i++) {
			
			if(groupList.get(i).getGroupID() == groupID) { return groupList.get(i); }
			
		}
		
		return null;
}
	
	/*public int findUserID(String login) {
	    int i = 0;
	    for(i=0; i<userList.size(); i++) {
	     if(userList.get(i).getLogin() == login)
	      return userList.get(i).get();
	    }
	    return -1;
	   }
	
	public int findGroupID(int groupID) {
	    int i = 0;
	    for(i=0; i<group.size(); i++) {
	     if(group.get(i).GetIdGroup() == id)
	      return i;
	    }
	    return -1;
	   }*/
	
	

	/**
	 * Description of the method associateStudToGroup.
	 * @param adminLogin 
	 * @param studentLogin 
	 * @param groupID 
	 */
	public void associateStudToGroup(String adminLogin, String studentLogin, Integer groupID) {
		boolean isAssociationDone = false;
		if (this.findUserByLogin(adminLogin) instanceof Admin && this.findUserByLogin(studentLogin) != null 
				&& this.findGroupByID(groupID) != null && this.findUserByLogin(studentLogin) instanceof Student) {
			//if (this.findUserByLogin(studentLogin).get)
		}
		
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
