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

  @Test
  public void find_returnsPhonekWithSameId_work() {
    Phone home = new Phone("1");
    Phone cell = new Phone("2");
    Phone work = new Phone("3");
    assertEquals(Phone.find(work.getId()), work);
  }

  @Test
  public void find_returnsNullWhenNoPhoneFound_null() {
    assertTrue(Phone.find(999) == null);
  }

  @Test
  public void clear_emptiesAllPhoneFromArrayList() {
    Phone newPhone = new Phone("1");
    Phone.clear();
    assertEquals(Phone.all().size(), 0);
}
}
