package degree;

public class Course {
	private String name;
	private String courseNumber;
	private int credits;
	private int finalScore;
	private Grades letterGread;
	private double courseGpa;

    //Sending the updated version
	public void setCourseName(String name) {
		this.name = name;
	}
	
	public String getCourseName() {
		return name;
	}
	
	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}
	
	public String getCourseNumber() {
		return courseNumber;
	}
	
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	public int getCredits() {
		return credits;
	}
	
	public void setFinalScore(int score) {
		finalScore = score;
	}
	
	public int getFinalScore() {
		return finalScore;
	}
	
	public void setLetterGread(int score) {
		if (score >= 90) {
			letterGread = Grades.A;
		} else if (score >= 80) {
			letterGread = Grades.B;
		} else if (score >= 70) {
			letterGread = Grades.C;
		} else if (score >= 60) {
			letterGread = Grades.D;
		} else
			letterGread = Grades.F;
	}
	
	public Grades getLetterGread() {
		return letterGread;
	}
	
	public void setCourseGpa(Grades gread) {
		switch(gread) {
		case A : 
			courseGpa = 4.0;
			break;
		case B:
			courseGpa = 3.0;
			break;
		case C:
			courseGpa = 2.0;
			break;
		case D:
			courseGpa = 1.0;
			break;
		case F:
			courseGpa = 0.0;
			break;
		default:
			courseGpa = 0.0;
			break;
			
		}
	}
	
	public double getCourseGpa() {
		return courseGpa;
	}
	
	public static void getCourseLabel() {
		System.out.println("\nCourse\t" + " " + "     Credits\t" + " " + "Letter Gread");
		System.out.println("-------------------------------------------");
	}
	
	public void getCourseInfo() {
		System.out.println(courseNumber + "\t\t" + credits + "\t\t" + letterGread);
	}   
	
	public static void getEnCourseLabel() {
		System.out.println("\nCourse\t" + " " + "      Credits");
		System.out.println("---------------------------------");
	}
	
	public void getEnCourseInfo() {
		System.out.println(courseNumber + "\t\t" + credits);
	}

}
