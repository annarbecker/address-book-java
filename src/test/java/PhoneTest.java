import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class PhoneTest {

  @Test
  public void phone_instantiantesCorrectly_true() {
    Phone testPhone = new Phone("1");
    assertEquals(true, testPhone instanceof Phone);
  }

  @Test
  public void phone_returnsHomePhone_1() {
    Phone testPhone = new Phone("1");
    assertEquals("1", testPhone.getPhoneNumber());
  }


  @Test
  public void all_returnsAllInstancesOfPhone_true() {
    Phone home = new Phone("1");
    Phone cell = new Phone("2");
    assertTrue(Phone.all().contains(home));
    assertTrue(Phone.all().contains(cell));
  }

  @Test
  public void newId_taskInstantiatesWithAnId_true() {
    Phone testPhone = new Phone("1");
    assertEquals(Phone.all().size(), testPhone.getId());
  }
}
