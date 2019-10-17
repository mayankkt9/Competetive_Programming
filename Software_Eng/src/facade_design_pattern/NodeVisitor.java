package facade_design_pattern;

public abstract class NodeVisitor {
	
	abstract void visitFacade(Facade facade);
	abstract void visitAssignement(Assignment assignment);
	abstract void visitCourse(ClassCourseList course);
	
}
