import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void description_instantiatesCorrectly_true() {
    Definition myDefinition = new Definition("adjective", "cleverly simple; ingenious");
    assertEquals(true, myDefinition instanceof Definition);
  }

  @Test
  public void description_instantiatesWithDefinition_true() {
    Definition myDefinition = new Definition("adjective", "cleverly simple; ingenious");
    assertEquals("adjective\t-\tcleverly simple; ingenious", myDefinition.getDefinition());
  }

  @Test
  public void all_returnsAllInstancesOfDefinition_true() {
    Definition firstDefinition = new Definition("adjective", "cleverly simple; ingenious");
    Definition secondDefinition = new Definition("adjective", "dignified and graceful in appearance, behaviour, etc");
    assertTrue(Definition.all().contains(firstDefinition));
    assertTrue(Definition.all().contains(secondDefinition));
  }

  @Test
  public void newId_descriptionsInstantiateWithAnID_true() {
    Definition myDefinition = new Definition("adjective", "cleverly simple; ingenious");
    assertEquals(Definition.all().size(), myDefinition.getId());
  }

  @Test
  public void find_returnsDefinitionWithSameId_secondDefinition() {
    Definition firstDefinition = new Definition("adjective", "cleverly simple; ingenious");
    Definition secondDefinition = new Definition("adjective", "dignified and graceful in appearance, behaviour, etc");
    assertEquals(Definition.find(secondDefinition.getId()), secondDefinition);
  }

  @Test
  public void find_returnsNullWhenNoDefinitionFound_null() {
    assertTrue(Definition.find(888) == null);
  }

  @Test
  public void clear_emptiesAllDefinitionsFromArrayList() {
    Definition myDefinition = new Definition("adjective", "cleverly simple; ingenious");
    Definition.clear();
    assertEquals(Definition.all().size(), 0);
  }
}
