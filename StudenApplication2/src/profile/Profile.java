package profile;

public class Profile {
	private String fName;
	private String lName;
	private String id;
	private String dob;
	
	public Profile() {
		
	}
	
	public Profile(String fName, String lName, String id, String dob) {
		this.fName = fName;
		this.lName = lName;
		this.id = id;
		this.dob = dob;
	}
	
	public void setFirstName(String fName) {
		this.fName = fName;
	}
	public String getFirstName() {
		return fName;
	}
	public void setLirstName(String lName) {
		this.lName = lName;
	}
	public String getLirstName() {
		return lName;
	}
	public void setId(String sId) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDob() {
		return dob;
	}
	

}
