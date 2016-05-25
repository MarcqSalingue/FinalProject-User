package userModel;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

	private String file = "";
	public Map userTable = new HashMap();
	public Map groupTable = new HashMap();
	
	/**
	 * 
	 * Constructeur de UserDB. 
	 * @param file
	 * 		Le nom du fichier qui contient la base de données.
	 */
	public UserDB(String file){
		super();
		this.setFile(file);
		this.userTable.put("su", new Admin(0, "su", "su", "su", "superUser"));
		this.userTable.put("hmarcq", new Student(2000, "hmarcq", "Hugo", "Marcq", "211195"));
		this.userTable.put("themennesson", new Teacher(1000, "themennesson", "Jos�", "Mennesson", "cMoiLeProf"));
		this.loadDB();
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
				
				this.userTable.put(login, new Student(ID, firstname, surname, login, pwd, groupID));
			}	
			
			for(int i = 0 ; i < adminList.size() ; i++) {
				List<Element> admin = adminList.get(i).getChildren();

				login = admin.get(0).getText();
				firstname = admin.get(1).getText();
				surname = admin.get(2).getText();
				pwd = admin.get(3).getText();
				ID = Integer.parseInt(admin.get(4).getText());
				
				this.userTable.put(login, new Admin(ID, firstname, surname, login, pwd));
			}
				
			for(int i = 0 ; i < teacherList.size() ; i++) {
				List<Element> teacher = teacherList.get(i).getChildren();

				login = teacher.get(0).getText();
				firstname = teacher.get(1).getText();
				surname = teacher.get(2).getText();
				pwd = teacher.get(3).getText();
				ID = Integer.parseInt(teacher.get(4).getText());

				this.userTable.put(login, new Teacher(ID, firstname, surname, login, pwd));
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
	public String[] usersToString() {
		String[] userString = new String[this.userTable.size()];
		Set keys = userTable.keySet();
		Iterator it = keys.iterator();
		int i = 0;
		while (it.hasNext()){
		   String key = (String)it.next();
		   User userTemp = (User)userTable.get(key);
		   userString[i] = userTemp.getLogin();
		   ++i;
		}
		return userString;
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
	public boolean addAdmin(String adminLogin, String newAdminLogin, int adminID, String firstname, String surname,
			String pwd) {
		boolean isAdminAdded = false;
		//System.out.println("je rentre dans addAdmin");
		Admin newAdmin;
		if (this.userTable.get(adminLogin) instanceof Admin && this.userTable.get(newAdminLogin) == null) {
			newAdmin = new Admin(adminID, firstname, surname, newAdminLogin, pwd);
			this.userTable.put(newAdminLogin, newAdmin);
			isAdminAdded = true;
		}
		return isAdminAdded;
	}

	/**
	 * Description of the method addTeacher.
	 * @param adminLogin 
	 * @param newTeacherLogin 
	 * @param teacherID 
	 * @param firstname 
	 * @param surname 
	 */
	public boolean addTeacher(String adminLogin, String newTeacherLogin, int teacherID, String firstname,
			String surname, String pwd) {
		boolean isTeacherAdded = false;
		//System.out.println("je rentre dans addTeacher");
		Admin newTeacher;
		if (this.userTable.get(adminLogin) instanceof Admin && this.userTable.get(newTeacherLogin) == null) {
			newTeacher = new Admin(teacherID, firstname, surname, newTeacherLogin, pwd);
			this.userTable.put(newTeacherLogin, newTeacher);
			isTeacherAdded = true;
		}
		return isTeacherAdded;
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
	public boolean addStudent(String adminLogin, String newStudentLogin, int studentID, String firstname,
			String surname, String pwd) {
		boolean isStudentAdded = false;
		Student newStudent;
		if (this.userTable.get(adminLogin) instanceof Admin && this.userTable.get(newStudentLogin) == null) {
			newStudent = new Student(studentID, firstname, surname, newStudentLogin, pwd);
			this.userTable.put(newStudentLogin, newStudent);
			isStudentAdded = true;
		}
		return isStudentAdded;
	}

	/**
	 * Description of the method removeUser.
	 * @param adminLogin 
	 * @param userLogin 
	 */
	public boolean removeUser(String adminLogin, String userLogin) {
		boolean isUserRemoved = false;
		System.out.println("COUCOUCOCUCOCUOCUCOUC");
		User userToRemove;
		if (this.userTable.get(adminLogin) instanceof Admin && this.userTable.containsKey(userLogin)) {
			userToRemove = (User)this.userTable.get(userLogin);
			if (userToRemove instanceof Student && ((Student)userToRemove).getGroupID() != -1) {
				((Group)this.groupTable.get(((Student)userToRemove).getGroupID())).removeStudentFromGroup((Student)userToRemove);
			}
			this.userTable.remove(userLogin);
			isUserRemoved = true;
		}
		return isUserRemoved;
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
