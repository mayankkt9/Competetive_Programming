package stck;



import java.util.Stack;

public abstract class XMLFormatValidator implements XMLParser{

  Stack<String> parser = new Stack<>();
  boolean status = false;
  String data = "";
  String root = "";
  int pointer = 1;


  public abstract String output();

  @Override
  public XMLParser input(char c) throws InvalidXMLException {
    data = data.concat(charToStr(c));
    xmlParser(c);
    return this;
  }

  private String charToStr(char c) {
    return Character.toString(c);
  }

  private void xmlParser(char c) throws InvalidXMLException {
    switch (c) {
      case '<': {
        if (parser.empty()) {
          parser.push(charToStr(c));
          status = false;
        } else if (parser.peek().charAt(0) == '<' && parser.peek().length() > 1) {
          char l = parser.peek().charAt(parser.peek().length() - 1);
          if (l == '>') {
            parser.push(charToStr(c));
            status = false;
          }
        } else {
          throw new InvalidXMLException("Invalid XML");
        }
        break;
      }
      case '/': {
        if (parser.peek().length() == 1 && parser.peek().charAt(0) == '<') {
          String peekStr = parser.pop();
          peekStr = peekStr.concat(charToStr(c));
          parser.push(peekStr);
        } else throw new InvalidXMLException("Invalid XML");
        break;
      }
      case '>': {
        if (parser.peek().charAt(0) == '<') {
          String peekStr = parser.pop();
          peekStr = peekStr.concat(charToStr(c));
          parser.push(peekStr);
        } else if (parser.peek().charAt(0) != '<') throw new InvalidXMLException("Invalid XML");
        parser = checkTags();
        break;
      }
      default: {
        // any character
        if(c=='-' || ((int) c <= 57 && (int) c >= 48)
                || (int)c == 48 || (int)c == 9 || (int)c == 32){
          String peekStr = parser.pop();
          if(peekStr.length() == 1) {
            throw new InvalidXMLException("Invalid XML");
          }
          else{
            parser.push(peekStr);
          }
        }
        else if (parser.peek().contains("</")) {
          String peekStr = parser.pop();
          peekStr = peekStr.concat(charToStr(c));
          if (parser.peek().charAt(0) == '<') {
            String peekPopStr = parser.pop();
            if (peekPopStr.charAt(pointer++) == c) {
              parser.push(peekPopStr);
              parser.push(peekStr);
              status = false;
            } else {
              throw new InvalidXMLException("Invalid XML");
            }
          }
        }
        else if(parser.peek().contains("<") && !parser.peek().contains(">")){
          String peekStr = parser.pop();
          peekStr = peekStr.concat(charToStr(c));
          parser.push(peekStr);
          if(!parser.peek().contains("</"))
          {
            pointer++;
          }
        }
        break;
      }
    }
  }

  private Stack<String> checkTags() throws InvalidXMLException {
    pointer = 1;
    if (parser.size() > 2) {
      while (!parser.empty()) {
        String tag1 = parser.pop().replace("/", "");
        String tag2 = parser.pop().replace("/", "");
        if (tag1.equals(tag2)) {
          status = true;
          return parser;
        } else {
          parser.push(tag2);
          parser.push(tag1);
          status = false;
          return parser;
        }
      }
    }
    else if (parser.size() == 2 && !parser.peek().contains("/")) {
      String tag1 = parser.pop();
      if (tag1.equals(root)) {
        throw new InvalidXMLException("Invalid XML");
      }
      else{
        parser.push(tag1);
      }
    }
    else if (parser.size() == 2 && parser.peek().contains("/")) {
      String tag1 = parser.pop().replace("/", "");
      if (tag1.equals(root)) {
        parser.pop();
        status = true;
        return parser;
      }
    }else if(parser.size() == 1) {
      root = parser.peek();
    }
    return parser;
  }
}