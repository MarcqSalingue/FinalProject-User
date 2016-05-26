package userModel;

import java.util.Enumeration;
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
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import userModel.Admin;
import userModel.Student;
import userModel.Group;
import userModel.Teacher;
import userModel.User;
import org.jdom2.Content;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

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
	public Hashtable userTable = new Hashtable();
	public Hashtable groupTable = new Hashtable();
	
	/**
	 * 
	 * Constructeur de UserDB. 
	 * @param file
	 * 		Le nom du fichier qui contient la base de données.
	 */
	public UserDB(String file){
		super();
		this.setFile(file);
		this.userTable.put("su", new Admin(10, "su", "superUser", "su", "su"));
		this.userTable.put("hmarcq", new Student(2010, "hmarcq", "211195", "Hugo", "Marcq"));
		this.userTable.put("themennesson", new Teacher(1010, "themennesson", "cMoiLeProf", "Jos�", "Mennesson"));
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
		    Element roofGroup = roof.getChild("Groups");
			
			List<Element> studentList = roofStudent.getChildren("Student");
			List<Element> adminList = roofAdmin.getChildren("Administrator");
			List<Element> teacherList = roofTeacher.getChildren("Teacher");
			List<Element> groupList = roofGroup.getChildren("Group");

			for(int i = 0 ; i < studentList.size() ; i++) {
				List<Element> student = studentList.get(i).getChildren();
				
				login = student.get(0).getText();
				firstname = student.get(1).getText();
				surname = student.get(2).getText();
				pwd = student.get(3).getText();
				ID = Integer.parseInt(student.get(4).getText());
				groupID = Integer.parseInt(student.get(5).getText());
				
				this.userTable.put(login, new Student(ID, login, pwd, firstname, surname, groupID));
			}	
			
			for(int i = 0 ; i < adminList.size() ; i++) {
				List<Element> admin = adminList.get(i).getChildren();

				login = admin.get(0).getText();
				firstname = admin.get(1).getText();
				surname = admin.get(2).getText();
				pwd = admin.get(3).getText();
				ID = Integer.parseInt(admin.get(4).getText());
				
				this.userTable.put(login, new Admin(ID, login, pwd, firstname, surname));
			}
				
			for(int i = 0 ; i < teacherList.size() ; i++) {
				List<Element> teacher = teacherList.get(i).getChildren();

				login = teacher.get(0).getText();
				firstname = teacher.get(1).getText();
				surname = teacher.get(2).getText();
				pwd = teacher.get(3).getText();
				ID = Integer.parseInt(teacher.get(4).getText());

				this.userTable.put(login, new Teacher(ID, login, pwd, firstname, surname));
			}
		
			for(int i = 0; i < groupList.size() ; i++) {
				List<Element> group = groupList.get(i).getChildren();
			    
				ID = Integer.parseInt(group.get(0).getText());
				Group newGroup = new Group(ID);
			    this.groupTable.put(ID, newGroup);
			    //((Group)this.groupTable.get(ID)).addStudentToGroup()     ; METTRE ICI DANS 
			    
			}
			return true;
		}
		return false;
	}

	/**
	 * Description of the method saveDB.
	 */
	public boolean saveDB() {
		Enumeration userEnumeration = (this.userTable).keys();
		Enumeration groupEnumeration = (this.groupTable).keys();
		SAXBuilder sax =  new SAXBuilder();
		Document document = null;
		Element roof = new Element("UsersDB");
		Element groupsRoof = new Element("Groups");
		Element studentsRoof = new Element("Students");
		Element teachersRoof = new Element("Teachers");
		Element adminsRoof = new Element("Administrators");
		roof.addContent((Content)groupsRoof);
		roof.addContent((Content)studentsRoof);
		roof.addContent((Content)teachersRoof);
		roof.addContent((Content)adminsRoof);
			        
		try { //on essaye d'ouvrir le fichier
			document = sax.build(new File(this.file));
		} catch (Exception v0) {}
			        
		if(document != null) { //si on arrive � ouvrir le fichier
			         
			         
			//Pour les groupes
			while(groupEnumeration.hasMoreElements()) {
				String key = String.valueOf(groupEnumeration.nextElement());
				Element group = new Element("Group");
				Element groupID = new Element("groupId");
				groupID.setText(key);
				group.addContent((Content)groupID);
				groupsRoof.addContent((Content)group);
			}

			//pour les utilisateurs
			while(userEnumeration.hasMoreElements()) {
				String key = (String)userEnumeration.nextElement();
			   
				//si c'est un �tudiant
				if(this.userTable.get(key) instanceof Student) {
					Student student = (Student)this.userTable.get(key);
					Element Student = new Element("Student");
					Element login = new Element("login");
					Element firstname = new Element("firstname");
					Element surname = new Element("surname");
					Element pwd = new Element("pwd");
					Element studentId = new Element("studentId");
					Element groupID = new Element("groupId");
					login.setText(key);
					firstname.setText(student.getFirstname());
					surname.setText(student.getSurname());
					pwd.setText(student.getPwd());
					studentId.setText(Integer.toString(student.getStudentID()));
					groupID.setText(Integer.toString(student.getGroupID()));
					Student.addContent(login);
					Student.addContent(firstname);
					Student.addContent(surname);
					Student.addContent(pwd);
					Student.addContent(studentId);
					Student.addContent(groupID);
					studentsRoof.addContent(Student);
				}
			   
				//Si c'est un professeur
				if(this.userTable.get(key) instanceof Teacher) {
					Teacher teacher = (Teacher)this.userTable.get(key);
					Element Teacher = new Element("Teacher");
					Element login = new Element("login");
					Element firstname = new Element("firstname");
					Element surname = new Element("surname");
					Element pwd = new Element("pwd");
					Element teacherID = new Element("teacherId");
					login.setText(key);
					firstname.setText(teacher.getFirstname());
					surname.setText(teacher.getSurname());
					pwd.setText(teacher.getPwd());
					teacherID.setText(Integer.toString(teacher.getTeacherID()));
					Teacher.addContent(login);
					Teacher.addContent(firstname);
					Teacher.addContent(surname);
					Teacher.addContent(pwd);
					Teacher.addContent(teacherID);
					teachersRoof.addContent(Teacher);
				}
			   
				//Si c'est un Administrateur
				if(this.userTable.get(key) instanceof Admin) {
					Admin admin = (Admin)this.userTable.get(key);
					Element Admin = new Element("Administrator");
					Element login = new Element("login");
					Element firstname = new Element("firstname");
					Element surname = new Element("surname");
					Element pwd = new Element("pwd");
					Element adminId = new Element("adminId");
					login.setText(key);
					firstname.setText(admin.getFirstname());
					surname.setText(admin.getSurname());
					pwd.setText(admin.getPwd());
					adminId.setText(Integer.toString(admin.getAdminID()));
					Admin.addContent(login);
					Admin.addContent(firstname);
					Admin.addContent(surname);
					Admin.addContent(pwd);
					Admin.addContent(adminId);
					adminsRoof.addContent(Admin);
				}
			   
			} //fin while
			  
			//on ajoute le tout
			document.setRootElement(roof);
			  
			try {
				XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
				outputter.output(document, (OutputStream)new FileOutputStream(this.file));
			}
			catch (IOException v0) {
				return false;
			}
			return true;
		} 
		return true;	 
	} 

	/**
	 * Description of the method associateStudToGroup.
	 * @param adminLogin 
	 * @param studentLogin 
	 * @param groupID 
	 */
	public boolean associateStudToGroup(String adminLogin, String studentLogin, int groupID) {
		if(this.userTable.get(adminLogin) instanceof Admin && this.userTable.get(studentLogin) instanceof Student) {
			if(this.groupTable.get(groupID) instanceof Group) {
				Group group = (Group)this.groupTable.get(groupID);
				group.getStudentsFromGroup().put(groupID, this.userTable.get(studentLogin));
				((Student)this.userTable.get(studentLogin)).setGroupID(groupID);
				((Group)this.groupTable.get(groupID)).addStudentToGroup((Student)this.userTable.get(studentLogin));
			}
/*			else {
				addGroup(adminLogin, groupID);
				Group group = (Group)this.groupTable.get(groupID);
				group.getStudentsFromGroup().put(groupID, this.userTable.get(studentLogin));
				((Student)this.userTable.get(studentLogin)).setGroupID(groupID);
			}*/
			saveDB();
			return true;
		}
		return false;
	}

	
	/**
	 * Description of the method groupsIdToString.
	 */
	public String[] groupsIdToString() {
		String[] groupsIDString = new String[this.groupTable.size()];
		Enumeration groupEnumeration = ((Hashtable) this.groupTable).keys();
		int i = 0;
		while(groupEnumeration.hasMoreElements()) {
			String key = String.valueOf(groupEnumeration.nextElement());
			groupsIDString[i] = key;
			i++;
		}
		return groupsIDString;
	}

	/**
	 * Description of the method usersLoginToString.
	 */
	public String[] usersLoginToString() {
		String[] userLoginString = new String[this.userTable.size()];
		Set keys = userTable.keySet();
		Iterator it = keys.iterator();
		int i = 0;
		while (it.hasNext()){
		   String key = (String)it.next();
		   User userTemp = (User)userTable.get(key);
		   userLoginString[i] = userTemp.getLogin();
		   ++i;
		}
		return userLoginString;
	}

	/**
	 * Description of the method studentsLoginToString.
	 */
	public String[] studentsLoginToString() {
		String[] userLoginString = new String[500];//Trouver le nb de students (voir dans groupe?)
		Set keys = userTable.keySet();
		Iterator it = keys.iterator();
		int i = 0;
		while (it.hasNext()){
		   String key = (String)it.next();
		   User userTemp = (User)userTable.get(key);
		   if (userTemp instanceof Student) {
			   userLoginString[i] = userTemp.getLogin();
			   ++i;
		   }
		}
		return userLoginString;
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
		   if (userTemp instanceof Student) {
			   userString[i] = ((Student) userTemp).getStudentID() + "|" + userTemp.getLogin() + "|" + userTemp.getPwd() + "|" + userTemp.getFirstname() + "|" + userTemp.getSurname() + "|" + ((Student)userTemp).getGroupID();
		   }
		   if (userTemp instanceof Teacher) {
			   userString[i] = ((Teacher) userTemp).getTeacherID() + "|" + userTemp.getLogin() + "|" + userTemp.getPwd() + "|" + userTemp.getFirstname() + "|" + userTemp.getSurname();
		   }
		   if (userTemp instanceof Admin) {
			   userString[i] = ((Admin) userTemp).getAdminID() + "|" + userTemp.getLogin() + "|" + userTemp.getPwd() + "|" + userTemp.getFirstname() + "|" + userTemp.getSurname();
		   }
		   ++i;
		}
		return userString;
	}

	/**
	 * Description of the method groupsToString.
	 */
	public String[] groupsToString() {
		String[] groupString = new String[this.groupTable.size()];
		Enumeration groupEnum = (this.groupTable).keys();
		int i = 0;
		while(groupEnum.hasMoreElements()) {
			String key = String.valueOf(groupEnum.nextElement());
			Group group = (Group)this.groupTable.get(Integer.parseInt(key));
			//on r�cupere l'�tudiant
			Hashtable table = group.getStudentsFromGroup();
			Enumeration studentsEnum = table.keys();
			while(studentsEnum.hasMoreElements()) {
				Integer studentKey = (Integer)studentsEnum.nextElement();
				Student currentStudent = (Student)table.get(studentKey);
				//maintenant on affiche
				groupString[i] = currentStudent.getLogin() + "|" + currentStudent.getFirstname() + "|" + currentStudent.getSurname()+ "|" + currentStudent.getPwd() + "|" + currentStudent.getStudentID() + "|" + currentStudent.getGroupID();
				i++;
			}
		}
		   return groupString;
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
		Admin newAdmin;
		if (this.userTable.get(adminLogin) instanceof Admin && this.userTable.get(newAdminLogin) == null) {
			newAdmin = new Admin(adminID, firstname, surname, newAdminLogin, pwd);
			this.userTable.put(newAdminLogin, newAdmin);
			isAdminAdded = true;
			saveDB();
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
			saveDB();
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
			saveDB();
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
		User userToRemove;
		if (this.userTable.get(adminLogin) instanceof Admin && this.userTable.containsKey(userLogin)) {
			userToRemove = (User)this.userTable.get(userLogin);
			if (userToRemove instanceof Student && ((Student)userToRemove).getGroupID() != -1) {
				((Group)this.groupTable.get(((Student)userToRemove).getGroupID())).removeStudentFromGroup((Student)userToRemove);
			}
			this.userTable.remove(userLogin);
			isUserRemoved = true;
			saveDB();
		}
		return isUserRemoved;
	}

	/**
	 * Description of the method addGroup.
	 * @param adminLogin 
	 * @param groupID 
	 */
	public boolean addGroup(String adminLogin, int groupID) {
		  boolean isGroupAdded = false;
		  if (this.userTable.get(adminLogin) instanceof Admin && this.groupTable.get(groupID) == null) {
		      this.groupTable.put(groupID, new Group(groupID));
		      isGroupAdded = true;
		      saveDB();
		  }
		  return isGroupAdded;
	}

	/**
	 * Description of the method removeGroup.
	 * @param adminLogin 
	 * @param groupID 
	 */
	public boolean removeGroup(String adminLogin, int groupID) {
		boolean isGroupRemoved = false;
		Group groupToRemove;
		if (this.userTable.get(adminLogin) instanceof Admin && this.groupTable.containsKey(groupID)) {
			groupToRemove = (Group)this.groupTable.get(groupID);
			this.groupTable.remove(groupToRemove);
			saveDB();
		}
		return isGroupRemoved;
	}

	/**
	 * Description of the method getStudentGroup.
	 * @param studentLogin 
	 */
	public int getStudentGroup(String studentLogin) {
		if (this.userTable.get(studentLogin) instanceof Student) {
			return ((Student)this.userTable.get(studentLogin)).getGroupID();
		}
		else {
			return -1;
		}
	}
		
	/**
	 * Description of the method getUserName.
	 * @param userLogin 
	 */
	public String getUserName(String userLogin) {
		if (this.userTable.get(userLogin) != null && this.userTable.get(userLogin) instanceof Student) {
			return ((Student)this.userTable.get(userLogin)).getFirstname() + ((Student)this.userTable.get(userLogin)).getSurname();
		}
		
		if (this.userTable.get(userLogin) != null && this.userTable.get(userLogin) instanceof Admin) {
			return ((Admin)this.userTable.get(userLogin)).getFirstname() + ((Admin)this.userTable.get(userLogin)).getSurname();
		}
		
		if (this.userTable.get(userLogin) != null && this.userTable.get(userLogin) instanceof Teacher) {
			return ((Teacher)this.userTable.get(userLogin)).getFirstname() + ((Teacher)this.userTable.get(userLogin)).getSurname();
		}
		else {
			return null;
		}
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
