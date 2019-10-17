package facade_design_pattern;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentList {
	private List<Student> studentList = new ArrayList<>();

	public List<Student> createStudentList() throws FileNotFoundException {
		System.out.println("Creating Student List from Input File");

		String file_path = "/Users/mayankkataruka/Desktop/Work/Comp_Prog_Workspace/Software_Eng/src/input_files/StuInfo.txt";
		File file = new File(file_path);

		Scanner sc = new Scanner(file);
		while (sc.hasNextLine()) {
			String[] str = sc.nextLine().split(":");
			studentList.add(new Student(str[0], str[1]));
		}
		System.out.println("Students Created :\n" + this);

		return studentList;

	}
	
	
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "";
		for (int i = 0; i < studentList.size(); i++) {
			str += studentList.get(i).id + "\t" + studentList.get(i).password
					+ "\n";
		}
		return str;
	}
}
