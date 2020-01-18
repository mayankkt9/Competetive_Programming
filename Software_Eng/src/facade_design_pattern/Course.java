package facade_design_pattern;

import java.util.ArrayList;
import java.util.List;

public class Course {

	private String courseId;
	private String courseName;
	private String courseDescription;
	private List<Assignment> assignmentList = new ArrayList<>();

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String courseId) {
		super();
		this.courseId = courseId;

	}

	public void addAssignment(Assignment assignment) {
		assignmentList.add(assignment);
	}

	public Course(String courseId, String courseName, String courseDescription) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = courseId + "\t" + courseName + "\t" + courseDescription;
		return str;
	}

}
