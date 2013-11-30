package degree;

public class Degree {
	String major;
	double gpa;
	int numCreditCompleted;
	String yearToGraduate;
	int numCoursesEnrolled;
	Course[] enrolledCourses;
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public double getGpa() {
		return gpa;
	}
	
	public void setNumCreditCompleted(int numCredit) {
		numCreditCompleted = numCredit;
		
	}
	
	public int getNumCreditCompleted() {
		return numCreditCompleted;
	}
	
	public void setNumCoursesEnrolled(int num) {
		numCoursesEnrolled = num;
	}
	
	public int getNumCoursesEnrolled() {
		return numCoursesEnrolled;
	}
	
	public void setEnrolledCourses(Course[] courses) {
		enrolledCourses = courses;
	}
	
	public Course[] getEnrolledCourses() {
		return enrolledCourses;
	}
	
	public void setYearToGraduate(String year) {
		yearToGraduate = year;
	}
	


}
