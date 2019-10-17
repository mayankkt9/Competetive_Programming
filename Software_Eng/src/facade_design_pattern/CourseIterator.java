package facade_design_pattern;

import java.util.List;

public class CourseIterator extends ListIterator {

	List<Course> courseList = new java.util.ArrayList<>();

	int position = 0;

	public CourseIterator(List<Course> courseList) {
		super();
		this.courseList = courseList;
	}

	@Override
	boolean hasNext() {
		// TODO Auto-generated method stub
		if (position == courseList.size())
			return false;
		else
			return true;
	}

	@Override
	void moveToHead() {
		// TODO Auto-generated method stub
		Course get = courseList.get(position);
		courseList.remove(position);
		courseList.add(0, get);

	}

	@Override
	Object next() {
		// TODO Auto-generated method stub

		Course get = courseList.get(position);
		position += 1;
		return get;

	}

	@Override
	void remove() {
		// TODO Auto-generated method stub
		courseList.remove(position);

	}
}
