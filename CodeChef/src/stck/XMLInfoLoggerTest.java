package stck;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class XMLInfoLoggerTest {
  XMLInfoLogger xmlInfoLogger;


  @Test
  public void shouldShowStartTagOnly() throws InvalidXMLException {
    xmlInfoLogger = new XMLInfoLogger();
    xmlInfoLogger.input('<').input('b').input('>').input('s').input('u').input('n');
    String expected =  xmlInfoLogger.output();
    assertEquals("Started:b\n" +
            "Characters:sun\n",expected);
  }

  @Test
  public void shouldShowAll() throws InvalidXMLException {
    xmlInfoLogger = new XMLInfoLogger();
    xmlInfoLogger.input('<').input('b').input('>').input('s').input('u');
    xmlInfoLogger.input(' ');
    xmlInfoLogger.input('n').input('\n');
    xmlInfoLogger.input('<').input('/').input('b').input('>');
    String expected =  xmlInfoLogger.output();
    assertEquals("Started:b\n" +
            "Characters:su n\\n\n" +
            "Ended:b\n", expected);
  }

  @Test
  public void shouldThrowInvalidXMLException() throws InvalidXMLException {
    xmlInfoLogger = new XMLInfoLogger();
    xmlInfoLogger.input('<').input('b').input('<').input('s').input('u').input('>');
  }

  @Test
  public void shouldDisplayNestedXMLOutput() throws InvalidXMLException{
    xmlInfoLogger = new XMLInfoLogger();
    xmlInfoLogger.input('<').input('b').input('>').input('s').input('_').input(' ').input('n').input('\n');
    xmlInfoLogger.input('<').input('p').input('>').input('A');
    xmlInfoLogger.input('<').input('/').input('p').input('>');
    xmlInfoLogger.input('B').input('C').input('D').input(' ');
    xmlInfoLogger.input('<').input('/').input('b').input('>');
    String output = xmlInfoLogger.output();
    assertEquals("Started:b\n" +
            "Characters:s_ n\\n\n" +
            "Started:p\n" +
            "Characters:A" +
            "Ended:p\n" +
            "Characters:BCD \n" +
            "Ended:b\n", output);
  }

}