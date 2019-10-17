package polynomial;

public class Term {
	char sign;
	String coefficient;
	String power;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String statement = "Sign = "+sign+" Coefficient = "+coefficient+" Power = "+power;
		return statement;
	}
}
