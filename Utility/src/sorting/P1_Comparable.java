package sorting;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P1_Comparable {
	public static void main(String[] args) {

		Student s1 = new Student("", "", 2);
		Student s2 = new Student("", "", 1);
		Student s3 = new Student("", "", 3);
		Student s4 = new Student("", "", 4);
		Student s5 = new Student("", "", 0);
		Student s6 = new Student("", "", 8);

		List<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		list.add(s3);

		Collections.sort(list, (a, b) -> -(a.roll - b.roll));
		System.out.println(list);

		PriorityQueue<Student> pq = new PriorityQueue<Student>((x, y) -> x.roll - y.roll);
		pq.add(s1);
		pq.add(s2);
		pq.add(s3);
		pq.add(s4);
		pq.add(s5);
		pq.add(s6);

		while (!pq.isEmpty()) {
			System.out.println(pq.poll().roll);
		}
		
		
		System.out.println(new ArrayList<Integer>().add(3));
	}
}

class Student implements Comparable<Student> {

	String firstName;
	String lastName;
	int roll;

	public Student(String firstName, String lastName, int roll) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.roll = roll;
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		if (this.roll < o.roll)
			return -1;
		else if (this.roll > o.roll)
			return 1;

		return 0;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", roll=" + roll + "]";
	}

}