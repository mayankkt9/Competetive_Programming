package stck;

public class XMLInfoLogger extends XMLFormatValidator {

	boolean startTag = false;
	boolean endTag = false;
	boolean tagCompleted = false;
	boolean tagClosed = false;
	String finalOutput = "";
	int xmlEnd = 0;

	@Override
	public XMLInfoLogger input(char c) throws InvalidXMLException {
		return (XMLInfoLogger) super.input(c);
	}

	@Override
	public String output() {
		String xmlOutput = super.data;
		char[] xmlInChar = xmlOutput.toCharArray();
		while (xmlEnd <= xmlInChar.length - 1) {
			finalOutput = finalOutput.concat(traverseStr(xmlInChar));
		}
		return finalOutput;
	}

	private String charArrToStr(char[] chars) {
		StringBuilder sb = new StringBuilder();
		for (char ch : chars) {
			if ((int) ch != 0) {
				if ((int) ch == 10) {
					sb.append("\\n");
				}
				if ((int) ch == 9) {
					sb.append("\\t");
				}
				if ((int) ch == 13) {
					sb.append("\\r");
				}
				sb.append(ch);
			}
		}
		String string = sb.toString();
		return string;
	}

	private String traverseStr(char[] xmlInChar) {
		// <html>_<head> This is a heading</head><p>Paragraph</p></html>
		String started = "";
		String ended = "";
		String characterStr = "";
		int i = 0;
		int j = 0;
		int k = 0;
		char[] start = new char[xmlInChar.length];
		char[] end = new char[xmlInChar.length];
		char[] characters = new char[xmlInChar.length];

		for (; xmlEnd < xmlInChar.length; xmlEnd++) {
			char c = xmlInChar[xmlEnd];
			if (c == '<' && xmlInChar[xmlEnd + 1] != '/') {
				startTag = true;
				endTag = false;
				i = i++;
				characterStr = "Characters:" + charArrToStr(characters);
				if (charArrToStr(characters).length() > 0) {
					xmlEnd = xmlEnd + 1;
					return characterStr;
				}
				j = 0;
				continue;
			} else if (c == '<' && xmlInChar[xmlEnd + 1] == '/') {
				tagCompleted = true;
				tagClosed = false;
				k = k + 1;
				continue;
			} else if (c == '/') {
				k = k++;
			} else if (c == '>' && !tagCompleted) {
				endTag = true;
				startTag = false;
				i = i++;
				started = "Started:" + charArrToStr(start);
				i = 0;
				xmlEnd = xmlEnd + 1;
				return started + "\n";
			} else if (c == '>') {
				endTag = true;
				startTag = false;
				tagCompleted = true;
				tagClosed = true;
				k = k++;
				if (charArrToStr(characters).length() > 0) {
					characterStr = "Characters:" + charArrToStr(characters);
					xmlEnd = xmlEnd + 1;
					k = 0;
					ended = "Ended:" + charArrToStr(end);
					return characterStr + ended + "\n";
				} else {
					k = 0;
					ended = "Ended:" + charArrToStr(end);
					xmlEnd = xmlEnd + 1;
					return ended + "\n";
				}
			} else if (startTag && !endTag) {
				start[i++] = c;
				continue;
			} else if (!startTag && endTag && !tagCompleted) {
				characters[j++] = c;
				if (xmlEnd == xmlInChar.length - 1) {
					characterStr = "Characters:" + charArrToStr(characters);
					xmlEnd = xmlEnd + 1;
					return characterStr + "\n";
				}
				continue;
			} else if (!endTag && tagCompleted && c != '<' && c != '>'
					&& c != '/') {
				end[k++] = c;
				continue;
			} else if (tagCompleted && !tagClosed) {
				end[k++] = c;
			} else if (c == '/') {
				k = k++;
			} else {
				characters[j++] = c;
			}
		}
		return null;
	}

}