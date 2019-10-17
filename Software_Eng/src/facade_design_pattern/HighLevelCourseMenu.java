package facade_design_pattern;

public class HighLevelCourseMenu extends CourseMenu {
	@Override
	public void showMenu() {

		showAddButtons();
		showViewButtons();
		showRadios();
		showComboxes();
		showLabel();
	}

	@Override
	public void showAddButtons() {
		System.out.println("High Level Course Menu show Add buttons");
	}

	@Override
	public void showViewButtons() {
		System.out.println("High Level Course Menu show View Buttons");
	}

	@Override
	public void showRadios() {

		System.out.println("High Level Course Menu show Radios");
	}

	@Override
	public void showComboxes() {

		System.out.println("High Level Course Menu show Combo boxes");
	}

	@Override
	public void showLabel() {

		System.out.println("Highs Level Course Menu show Label");
	}

	public void instructorAssignmentMenu() {
		// System.out.println("Instructor Assignment Menu");
	}

	public void studentAssignmentMenu() {
		System.out.println("Student Assignment Menu");
	}

}
