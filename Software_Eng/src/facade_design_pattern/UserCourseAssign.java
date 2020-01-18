package facade_design_pattern;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserCourseAssign {

	public void assign(List<Course> courseList, List<Student> studentList,
			List<Instructor> instructorList) throws FileNotFoundException {

		String file_path = "/Users/mayankkataruka/Desktop/Work/Comp_Prog_Workspace/Software_Eng/src/input_files/UserCourse.txt";
		File file = new File(file_path);

		Scanner sc = new Scanner(file);

		while (sc.hasNextLine()) {
			String[] str = sc.nextLine().split(":");
			String courseId = str[1];
			Course courseToAdd = new Course();
			boolean match = false;
			for (int i = 0; i < courseList.size(); i++) {
				if (courseList.get(i).getCourseId().equals(courseId))
					courseToAdd = courseList.get(i);
				match = true;
			}
			if (match == true) {
				String user = str[0];
				if (getStudentFromID(studentList, user) != null) {

					Student s = getStudentFromID(studentList, user);
					s.courseList.add(courseToAdd);
				}
				if (getInstructorFromID(instructorList, user) != null) {
					Instructor s = getInstructorFromID(instructorList, user);
					s.courseList.add(courseToAdd);
				}
			}
		}

	}

	public Student getStudentFromID(List<Student> studentList, String ID) {
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getUserId().equals(ID))
				return studentList.get(i);
		}
		return null;

	}

	public Instructor getInstructorFromID(List<Instructor> instructorList,
			String ID) {
		for (int i = 0; i < instructorList.size(); i++) {
			if (instructorList.get(i).getUserId().equals(ID))
				return instructorList.get(i);
		}
		return null;

	}

}
