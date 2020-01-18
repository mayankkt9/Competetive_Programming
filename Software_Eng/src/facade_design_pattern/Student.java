package facade_design_pattern;

import java.util.List;

public class Student extends Person {

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String id, String password) {
		// TODO Auto-generated constructor stub
		userType = UserType.Student;
		this.name = name;
		this.id = id;
		this.password = password;
	}

	public Student(String id, String password) {
		// TODO Auto-generated constructor stub
		userType = UserType.Student;

		this.id = id;
		this.password = password;
	}

	@Override
	public String getName() {

		return this.name;
	}

	@Override
	public UserInfoItem getCurrentUser() {

		return null;
	}

	@Override
	public String getUserId() {

		return this.id;
	}

	@Override
	public String getPassword() {

		return this.password;
	}

	@Override
	public UserType getUserType() {

		return this.userType;
	}

	@Override
	CourseMenu createCourseMenu(NCourseLevel nCourseLevel) {
		System.out.println("Student Create Menu");
		if (nCourseLevel == NCourseLevel.HIGH_LEVEL) {
			System.out.println("Creating High Level Course Menu for Student");
			courseMenu = new HighLevelCourseMenu();
			showMenu(nCourseLevel);
		} else {
			System.out.println("Creating Low Level Course Menu for Student");
			courseMenu = new LowLevelCourseMenu();
			showMenu(nCourseLevel);
		}
		return courseMenu;
	}

	@Override
	CourseMenu showMenu(NCourseLevel nCourseLevel) {
		System.out.println("Student Show Menu");

		if (nCourseLevel == nCourseLevel.HIGH_LEVEL) {
			System.out.println("Showing High Level Course Menu for Student");

			courseMenu.showViewButtons();
			courseMenu.showRadios();
			courseMenu.showComboxes();
			courseMenu.showLabel();

		} else {
			System.out.println("Showing Low Level Course Menu for Student");

			courseMenu.showViewButtons();
			courseMenu.showRadios();
			courseMenu.showComboxes();
			courseMenu.showLabel();
		}
		return courseMenu;
	}

	public void submitSolution(Assignment assignment, String answer) {
		Solution solution = new Solution(this, answer);
		assignment.addSolution(solution);
	}

	@Override
	Assignment createAssignment(Course course) {
		// TODO Auto-generated method stub
		System.out.println("Only TA's are Allowed to Create an assignment");
		return null;
	}

	@Override
	void addCourseList(List<Course> courseList) {
		// TODO Auto-generated method stub
		this.courseList = courseList;

	}

	@Override
	void gradeSolution(Solution sol) {
		// TA Student or Grader Student can grade the solution, just a TA or
		// grader check is required here before grading the solution
		sol.setGrade("A");

	}

	@Override
	void reportSolution(Solution sol) {
		// TODO Auto-generated method stub
		sol.setReport("Reported Flag Set");

	}

}
