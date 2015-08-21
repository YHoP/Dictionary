import org.junit.*;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void getWord_returnsWord_true() {
    Word testWord = new Word("elegant");
    assertEquals("elegant", testWord.getWord());
  }

  @Test
  public void getId_returnsWordId() {
    Word testWord = new Word("elegant");
    assertTrue(Word.all().size() == testWord.getId());
  }

  @Test
  public void getDefinitions_initiallyReturnsEmptyArrayList() {
    Word testWord = new Word("elegant");
    assertTrue(testWord.getDefinitions() instanceof ArrayList);
  }

  @Test
  public void all_returnsAllInstancesOfDefinition_true() {
    Word firstWord = new Word("elegant");
    Word secondWord = new Word("java");
    assertTrue(Word.all().contains(firstWord));
    assertTrue(Word.all().contains(secondWord));
  }

  @Test
  public void clear_removesAllWordInstancesFromMemory() {
    Word testWord = new Word("elegant");
    Word.clear();
    assertEquals(Word.all().size(), 0);
  }

  @Test
  public void find_returnsWordWithSameId() {
    Word testWord = new Word("elegant");
    assertEquals(Word.find(testWord.getId()), testWord);
  }

  @Test
  public void addDefinition_addsDefinitionToList() {
    Word testWord = new Word("java");
    Definition testDefinition = new Definition("the main island of Indonesia");
    testWord.addDefinition(testDefinition);
    assertTrue(testWord.getDefinitions().contains(testDefinition));
  }
}
