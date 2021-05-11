package application;

public class Lecturer {

	// Create a class attribute
	String id;
	String name;
	String faculty;
	String dept;
	String center;
	String buiding;
	String level;
	String rank;
	String activeHrs;
	
	// Create a class constructor for the Lecturer class
	public Lecturer(String lecId, String lecName, String Faculty, String Department, String Center, String Building, String Level, String Rank, String ActiveHrs) {
		super();
		this.id = lecId;
		this.name = lecName;
		this.faculty = Faculty;
		this.dept = Department;
		this.center = Center;
		this.buiding = Building;
		this.level = Level;
		this.rank = Rank;
		this.activeHrs = ActiveHrs;
	}

	//Generate Getters and Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public String getBuiding() {
		return buiding;
	}

	public void setBuiding(String buiding) {
		this.buiding = buiding;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getActiveHrs() {
		return activeHrs;
	}

	public void setActiveHrs(String activeHrs) {
		this.activeHrs = activeHrs;
	}
}
