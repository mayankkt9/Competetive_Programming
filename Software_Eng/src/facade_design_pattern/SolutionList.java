package facade_design_pattern;

import java.util.ArrayList;
import java.util.List;

public class SolutionList extends facade_design_pattern.ArrayList {
	private List<Solution> solutionList = new ArrayList<>();

	public void addSolution(Solution solution) {
		solutionList.add(solution);
	}

	public void addSolutionList(List<Solution> solution) {
		solutionList.addAll(solutionList);
	}

	public SolutionIterator iterator(){
		return new SolutionIterator(solutionList);
	}
}
