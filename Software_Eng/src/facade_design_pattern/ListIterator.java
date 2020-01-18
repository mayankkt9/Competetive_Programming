package facade_design_pattern;

public abstract class ListIterator {

	abstract boolean hasNext();
	abstract void moveToHead();
	abstract Object next();
	abstract void remove();
	
}
