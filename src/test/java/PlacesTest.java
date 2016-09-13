import org.junit.*;
import static org.junit.Assert.*;

public class PlacesTest {
  @Test
  public void Places_instantiatesCorrectly_true() {
    Places newPlace = new Places("San Diego", "USA", "July 10, 2015", "Sea World");
    assertEquals(true, newPlace instanceof Places);
  }
  
}
