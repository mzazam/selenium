package profile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StudentInformation {
		
	BufferedReader in; 
	PrintWriter out;
	Scanner s;
	
	Student student;
	ArrayList<Student> studentList; 
	String lname;
	String id;
	int index;
	
	public StudentInformation() {
		student = new Student();
		studentList = new ArrayList<Student>();
	}
	
	public ArrayList<Student> loadAllStudent() {
			try {
				s = new Scanner(new BufferedReader(new FileReader("c:\\jwork\\pnt\\studentinfo.txt")));
				
				//load all student data from the text file 
							
				while(s.hasNext()) {
					String fname = s.next();
					String lname = s.next();
					String id    = s.next();
					String dob   = s.next();
					String major = s.next();
					String credit= s.next();
					String gpa   = s.next();
					String ytCom = s.next();
					
					student = new Student(fname, lname, id, dob, major, credit, gpa, ytCom);
					studentList.add(student);
					
					fname = "";
					lname = "";
					id    = "";
					dob   = "";
					major = "";
					credit= "";
					gpa   = "";
					ytCom = "";
				}
				
				
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (s != null) {
					s.close();
				}
			}
			return studentList;
	}
	
	public void enterNewStudent() {
		student.newStudent();
		studentList.add(student);
	}
	
	public void viewStudent() {
		student.viewStudent();
	}
	
	public void viewAllStudents(ArrayList<Student> studentList1) {
		Iterator it = studentList.iterator();
		while (it.hasNext()) {
			student = (Student)it.next();
			student.viewStudent();
		}
	}
	
	public int findStudentById(ArrayList<Student> studentList, String id) {
		this.studentList = studentList;
		this.id = id;
		Iterator it = studentList.iterator();
			int count = 0;
			while (it.hasNext()) {
				Student s = (Student)it.next();
				if (s.getId().equalsIgnoreCase(id)) {
					return count;
				}
				count++;
			}
			count = 0;           //no customer is found
			return count; 
	}
	
	public void findStudentInformationById(ArrayList<Student> studentList, String id) {
		this.studentList = studentList;
		this.id = id;
		index = findStudentById(studentList, id);
		student = studentList.get(index);
		student.viewStudent();
	}
	
	public int findStudentByLastName(ArrayList<Student> studentList, String lname) {
		this.studentList = studentList;
		this.lname = lname;
		Iterator it = studentList.iterator();
		int count = 0;
		while (it.hasNext()) {
			Student s = (Student)it.next();
			if (s.getLName().equalsIgnoreCase(lname)) {
				return count;
			}
			count++;
		}
		count = 0;           //no customer is found
		return count; 
	}
	
	public void findStudentInformationByLastName(ArrayList<Student> studentList, String lname) {
		this.studentList = studentList;
		this.lname = lname;
		index = findStudentByLastName(studentList, lname);
		student = studentList.get(index);
		student.viewStudent();
	}
	
	public void enrollStudent(ArrayList<Student> studentList, String id) {
		this.studentList = studentList;
		this.id = id;
		if (findStudentById(studentList, id) != 0) {
			index = findStudentById(studentList, id);
			student = studentList.get(index);
			student.enrollCourses();
			student.displayEnrolledCourses();
		} else {
			System.out.println("No Student With " + id + " Id Is Not Found");
		}
			
	}
	
	public void updateStudentRecord(ArrayList<Student> studentList, String id) {
		this.studentList = studentList;
		this.id = id;
		if (findStudentById(studentList, id) != 0) {
			index = findStudentById(studentList, id);
			student = studentList.get(index);
			student.updateStudentRecord();
			student.displayUpdatedRecord();
		} else {
			System.out.println("No Student With " + id + " Id Is Not Found");
		}
	}
	
	public void deleteStudent(ArrayList<Student> studentList, String id) {
		this.studentList = studentList;
		this.id = id;
		if (findStudentById(studentList, id) != 0) {
			index = findStudentById(studentList, id);
			student = studentList.get(index);
			studentList.remove(index);
			System.out.println(student.getFName() + " " + student.getLName() + " Has Been Removed From  The List");
		} else {
			System.out.println("No Student With " + id + " Id Is Not Found");
		}
	}
	
	public void clearAllStudentRecords(ArrayList<Student> studentList) {
		studentList = new ArrayList<Student>();
		saveStudentInformation(studentList);
	}
	
	public void quit() {
		saveStudentInformation(studentList);
	}
	
	public void saveStudentInformation(ArrayList<Student> studentList) {
		try {
				out = new PrintWriter(new FileWriter("c:\\jwork\\pnt\\studentinfo.txt"));
				if (studentList.size() > 0) {
					Iterator it = studentList.iterator();
					System.out.println("\nFollowing Student Informations Have Been Saved\n");
					while (it.hasNext()) {
						student = (Student)it.next();
					 
						String fname = student.getFName();
						out.print(fname + " ");
				
						String lname = student.getLName();
						out.print(lname + " ");
				
						String id = student.getId();
						out.print(id + " ");
				
						String dob = student.getDob();
						out.print(dob + " ");
				
						String major = student.getMajor();
						out.print(major + " ");
				    
						String credits = student.getCompletedCredits();
						out.print(credits + " ");
				
						String gpa = student.getGpa();
						out.print(gpa + " ");
				    
						String ytGra = student.getYearToGraduate();
						out.println(ytGra);
				    
						student.viewStudent();
				    
					}
				} else {
					System.out.println("The Student Information File is Empty");
				}
				
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (out != null) {
					out.close();
				}
			}
		}
}
		