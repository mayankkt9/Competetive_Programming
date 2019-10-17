package facade_design_pattern;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class MainClass {

	public static void main(String[] args) throws FileNotFoundException,
			ParseException {

		// Creating Facade object, student list, instructor list, course list
		// from the input file provided, and then attaching it to the Users,
		// After this all user will specifically have courses in their object.
		Facade facade = new Facade();
		List<Student> studentList = facade.createUser(new Student());
		List<Instructor> instructorList = facade.createUser(new Instructor());
		ClassCourseList courseList = facade.createCourseList();
		facade.attachCourseToUser(courseList.getCourseList(), studentList,
				instructorList);

		// Printing out all Student with their Course Details
		for (int i = 0; i < studentList.size(); i++) {
			System.out.print(studentList.get(i).id + " - ");
			for (int j = 0; j < studentList.get(i).courseList.size(); j++) {
				System.out.print(courseList.getCourseList().get(j)
						.getCourseId()
						+ " ");
			}
			System.out.println();
		}

		// Printing out all Instructor with their Course Details
		for (int i = 0; i < instructorList.size(); i++) {
			System.out.print(instructorList.get(i).id + " - ");
			for (int j = 0; j < instructorList.get(i).courseList.size(); j++) {
				System.out.print(courseList.getCourseList().get(j)
						.getCourseId()
						+ " ");
			}
			System.out.println();
		}
		System.out.println();

		// Creating and Printing out Assignment
		Assignment a1 = facade.addAssignemnt(instructorList.get(0), courseList
				.getCourseList().get(0), "--Questions--", new SimpleDateFormat(
				"dd/MM/yyyy").parse("25/10/2019"));
		Assignment a2 = facade.addAssignemnt(instructorList.get(0), courseList
				.getCourseList().get(0), "--Questions--", new SimpleDateFormat(
				"dd/MM/yyyy").parse("24/10/2019"));
		Assignment a3 = facade.addAssignemnt(instructorList.get(0), courseList
				.getCourseList().get(1), "--Questions--", new SimpleDateFormat(
				"dd/MM/yyyy").parse("23/10/2019"));
		System.out.println("Assignment Created :");
		System.out.println("ID\tCourse\tQuestion\tDueDate");
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);

		System.out.println();

		// Bridge Pattern and Factory Pattern Testing
		System.out.println("Testing Bridge and factory Pattern\n");
		Person p1 = new Student("mayank", "1111");
		Person p2 = new Instructor("mfindler", "2222");
		p1.showMenu(NCourseLevel.HIGH_LEVEL);
		p1.showMenu(NCourseLevel.LOW_LEVEL);
		p2.showMenu(NCourseLevel.HIGH_LEVEL);
		p2.showMenu(NCourseLevel.LOW_LEVEL);

		// Iterator Pattern Testing
		System.out.println("\nTesting Iterator Pattern\n");
		CourseIterator itr = new CourseIterator(courseList.getCourseList());
		while (itr.hasNext()) {
			System.out.println(((Course) itr.next()).getCourseId());
		}
		System.out.println();

		// VISITOR PATTERN
		// Login
		Person pepe = new Student("pepe", "1111");
		Person result_person = facade.login(pepe);
		if (result_person == null)
			System.out.println("Login Failed");
		System.out.println("Login Successful");
		System.out.println();
		facade.accept(new ReminderVisitor());

	}
}