package useapp;

public class Menu {
	public static void getMenu() {
		System.out.println("---------------------------------------------------------------------");
		System.out.println("-     WELLCOME TO PEOPLE N TECH, SCHOOL OF SOFTWARE ENGINEERING     -");
		System.out.println("-           	    STUDENT INFORMATION SYSTEM                      -");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("      Menu----------------> M | About SIS-------------> A            ");
		System.out.println("-     New Student---------> N | Enroll Course---------> E           -");
		System.out.println("-     Student Record------> R | Update Record---------> U           -");
		System.out.println("-     Search By Id--------> I | Search By Last Name---> L           -");
		System.out.println("-     View All Students---> V | Delete Student--------> D           -");
		System.out.println("-     Clear All Record----> C | Quit------------------> Q           -");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("-             Please Select Enrty From Above Menu:                  -");
		System.out.println("---------------------------------------------------------------------");
		
	}
	
	public static void getInfo() {
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("-     WELLCOME TO PEOPLE N TECH, SCHOOL OF SOFTWARE ENGINEERING       -");
		System.out.println("-           	    STUDENT INFORMATION SYSTEM                        -");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("-SIS is user interactive student record keeping system. It's main menu-");
		System.out.println("-displays options about the system. User can add new student, enroll  -");
		System.out.println("-students for the semister, update student record, search students by -");
		System.out.println("-their id or name, delete a student who has graduated or transfered.  -");
		System.out.println("-                                                                     -");
		System.out.println("-SIS stores data in an internal text file. It retirves all stored data-");
		System.out.println("-when program starts and saves students updated informations when user-");
		System.out.println("-exit the system. To accomodate the text file operations where data is-");
		System.out.println("-stored as text format, we made all variables of major classes String.-");
		System.out.println("-When we need to manipulate the data, we change data from String to   -");
		System.out.println("-primitive data type and change back to String when we store them.    -");
		System.out.println("-                                                                     -");
		System.out.println("-Each input in the system should be without an space. For example, if -");
		System.out.println("-major is Computer Science, the input should be Computr_Science.      -");
		System.out.println("-Because we use Scanner class to retrive data from the text file which-");
		System.out.println("-uses space as separator of one data from another. So, if the system  -");
		System.out.println("-gives an error for retriving data from the storage, please perform   -");
		System.out.println("-option C, Clear All Record, of the main menu and start over again.   -");
		System.out.println("-----------------------------------------------------------------------");
		
	}

}
