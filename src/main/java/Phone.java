import java.util.ArrayList;

public class Phone {
  private String mPhoneNumber;
  private int mId;

  private static ArrayList<Phone> instances = new ArrayList<Phone>();

  public Phone(String phoneNumber) {
    mPhoneNumber = phoneNumber;
    instances.add(this);
    mId = instances.size();
  }

  public String getPhoneNumber() {
    return mPhoneNumber;
  }

  public static ArrayList<Phone> all() {
    return instances;
  }

  public int getId() {
    return mId;
  }
}
