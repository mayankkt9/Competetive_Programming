package facade_design_pattern;

public class Solution {

	private Student student;
	private String solution_posted;
	private String grade;
	private String report;
	
	
	

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Solution(Student student, String solution_posted) {
		super();
		this.student = student;
		this.solution_posted = solution_posted;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getSolution_posted() {
		return solution_posted;
	}

	public void setSolution_posted(String solution_posted) {
		this.solution_posted = solution_posted;
	}

}
