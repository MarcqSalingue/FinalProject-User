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

	public Hashtable groupTable;
	private String file = "";
	public Hashtable userTable;
	
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
		super();
		this.setFile(file);
		loadDB();
	}
	
	/**
	 * Getter de file
	 * 
	 * @return 
	 * 		Le nom du fichier qui contient la base de données.
	 */
	public String getFile() {
		return this.file;
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
	public boolean loadDB() {

		SAXBuilder builder;
		builder = new SAXBuilder();
		Document document;
		document = null;
		Element roof;
		String login, pwd, firstname, surname;
		int ID, groupID;
			        
		try {
			document = builder.build(new File(this.file));
		} catch (Exception v0) {}
			  
		if(document != null) {
		    roof = document.getRootElement();
			
		    Element roofStudent = roof.getChild("Students");   
		    Element roofAdmin = roof.getChild("Administrators");
		    Element roofTeacher = roof.getChild("Teachers");
			
			List<Element> studentList = roofStudent.getChildren("Student");
			List<Element> adminList = roofAdmin.getChildren("Administrator");
			List<Element> teacherList = roofTeacher.getChildren("Teacher");

			for(int i = 0 ; i < studentList.size() ; i++) {
				List<Element> student = studentList.get(i).getChildren();
				
				login = student.get(0).getText();
				firstname = student.get(1).getText();
				surname = student.get(2).getText();
				pwd = student.get(3).getText();
				ID = Integer.parseInt(student.get(4).getText());
				groupID = Integer.parseInt(student.get(5).getText());
				
				this.userTable.put(ID, new Student(ID, firstname, surname, login, pwd, groupID));
			}	
			
			for(int i = 0 ; i < adminList.size() ; i++) {
				List<Element> admin = adminList.get(i).getChildren();

				login = admin.get(0).getText();
				firstname = admin.get(1).getText();
				surname = admin.get(2).getText();
				pwd = admin.get(3).getText();
				ID = Integer.parseInt(admin.get(4).getText());
				
				this.userTable.put(ID, new Admin(ID, firstname, surname, login, pwd));
			}
				
			for(int i = 0 ; i < teacherList.size() ; i++) {
				List<Element> teacher = teacherList.get(i).getChildren();

				login = teacher.get(0).getText();
				firstname = teacher.get(1).getText();
				surname = teacher.get(2).getText();
				pwd = teacher.get(3).getText();
				ID = Integer.parseInt(teacher.get(4).getText());

				this.userTable.put(ID, new Teacher(ID, firstname, surname, login, pwd));
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
	 * Description of the method associateStudToGroup.
	 * @param adminLogin 
	 * @param studentLogin 
	 * @param groupID 
	 */
	public void associateStudToGroup(String adminLogin, String studentLogin, Integer groupID) {
		
	}

	
	/**
	 * Description of the method groupsIdToString.
	 */
	public void groupsIdToString() {
		
	}

	/**
	 * Description of the method usersLoginToString.
	 */
	public void usersLoginToString() {
	
	}

	/**
	 * Description of the method studentsLoginToString.
	 */
	public void studentsLoginToString() {
		
	}

	/**
	 * Description of the method usersToString.
	 */
	public void usersToString() {
	
	}

	/**
	 * Description of the method groupsToString.
	 */
	public void groupsToString() {
	
	}
	
	/**
	 * Description of the method addAdmin.
	 * @param adminLogin 
	 * @param newAdminLogin 
	 * @param adminID 
	 * @param firstname 
	 * @param surname 
	 * @param pwd 
	 */
	public void addAdmin(String adminLogin, String newAdminLogin, Integer adminID, String firstname, String surname,
			String pwd) {
	
	}

	/**
	 * Description of the method addTeacher.
	 * @param adminLogin 
	 * @param newTeacherLogin 
	 * @param teacherID 
	 * @param firstname 
	 * @param surname 
	 */
	public void addTeacher(String adminLogin, String newTeacherLogin, Integer teacherID, String firstname,
			String surname) {
	
	}

	/**
	 * Description of the method addStudent.
	 * @param adminLogin 
	 * @param newStudentLogin 
	 * @param studentID 
	 * @param firstname 
	 * @param surname 
	 * @param pwd 
	 */
	public void addStudent(String adminLogin, String newStudentLogin, Integer studentID, String firstname,
			String surname, String pwd) {
		
	}

	/**
	 * Description of the method removeUser.
	 * @param adminLogin 
	 * @param userLogin 
	 */
	public void removeUser(String adminLogin, String userLogin) {
		
	}

	/**
	 * Description of the method addGroup.
	 * @param adminLogin 
	 * @param groupID 
	 */
	public void addGroup(String adminLogin, Integer groupID) {
	
	}

	/**
	 * Description of the method removeGroup.
	 * @param adminLogin 
	 * @param groupID 
	 */
	public void removeGroup(String adminLogin, Integer groupID) {
		
	}

	/**
	 * Description of the method getStudentGroup.
	 * @param studentLogin 
	 */
	public void getStudentGroup(String studentLogin) {
		
	}

	/**
	 * Description of the method getUserName.
	 * @param userLogin 
	 */
	public void getUserName(String userLogin) {
		
	}
	
	/**
	 * Description of the method getStudentID.
	 * @param adminLogin 
	 * @param studentLogin 
	 */
	public void getStudentID(String adminLogin, String studentLogin) {
		
	}

	/**
	 * Description of the method getGroupID.
	 * @param adminLogin 
	 * @param studentLogin 
	 */
	public void getGroupID(String adminLogin, String studentLogin) {
		
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
		userFound = (User)this.userTable.get(userLogin);
		
		if (userFound != null && userFound.getPwd().compareTo(userPwd) == 0) {
			System.out.println("User Found.");
			isUserFound = true;
		}
		
		else {
			System.out.println("Unknown User.");
			isUserFound = false;
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
