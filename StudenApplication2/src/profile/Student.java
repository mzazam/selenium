package profile;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

import degree.Course;
import degree.Degree;
import degree.Grades;
import finance.Finance;
	


	public class Student extends Profile implements Info{
		
		private String fname;
		private String lname;
		private String id;
		private String dob;
		private String major;
		private String completedCredits;
		private int semisterCredits;
		private String gpa;                 
		private int nCoursesEnrolled;
		private String yearToGraduate;
				
		BufferedReader in; 
		PrintWriter out;
		Scanner s;
			
		Student student;
		Course course;
		Course[] courses = new Course[5];
		Degree degree = new Degree();
		Finance finance = new Finance();
		
		
		public Student() {
			
		}
		
		public Student(String fname, String lname, String id, String dob, String major, String credit, String gpa, String yearToGraduate) {
			this.fname = fname;
			this.lname = lname;
			this.id = id;
			this.dob = dob;
			this.major = major;
			this.completedCredits = credit;
			this.gpa = gpa;
			this.yearToGraduate = yearToGraduate;
		}
		
		public void setFName(String fname) {
			this.fname = fname;
		}
		public String getFName() {
			return fname;
		}
		public void setLName(String lname) {
			this.lname = lname;
		}
		public String getLName() {
			return lname;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getId() {
			return id;
		}
		public void setDob(String dob){
			this.dob = dob;
		}
		public String getDob() {
			return dob;
		}
		public void setMajor(String major) {
			this.major = major;
		}
		public String getMajor() {
			return major;
		}
		public void setCompletedCredits(String credit) {
			completedCredits = credit;
		}
		public String getCompletedCredits() {
			return completedCredits;
		}
		public void setGpa(String gpa) {
			this.gpa = gpa;
		}
		public String getGpa() {
			return gpa;
		}
		public void setYearToGraduate(String year) {
			yearToGraduate = year;
		}
		public String getYearToGraduate() {
			return yearToGraduate;
		}
		
		public void updateCredit(int icredit) {
			completedCredits = String.valueOf(icredit);
		}
		
		public void updateGpa(double igpa) {
			gpa = String.valueOf(igpa);
		}
		
		
		public Student newStudent() {
			
			try {
				in = new BufferedReader(new InputStreamReader(System.in));
				out = new PrintWriter(new FileWriter("c:\\jwork\\pnt\\studentinfo.txt", true));
				//out = new PrintWriter(new FileWriter("\\data\\studentinfo.txt", true));
				//Retrieve Student Information From Command Line
				//Pass Them To Student Constructor
				//Save The Information In A Text File
				
				System.out.println(); 
				System.out.println("Enter Student First Name: ");
				fname = in.readLine();
				out.print(fname + " ");
				
				System.out.println("Enter Student Last Name: ");
				lname = in.readLine();
				out.print(lname + " ");
				
				System.out.println("Enter Student Id: ");
				id = in.readLine();
				out.print(id + " ");
				
				System.out.println("Enter Student Dob: ");
				dob = in.readLine();
				out.print(dob + " ");
				
				System.out.println("Enter Student Major: ");
				major = in.readLine();
				degree.setMajor(major + " ");
				out.print(major + " ");
				
				System.out.println("Enter Credits Student Already Earned: ");
				completedCredits = in.readLine();
				int nCredit = Integer.parseInt(completedCredits);
				degree.setNumCreditCompleted(nCredit);
				out.print(completedCredits + " ");
				
				System.out.println("Enter Student Overall Gpa: ");
				gpa = in.readLine();
				double dGpa = Double.parseDouble(gpa);
				degree.setGpa(dGpa);
				out.print(gpa + " ");
				
				System.out.println("Enter Expected Year of Graduation: ");
				yearToGraduate = in.readLine();
				degree.setYearToGraduate(yearToGraduate);
				out.println(yearToGraduate);
				
				student = new Student(fname, lname, id, dob, major, completedCredits, gpa, yearToGraduate);
				
				
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (out != null) {
					out.close();
				}
			}
			return student;		
		}
		
		public void viewStudent() {
			
			System.out.println(fname + " " + lname + "  " + id + "  " + dob + "  " + major + "  " + completedCredits + "  " + gpa + "  " + yearToGraduate);
		}
		
		public static void label() {
			System.out.println("   Name         Id     Dob          Major      Credet   Gpa   Graduation");
			System.out.println("  ------       ----   ------       ------      ------   ---   ----------");
			
		}
		public void enrollCourses() {
			try {
				in = new BufferedReader(new InputStreamReader(System.in));
				
				double dormCost = 0.0;
				double financialAid = 0.0;
				double tuition = 0.0;
						
				System.out.println("\nHow Many Courses Student Enrolls For This Semister: ");
				String nCourses = in.readLine();
				nCoursesEnrolled = Integer.parseInt(nCourses);
				degree.setNumCoursesEnrolled(nCoursesEnrolled);
				
				for (int i=0; i < nCoursesEnrolled; i++)  {
				    course = new Course();
					
					System.out.println("Enter " + (i+1) + " Course Number : ");
					String cnumber = in.readLine();
					course.setCourseNumber(cnumber);
								
					System.out.println("Enter " + (i+1) + " Course Credit : ");
				    String cCredits = in.readLine();
				    int iCredits = Integer.parseInt(cCredits);
				    course.setCredits(iCredits);
				    			    
				    semisterCredits  = semisterCredits + iCredits;
				    courses[i] = course;
				}
				
				//Calculating tuition
				if (semisterCredits < 12) {
					tuition = 285 * semisterCredits;
				} else {
					tuition = 3420;
				}
				finance.setTution(tuition);
				
				System.out.println("Put The Amount Student Receive As Financial Aid. If None Put 0 : ");
				String aid = in.readLine();
				financialAid = Double.parseDouble(aid);
				finance.setFinancilaAid(financialAid);
				
				System.out.println("Put The Amount If Student Stays In Dormatory. If Not Put 0 : ");
				String dorm = in.readLine();
				dormCost = Double.parseDouble(dorm);
				finance.setRoomAndBoard(dormCost);
				
							
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				
			}
	   }
		
		public void displayEnrolledCourses() {
			if (nCoursesEnrolled != 0) {
				Course.getEnCourseLabel();
				for (int i=0; i<nCoursesEnrolled; i++) {
					courses[i].getEnCourseInfo();
				}
				System.out.println("\nStudent Total Cost For This Semister: $" + finance.calculateTotalCost());
			} else {
				System.out.println("Student Does Not Enroll for This Semister");
			}
		}
		
		public void updateStudentRecord() {
					
			try {
				in = new BufferedReader(new InputStreamReader(System.in));
						
				if (nCoursesEnrolled != 0) {
					System.out.println("Enter Student Final Score For Enrolled Classes:\n");
					for (int i=0; i<nCoursesEnrolled; i++) {
						
						System.out.println("Enter " + courses[i].getCourseNumber() + " final score : ");
						String sScore = in.readLine();
						int score = Integer.parseInt(sScore);
						course.setFinalScore(score);
						courses[i].setLetterGread(score);
						Grades g = courses[i].getLetterGread();
						courses[i].setCourseGpa(g);                      
					}
				} else {
					System.out.println("Student Does Not Enroll For This Semister");
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				
			}
		}
		
		public void displayUpdatedRecord() {
			
			double sTotal = 0.0;
			int sCredits = 0;
			double sGpa = 0.0;
			double overallGpa = 0.0;
			int creditCompleted = 0;
			
			if (nCoursesEnrolled != 0) {
				System.out.println("\nSummmary Of Student Record:");
				System.out.println("\nEnrolled Courses For This Semister:");
				Course.getCourseLabel();
				for (int j=0; j<nCoursesEnrolled; j++) {
					courses[j].getCourseInfo();
					sTotal = sTotal + (courses[j].getCourseGpa() * courses[j].getCredits());
					sCredits = sCredits + courses[j].getCredits();
				}
				sGpa = sTotal/sCredits;
				System.out.println();
				System.out.println("Semister Credits : " + sCredits);
				System.out.format("Semister Gpa     : %.2f", sGpa);
				
				int tCredits = Integer.parseInt(completedCredits);
				double tGpa = Double.parseDouble(gpa);
				overallGpa = ((tCredits * tGpa) + (sCredits * sGpa))/(sCredits + tCredits);
				creditCompleted = tCredits + sCredits;
				System.out.println("\nTotal Credits    : " + creditCompleted);
				System.out.format("Overall Gpa      : %.2f", overallGpa);
				System.out.println();
				
				//Update Student Main Record
				updateCredit(creditCompleted);
				updateGpa(overallGpa);
			} else {
				System.out.println("Student Does Not Enroll For This Semister");
			}
		}


}
