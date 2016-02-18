import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class ContactTest {

  @Test
  public void contact_instantiatesCorrectly_true() {
    Contact testContact = new Contact("Jane", "Doe", "May");
    assertEquals(true, testContact instanceof Contact);
  }

  @Test
  public void contact_returnsContactFullName_JaneDoe() {
    Contact testContact = new Contact("Jane", "Doe", "May");
    assertEquals("Jane Doe", testContact.wholeName());
  }

}
