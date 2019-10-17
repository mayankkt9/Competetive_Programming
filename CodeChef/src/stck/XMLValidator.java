package stck;

public class XMLValidator extends XMLFormatValidator {

	  public XMLValidator() {
	    super();
	  }

	  @Override
	  public XMLValidator input(char c) throws InvalidXMLException {
	    return (XMLValidator) super.input(c);
	  }

	  @Override
	  public String output() {
	    if (!status && parser.empty()) {
	      return "Status:Empty";
	    } else if (status && parser.empty()) {
	      return "Status:Valid";
	    } else return "Status:Incomplete";
	  }
	}