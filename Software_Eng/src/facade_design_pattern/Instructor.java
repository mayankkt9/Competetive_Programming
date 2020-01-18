package facade_design_pattern;

import java.util.List;

public class Instructor extends Person {

	public Instructor() {
		// TODO Auto-generated constructor stub
	}

	public Instructor(String name, String id, String password) {

		this.userType = UserType.Instructor;
		this.name = name;
		this.id = id;
		this.password = password;
	}

	public Instructor(String id, String password) {

		this.userType = UserType.Instructor;

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
		System.out.println("Instructor Create Menu");
		if (nCourseLevel == NCourseLevel.HIGH_LEVEL) {
			System.out
					.println("Creating High Level Course Menu for Instructor");
			courseMenu = new HighLevelCourseMenu();
			showMenu(nCourseLevel);
		} else {
			System.out.println("Creating Low Level Course Menu for Instructor");
			courseMenu = new LowLevelCourseMenu();
			showMenu(nCourseLevel);
		}
		return courseMenu;
	}

	@Override
	CourseMenu showMenu(NCourseLevel nCourseLevel) {
		System.out.println("Instructor Show Menu");

		if (nCourseLevel == nCourseLevel.HIGH_LEVEL) {
			System.out.println("Showing High Level Course Menu for Instructor");

			courseMenu.showAddButtons();
			courseMenu.showViewButtons();
			courseMenu.showRadios();
			courseMenu.showComboxes();
			courseMenu.showLabel();

		} else {
			System.out.println("Showing Low Level Course Menu for Instructor");

			courseMenu.showAddButtons();
			courseMenu.showViewButtons();
			courseMenu.showRadios();
			courseMenu.showComboxes();
			courseMenu.showLabel();
		}
		return courseMenu;
	}

	@Override
	Assignment createAssignment(Course course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void addCourseList(List<Course> courseList) {
		// TODO Auto-generated method stub

		this.courseList = courseList;
	}

	@Override
	void gradeSolution(Solution sol) {
		// TODO Auto-generated method stub
		sol.setGrade("A");

	}

	@Override
	void reportSolution(Solution sol) {
		// TODO Auto-generated method stub
		sol.setReport("Reported Flag set");
	}

}
