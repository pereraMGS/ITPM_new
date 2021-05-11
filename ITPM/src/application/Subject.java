package application;

public class Subject {

	// Create a class attribute
	String year;
	String sem;
	String name;
	String code;
	String lecHrs;
	String tuteHrs;
	String labHrs;
	String EvaHrs;

	// Create a class constructor for the Subject class
	public Subject(String offerdYear, String offerdSem, String subName, String subCode, String numOfLecHrs, String numOfTuteHrs, String numOfLabHrs, String numOfEvaluationHrs) {
		super();
		this.year = offerdYear;
		this.sem = offerdSem;
		this.name = subName;
		this.code = subCode;
		this.lecHrs = numOfLecHrs;
		this.tuteHrs = numOfTuteHrs;
		this.labHrs = numOfLabHrs;
		this.EvaHrs = numOfEvaluationHrs;
	}

	//Generate Getters and Setters
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSem() {
		return sem;
	}

	public void setSem(String sem) {
		this.sem = sem;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLecHrs() {
		return lecHrs;
	}

	public void setLecHrs(String lecHrs) {
		this.lecHrs = lecHrs;
	}

	public String getTuteHrs() {
		return tuteHrs;
	}

	public void setTuteHrs(String tuteHrs) {
		this.tuteHrs = tuteHrs;
	}

	public String getLabHrs() {
		return labHrs;
	}

	public void setLabHrs(String labHrs) {
		this.labHrs = labHrs;
	}

	public String getEvaHrs() {
		return EvaHrs;
	}

	public void setEvaHrs(String evaHrs) {
		EvaHrs = evaHrs;
	}
	
}
