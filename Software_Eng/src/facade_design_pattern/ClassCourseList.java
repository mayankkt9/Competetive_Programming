package facade_design_pattern;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassCourseList extends facade_design_pattern.ArrayList {
	private List<Course> courseList = new ArrayList<Course>();
	private List<Assignment> assignmentList = new ArrayList<Assignment>();

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public List<Assignment> getAssignmentList() {
		return assignmentList;
	}

	public void setAssignmentList(List<Assignment> assignmentList) {
		this.assignmentList = assignmentList;
	}

	public List<Course> createCourseList() throws FileNotFoundException {
		System.out.println("Creating Courses List from Input File");

		String file_path = "/Users/mayankkataruka/Desktop/Work/Comp_Prog_Workspace/Software_Eng/src/input_files/CourseInfo.txt";
		File file = new File(file_path);

		Scanner sc = new Scanner(file);
		while (sc.hasNextLine()) {
			String str = sc.nextLine().trim();
			courseList.add(new Course(str));
		}
		System.out.println("Courses Created :\n" + this);
		return courseList;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "";
		for (int i = 0; i < courseList.size(); i++) {
			str += courseList.get(i).getCourseId() + "\n";
		}
		return str;
	}

	public Course getSelectedCourse(int number) {

		return courseList.get(number - 1);

	}

	public CourseIterator iterator() {
		return new CourseIterator(courseList);
	}

	public void accept(NodeVisitor visitor) {
		visitor.visitCourse(this);

	}

}
