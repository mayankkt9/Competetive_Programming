package facade_design_pattern;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InstructorList {
	private List<Instructor> instructorList = new ArrayList<>();

	public List<Instructor> createInstructorList() throws FileNotFoundException {
		System.out.println("Creating Instructor List from Input File");

		String file_path = "/Users/mayankkataruka/Desktop/Work/Comp_Prog_Workspace/Software_Eng/src/input_files/InsInfor.txt";
		File file = new File(file_path);

		Scanner sc = new Scanner(file);
		while (sc.hasNextLine()) {
			String[] str = sc.nextLine().split(":");
			instructorList.add(new Instructor(str[0], str[1]));
		}
		System.out.println("Instructor Created :\n" + this);
		return instructorList;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "";
		for (int i = 0; i < instructorList.size(); i++) {
			str += instructorList.get(i).id + "\t"
					+ instructorList.get(i).password + "\n";
		}
		return str;
	}
}
