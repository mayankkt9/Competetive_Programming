package facade_design_pattern;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Facade {
	UserType userType;
	Course theSelectedCourse;
	NCourseLevel nCourseLevel;
	List<Course> theCoursesList = new ArrayList<>();
	List<Student> theStudentList = new ArrayList<>();
	List<Instructor> theInstructorList = new ArrayList<>();
	Person thePerson;
	List<Assignment> assignmentList = new ArrayList<>();
	CourseMenu courseMenu = new CourseMenu();
	UserCourseAssign userCourse = new UserCourseAssign();
	ClassCourseList classCourseList = new ClassCourseList();

	public Person login(Person person) {
		// Login Successful Authentication
		for (int i = 0; i < this.theStudentList.size(); i++) {
			if (person.getUserId().equals(theStudentList.get(i).getUserId()))
				this.thePerson = theStudentList.get(i);
				return theStudentList.get(i);
		}
		for (int i = 0; i < this.theInstructorList.size(); i++) {
			if (person.getUserId().equals(theInstructorList.get(i).getUserId()))
				this.thePerson = theInstructorList.get(i);
				return theInstructorList.get(i);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> createUser(UserInfoItem userInfoItem)
			throws FileNotFoundException {

		if (userInfoItem.getClass().getSimpleName().toString()
				.equals("Student")) {
			StudentList studentList = new StudentList();
			List<Student> getStudentList = studentList.createStudentList();
			theStudentList = getStudentList;
			return (List<T>) getStudentList;
		} else if (userInfoItem.getClass().getSimpleName().toString()
				.equals("Instructor")) {
			InstructorList insList = new InstructorList();
			List<Instructor> getInstructorList = insList.createInstructorList();
			theInstructorList = getInstructorList;
			return (List<T>) getInstructorList;

		}
		return null;

	}

	public Assignment addAssignemnt(Person person, Course course,
			String question, Date dueDate) {

		Assignment temp = new Assignment(
				String.valueOf((int) (Math.random() * 1000)), course, question,
				dueDate);

		if (person.getUserType() == UserType.Student) {
			HighLevelCourseMenu hl = new HighLevelCourseMenu();
			hl.studentAssignmentMenu();
		}
		if (person.getUserType() == UserType.Instructor) {
			HighLevelCourseMenu hl = new HighLevelCourseMenu();
			hl.instructorAssignmentMenu();
		}
		assignmentList.add(temp);
		classCourseList.setAssignmentList(assignmentList);
		return temp;

	}

	public void viewAssignment(Assignment assignment, Person person) {

		System.out.println("Viewing Assignment :\n" + assignment);

		if (person.getUserType() == UserType.Student) {
			HighLevelCourseMenu hl = new HighLevelCourseMenu();
			hl.studentAssignmentMenu();
		}
		if (person.getUserType() == UserType.Instructor) {
			HighLevelCourseMenu hl = new HighLevelCourseMenu();
			hl.instructorAssignmentMenu();
		}
	}

	public ClassCourseList createCourseList() throws FileNotFoundException {
		ClassCourseList courseList = new ClassCourseList();
		classCourseList.setCourseList(courseList.createCourseList());

		return classCourseList;
	}

	public void attachCourseToUser(List<Course> courseList,
			List<Student> studentList, List<Instructor> instructorList)
			throws FileNotFoundException {
		UserCourseAssign userCourseAssign = new UserCourseAssign();
		userCourseAssign.assign(courseList, studentList, instructorList);
		this.userCourse = userCourseAssign;
	}

	public void accept(NodeVisitor visitor) {
		visitor.visitFacade(this);

	}

	public void courseOperation(Person obj, NCourseLevel nCourseLevel) {
		obj.showMenu(nCourseLevel);
	}

}
