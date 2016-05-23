package userModel;

import java.util.LinkedList;
import java.util.List;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Iterator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Collection;
import java.util.Hashtable;
import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import userModel.Admin;
import userModel.Student;
import userModel.Group;
import userModel.Teacher;
import userModel.User;
import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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
		//TODO Fonction Ã  modifier
		super();
		this.setFile(file);
	}
	
	/**
	 * Getter de file
	 * 
	 * @return 
	 * 		Le nom du fichier qui contient la base de donnÃ©es.
	 */
	
	public String getFile() {
		return file;
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
	public void loadDB() {

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
		    Element roof2 = roof.getChild("Students");
			            
			//on récupère la liste des étudiants
			List<Element> studentList = roof2.getChildren("Student");
			 
			//On crée un Iterator sur notre liste
			//Iterator iterator = studentList.iterator();
			
			for(int i = 0 ; i < studentList.size() ; i++) {
				List<Element> student = studentList.get(i).getChildren();
				//On enregistre dans les variables
				login = student.get(0).getText();
				firstname = student.get(1).getText();
				surname = student.get(2).getText();
				pwd =student.get(3).getText();
				id = student.get(4).getText();
				group = student.get(5).getText();

				//on crée l'objet Etudiant
				Student studentCreated = new Student(Integer.parseInt(id), firstname, surname, login, pwd); //Attention, rajouter groupe non?
				
				//on l'ajoute dans la liste des Utilisateurs
				userList.add(studentCreated);
			}	
		} 
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
