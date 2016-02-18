import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class PhoneTest {

  public void phone_instantiantesCorrectly_true() {
    Phone testPhone = new Phone("1", "2", "3");
    assertEquals(true, testPhone instanceof Phone);
  }
}
