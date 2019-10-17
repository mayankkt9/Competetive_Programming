package facade_design_pattern;

import java.util.*;
import java.util.ArrayList;

public abstract class Person implements UserInfoItem {

	protected String name;
	protected String id;
	protected String password;
	protected UserType userType;
	protected CourseMenu courseMenu = new CourseMenu();
	protected List<Course> courseList = new ArrayList<>();

	abstract CourseMenu createCourseMenu(NCourseLevel nCourseLevel);

	abstract CourseMenu showMenu(NCourseLevel nCourseLevel);

	abstract Assignment createAssignment(Course course);

	abstract void addCourseList(List<Course> course);

	void showAddButtons() {
		courseMenu.showAddButtons();
	}

	void showViewButtons() {
		courseMenu.showViewButtons();
	}

	void showRadios() {
		courseMenu.showRadios();
	}

	void showComboxes() {
		courseMenu.showComboxes();
	}

	void showLabels() {
		courseMenu.showLabel();
	}

}
