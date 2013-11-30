package useapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import profile.Student;
import profile.StudentInformation;

public class UseStudentApp {
    static Student student = new Student();
	static ArrayList<Student> sList = new ArrayList<Student>();
	static String id;
	static String lname;
	
	public static void main(String[] args) throws IOException {
       
	   StudentInformation sinfo = new StudentInformation();
	   char c;
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   sList = sinfo.loadAllStudent();
	   Menu.getMenu();	
	   
	   do {
		     c = (char) br.read();
	    	 switch(c) {
	         	case 'n' : 
	         	case 'N' :	
	         		sinfo.enterNewStudent();
	         		break;
	         	case 'r' :
	         	case 'R' :
	         		Student.label();
	         		sinfo.viewStudent();
	         		break;
	         	case 'e' :
	         	case 'E' :
	         		getStudentId();
	         		sinfo.enrollStudent(sList, id);
	         		break;
	         	case 'i' :
	         	case 'I' :
	         		getStudentId();
	         		Student.label();
	         		sinfo.findStudentInformationById(sList, id);
	         		break;
	         	case 'l' :
	         	case 'L' :
	         		getStudentLastName();
	         		Student.label();
	         		sinfo.findStudentInformationByLastName(sList, lname);
	         		break;
	         	case 'u' :
	         	case 'U' :
	         		getStudentId();
	         		sinfo.updateStudentRecord(sList, id);
	         		break;
	         	case 'a' :
	         	case 'A' :
	         		Menu.getInfo();
	         		break;
	         	case 'c' :
	         	case 'C' :
	         		sinfo.clearAllStudentRecords(sList);
	         		break;
	         	case 'd' :
	         	case 'D' :
	         		getStudentId();
	         		sinfo.deleteStudent(sList, id);
	         		break;
	         	case 'm' :
	         	case 'M' :
	         		Menu.getMenu();
	         		break;
	         	case 's' :
	         	case 'S' :
	         		sinfo.saveStudentInformation(sList);
	         		break;
	         	case 'v' :
	         	case 'V' :
	         		Student.label();
	         		sinfo.viewAllStudents(sList);
	         		break;
	         	case 'q' :
	         	case 'Q' :
	         		sinfo.quit();
	         		break;	
	         	default :
	         		System.out.println("");
	         		break;
	         }
	       } while(c != 'q');
	  }
	
	public static void getStudentId(){
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please Enter Student Id: ");
			id = in.readLine();
		} catch(IOException ex) {
			ex.printStackTrace();
		} 
	}
	
	public static void getStudentLastName(){
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please Enter Student Name: ");
			lname = in.readLine();
		} catch(IOException ex) {
			ex.printStackTrace();
		} 
	}
}
	