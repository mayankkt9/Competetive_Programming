package facade_design_pattern;

import java.util.Date;
import java.util.List;

public class ReminderVisitor extends NodeVisitor {

	Facade facade;

	@Override
	void visitFacade(Facade facade) {
		
		this.facade = facade;
		// Visiting Each Course in the Facade
		Person currentPerson = facade.thePerson;
		List<Course> courseList = currentPerson.courseList;
		System.out.println("Person - "+currentPerson.id);
		System.out.println(currentPerson.id+" is enrolled in these Courses");
		for(int i=0;i<courseList.size();i++){
			System.out.println(courseList.get(i).getCourseId());
		}
		visitCourse(facade.classCourseList);
		
	}

	@Override
	void visitAssignement(Assignment assignment) {
		
		System.out.println(" Reminding Time Left - "+(assignment.getDuedate().getTime()-(new Date().getTime()))/(1000 * 60 * 60 * 24)+" days");

	}

	@Override
	void visitCourse(ClassCourseList course) {
		// Visiting Each Assignment
		System.out.println("Getting this user Assignments");
		Person currentPerson = facade.thePerson;
		List<Course> courseList = currentPerson.courseList;
		List<Assignment> aList = course.getAssignmentList();
		for(int i=0;i<aList.size();i++)
		{
			if(courseList.contains(aList.get(i).getCourse()))
				System.out.print(aList.get(i));
			visitAssignement(aList.get(i));
		}

	}

}
