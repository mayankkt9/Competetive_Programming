package facade_design_pattern;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Assignment {
	private String id;
	private Course course = new Course();
	private List<Solution> solution = new ArrayList<Solution>();
	String question;
	Date duedate;

	public Assignment(String id, Course course, String question, Date duedate) {
		super();
		this.id = id;
		this.course = course;
		course.addAssignment(this);
		this.question = question;
		this.duedate = duedate;
	}

	public void addSolution(Solution sol) {
		solution.add(sol);
	}

	public void addAllSolution(List<Solution> sol) {
		solution.addAll(sol);
	}

	@Override
	public String toString() {
		String string =id + "\t"+ course.getCourseId() + "\t" + question + "\t"+ duedate;
		return string;
	}

	public void accept(NodeVisitor visitor) {
		visitor.visitAssignement(this);

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Solution> getSolution() {
		return solution;
	}

	public void setSolution(List<Solution> solution) {
		this.solution = solution;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Date getDuedate() {
		return duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}
	
	
}
