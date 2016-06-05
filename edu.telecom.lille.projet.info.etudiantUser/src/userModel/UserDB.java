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
 * Cette classe gÃ©re la base de donnÃ©es d'utilisateurs. Elle doit permettre de sauvegarder et charger les utilisateurs et les groupes Ã  partir d'un fichier XML. 
 * La structure du fichier XML devra Ãªtre la mÃªme que celle du fichier userDB.xml.
 * @see <a href="../../userDB.xml">userDB.xml</a> 
 * 
 * @author Hugo Marcq
 * @version 06/2016
 * 
 */
public class UserDB {

	/**
	 * Contient le nom du fichier XML utilisé pour sauvegarger la base de données.
	 */
	private String file = "";
	
	/**
	 * Table contenant la totalité des utilisateurs de la base de données.
	 */
	public Hashtable userTable = new Hashtable();
	
	/**
	 * Table contenant la totalité des groupes de la base de données.
	 */
	public Hashtable groupTable = new Hashtable();
	
	/**
	 * Constructeur de UserDB. 
	 * @param file
	 * 		Le nom du fichier qui contient la base de donnÃ©es.
	 */
	public UserDB(String file){
		super();
		this.setFile(file);
		this.userTable.put("su", new Admin(10, "su", "superUser", "su", "su"));
		this.loadDB();
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
	 * Fonction chargeant la base de donnÃ©e contenue dans un fichier XML.
	 * 
	 * @return
	 * 		Un boolean indiquant si le chargement a bien Ã©tÃ© rÃ©alisÃ©e.
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
	 * Fonction sauvegardant la base de donnÃ©e dans un fichier XML.
	 * 
	 * @return
	 * 		Un boolean indiquant si la sauvegarde a bien Ã©tÃ© rÃ©alisÃ©e.
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
			        
		if(document != null) { //si on arrive ࡯uvrir le fichier
			         
			         
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
			   
				//si c'est un 굵diant
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
	 * Fonction permettant d'associer un Ã©tudiant Ã  un groupe. Elle renvoie true si l'association a Ã©tÃ© rÃ©alisÃ©e et false sinon. 
	 * Cette fonction devra tester si l'Ã©tudiant et le groupe existent ou non, puis elle devra sauvegarder la base de donnÃ©e. 
	 * @param adminLogin
	 * 				Le login de l'administrateur qui va associer un Ã©tudiant Ã  un groupe.
	 * 
	 * @param studentLogin
	 * 				Login de l'Ã©tudiant
	 * @param groupID
	 * 				Identifiant du groupe.
	 * @return
	 * 		Un boolean indiquant si l'association a bien Ã©tÃ© rÃ©alisÃ©e.
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
	 * Fonction permettant de rÃ©cupÃ©rer les identifiants des groupes sous la forme d'un 
	 * tableau de chaÃ®nes de caractÃ¨res oÃ¹ chaque ligne contient l'identifiant d'un groupe.
	 * 
	 * @return
	 * 		Un tableau de String contenant l'identifiant de tous les groupes.
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
	 * Fonction permettant de rÃ©cupÃ©rer les logins des utilisateurs sous la forme d'un 
	 * tableau de chaÃ®nes de caractÃ¨res oÃ¹ chaque ligne contient le login d'un utilisateur.
	 * 
	 * @return
	 * 		Un tableau de String contenant le login de tous les utilisateurs.
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
	 * Fonction permettant de rÃ©cupÃ©rer les logins des Ã©tudiants sous la forme d'un 
	 * tableau de chaÃ®nes de caractÃ¨res oÃ¹ chaque ligne contient le login d'un Ã©tudiant.
	 * 
	 * @return
	 * 		Un tableau de String contenant le login de tous les Ã©tudiants.
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
	 * Fonction permettant de rÃ©cupÃ©rer toutes les informations des utilisateurs sous la forme d'un 
	 * tableau de chaÃ®nes de caractÃ¨res oÃ¹ chaque ligne contient toutes les informations d'un utilisateur.
	 * 
	 * @return
	 * 		Un tableau de String contenant toutes les infos de tous les utilisateurs.
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
	 * Fonction permettant de rÃ©cupÃ©rer toutes les informations des groupes sous la forme d'un 
	 * tableau de chaÃ®nes de caractÃ¨res oÃ¹ chaque ligne contient les informations d'un groupe.
	 * 
	 * @return
	 * 		Un tableau de String contenant toutes les informations de tous les groupes.
	 */
	public String[] groupsToString() {
		String[] groupString = new String[this.groupTable.size()];
		Enumeration groupEnum = (this.groupTable).keys();
		int i = 0;
		while(groupEnum.hasMoreElements()) {
			String key = String.valueOf(groupEnum.nextElement());
			Group group = (Group)this.groupTable.get(Integer.parseInt(key));
			//on rꤵpere l'굵diant
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
	 * Fonction permettant d'ajouter un administrateur. Elle renvoie true si l'administrateur a Ã©tÃ© crÃ©Ã© et false sinon. 
	 * Cette fonction devra tester si l'administrateur existe dÃ©jÃ  ou non, puis elle devra le sauvegarder dans la base de donnÃ©e.
	 * @param adminLogin
	 * 				Le login de l'administrateur qui va crÃ©er le nouvel administrateur.
	 * @param newAdminLogin
	 * 				Le login du nouvel administrateur.
	 * @param adminID
	 * 				L'identifiant du nouvel administrateur.
	 * @param firstname
	 * 				Le prÃ©nom du nouvel administrateur.
	 * @param surname
	 * 				Le nom du nouvel administrateur.
	 * @param pwd
	 * 				Le mot de passe du nouvel administrateur.
	 * @return
	 * 		Un boolean indiquant si l'administrateur a bien Ã©tÃ© crÃ©Ã©
	 */
	public boolean addAdmin(String adminLogin, String newAdminLogin, int adminID, String firstname, String surname,
			String pwd) {
		boolean isAdminAdded = false;
		Admin newAdmin;
		if (this.userTable.get(adminLogin) instanceof Admin && this.userTable.get(newAdminLogin) == null) {
			newAdmin = new Admin(adminID, newAdminLogin, pwd, firstname, surname);
			this.userTable.put(newAdminLogin, newAdmin);
			isAdminAdded = true;
			saveDB();
		}
		return isAdminAdded;
	}

	/**
	 * Fonction permettant d'ajouter un professeur. Elle renvoie true si le professeur a Ã©tÃ© crÃ©Ã© et false sinon. 
	 * Cette fonction devra tester si le professeur existe dÃ©jÃ  ou non, puis elle devra le sauvegarder dans la base de donnÃ©e.
	 * @param adminLogin
	 * 				Le login de l'administrateur qui va crÃ©er le nouveau professeur.
	 * @param newTeacherLogin
	 * 				Le login du nouveau professeur.
	 * @param teacherID
	 * 				L'identifiant du nouveau professeur.
	 * @param firstname
	 * 				Le prÃ©nom du nouveau professeur.
	 * @param surname
	 * 				Le nom du nouveau professeur.
	 * @param pwd
	 * 				Le mot de passe du nouveau professeur.
	 * @return
	 * 		Un boolean indiquant si le nouveau professeur a bien Ã©tÃ© crÃ©Ã©
	 */
	public boolean addTeacher(String adminLogin, String newTeacherLogin, int teacherID, String firstname,
			String surname, String pwd) {
		boolean isTeacherAdded = false;
		//System.out.println("je rentre dans addTeacher");
		Admin newTeacher;
		if (this.userTable.get(adminLogin) instanceof Admin && this.userTable.get(newTeacherLogin) == null) {
			newTeacher = new Admin(teacherID, newTeacherLogin, pwd, firstname, surname);
			this.userTable.put(newTeacherLogin, newTeacher);
			isTeacherAdded = true;
			saveDB();
		}
		return isTeacherAdded;
	}

	/**
	 * Fonction permettant d'ajouter un Ã©tudiant. Elle renvoie true si l'Ã©tudiant a Ã©tÃ© crÃ©Ã© et false sinon. 
	 * Cette fonction devra tester si l'Ã©tudiant existe dÃ©jÃ  ou non, puis elle devra le sauvegarder dans la base de donnÃ©e.
	 * @param adminLogin
	 * 				Le login de l'administrateur qui va crÃ©er le nouvel Ã©tudiant.
	 * @param newStudentLogin
	 * 				Le login du nouvel Ã©tudiant.
	 * @param studentID
	 * 				L'identifiant du nouvel Ã©tudiant.
	 * @param firstname
	 * 				Le prÃ©nom du nouvel Ã©tudiant.
	 * @param surname
	 * 				Le nom du nouvel Ã©tudiant.
	 * @param pwd
	 * 				Le mot de passe du nouvel Ã©tudiant.
	 * @return
	 * 		Un boolean indiquant si le nouvel Ã©tudiant a bien Ã©tÃ© crÃ©Ã©
	 */
	public boolean addStudent(String adminLogin, String newStudentLogin, int studentID, String firstname,
			String surname, String pwd) {
		boolean isStudentAdded = false;
		Student newStudent;
		if (this.userTable.get(adminLogin) instanceof Admin && this.userTable.get(newStudentLogin) == null) {
			newStudent = new Student(studentID, newStudentLogin, pwd, firstname, surname);
			this.userTable.put(newStudentLogin, newStudent);
			isStudentAdded = true;
			saveDB();
		}
		return isStudentAdded;
	}

	/**
	 * Fonction permettant de supprimer un utilisateur. Elle renvoie true si l'utilisateur a Ã©tÃ© supprimÃ© et false sinon. 
	 * Cette fonction devra tester si l'utilisateur existe ou non, puis elle devra le retirer de la base de donnÃ©e. 
	 * !!!!!! Si c'est un Ã©tudiant, il faudra penser Ã  le retirer du groupe auquel il appartient. !!!
	 * @param adminLogin
	 * 				Le login de l'administrateur qui va supprimer l'utilisateur.
	 * @param userLogin
	 * 				Le login d'utilisateur Ã  supprimer.
	 * @return
	 * 		Un boolean indiquant si l'utilisateur a bien Ã©tÃ© supprimÃ©.
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
	 * Fonction permettant d'ajouter un groupe. Elle renvoie true si le groupe a Ã©tÃ© ajoutÃ© et false sinon. 
	 * Cette fonction devra tester si le groupe existe dÃ©jÃ  ou non, puis elle devra le crÃ©er et le sauvegarder dans la base de donnÃ©e. 
	 * @param adminLogin
	 * 				Le login de l'administrateur qui va crÃ©er le groupe.
	 * @param groupID
	 * 				L'identifiant du groupe Ã  crÃ©er.
	 * @return
	 * 		Un boolean indiquant si le groupe a Ã©tÃ© crÃ©Ã©.
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
	 * Fonction permettant de supprimer un groupe. Elle renvoie true si le groupe a Ã©tÃ© supprimÃ© et false sinon. 
	 * 
	 * @param adminLogin
	 * 				Le login de l'administrateur qui va supprimer le groupe.
	 * @param groupID
	 * 				Identifiant du groupe Ã  supprimer.
	 * @return
	 * 		Un boolean indiquant si le groupe a bien Ã©tÃ© supprimÃ©.
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
	 * Fonction permettant de rÃ©cupÃ©rer l'identifiant de groupe de l'Ã©tudiant Ã  partir de son login. Elle renvoie l'identifiant du groupe de l'Ã©tudiant s'il existe et -1 sinon.
	 * 
	 * @param studentLogin
	 * 		Le login de l'Ã©tudiant
	 * @return
	 * 		L'identifiant de groupe de l'Ã©tudiant 
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
	 * Fonction permettant de rÃ©cupÃ©rer le nom et le prÃ©nom de l'utilisateur Ã  partir de son login
	 * 
	 * @param userLogin
	 * 		Le login de l'utilisateur
	 * @return
	 * 		Une chaine de caractÃ¨re contenant le prÃ©nom et le nom de l'utilisateur
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
	 * Fonction permettant de rÃ©cupÃ©rer la classe de l'utilisateur Ã  partir de son login et de son mot de passe. 
	 * Elle renvoie :
	 * 			- "" si l'utilisateur n'est pas reconnu (vÃ©rification du login et mdp).
	 * 			- "Student" si l'utilisateur est un Ã©tudiant 
	 *			- "Teacher" si l'utilisateur est un professeur
	 *			- "Administrator" si l'utilisateur est un administrateur 
	 *
	 * @param userLogin
	 * 		Le login de l'utilisateur
	 * @param userPwd
	 * 		Le mot de passe de l'utilisateur
	 * @return
	 * 		Une chaine de caractÃ¨re contenant la classe de l'utilisateur
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
