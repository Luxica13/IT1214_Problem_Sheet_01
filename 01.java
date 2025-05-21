class Student{
	private int studentID;
	private String name;
	private int daysAttended;
	
	Student(int studentID, String name, int daysAttended){
		this.studentID = studentID;
		this.name = name;
		this.daysAttended = daysAttended;
	}
	
	public void setStudentID(int studentID){
		this.studentID = studentID;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setDaysAttended(int daysAttended){
		this.daysAttended = daysAttended;
	}
	public int getStudentID(){
		return studentID;
	}
	public String getName(){
		return name;
	}
	public int getDaysAttended(){
		return daysAttended;
	}
}

class Classroom{
	Student[] stud = new Student[10];
	int studCounter=0;
	
	public void addStudent(int studentID, String name, int daysAttended){
		stud[studCounter] = new Student(studentID,name,daysAttended);
		studCounter++;
	}
	
	public void updateDaysAttended(int studentID, int days){
		int i;
		for(i=0; i<studCounter; i++){
			if(stud[i].getStudentID() == studentID){
				stud[i].setDaysAttended(days);
				System.out.println("The attendance of "+stud[i].getName()+" is updated");
				break;
			}
		}
		if(i == studCounter){
			System.out.println("There is no such StudentID Available!");
		}
	}
	
	public void displayDetails(){
		System.out.println("StudentID\t\tName\t\tDaysAttended");
		for(int i=0; i<studCounter; i++){
			System.out.println(stud[i].getStudentID()+"\t\t\t"+stud[i].getName()+"\t\t"+stud[i].getDaysAttended());
		}
	}
}

class Main{
	public static void main(String[] args){
		Classroom c1 = new Classroom();
		c1.addStudent(101,"Amal",20);
		c1.addStudent(102,"Bala",17);
		c1.addStudent(103,"Camal",15);
		c1.updateDaysAttended(102,16);
		c1.updateDaysAttended(104,18);
		c1.displayDetails();
	}
}
