package facade_design_pattern;

public class CourseMenu {
	public void showMenu() {

		showAddButtons();
		showViewButtons();
		showRadios();
		showComboxes();
		showLabel();
	}

	public void showAddButtons() {
		System.out
				.println("Show Add buttons, feature common to both level of menu");
	}

	public void showViewButtons() {
		System.out
				.println("Show View buttons, feature common to both level of menu");
	}

	public void showRadios() {
		System.out.println("Show Radios, feature common to both level of menu");
	}

	public void showComboxes() {
		System.out
				.println("Show Combo Boxes, feature common to both level of menu");
	}

	public void showLabel() {
		System.out
				.println("Show ComboBoxes, feature common to both level of menu");
	}

}
