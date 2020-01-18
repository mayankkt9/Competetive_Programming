package facade_design_pattern;

import java.util.ArrayList;
import java.util.List;

public class SolutionIterator extends ListIterator {

	List<Solution> solutionList = new ArrayList<>();

	int position = 0;

	public SolutionIterator(List<Solution> solutionList) {
		super();
		this.solutionList = solutionList;
	}

	@Override
	boolean hasNext() {
		// TODO Auto-generated method stub
		if (position == solutionList.size())
			return false;
		else
			return true;
	}

	@Override
	void moveToHead() {
		// TODO Auto-generated method stub
		Solution get = solutionList.get(position);
		solutionList.remove(position);
		solutionList.add(0, get);

	}

	@Override
	Object next() {
		// TODO Auto-generated method stub

		Solution get = solutionList.get(position);
		position += 1;
		return get;

	}

	@Override
	void remove() {
		// TODO Auto-generated method stub
		solutionList.remove(position);

	}

}
