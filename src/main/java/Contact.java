public class Contact {
  private String mFirst;
  private String mLast;
  private String mBirthMonth;

  public Contact(String first, String last, String birthMonth) {
    mFirst = first;
    mLast = last;
    mBirthMonth = birthMonth;
  }

  public String getFirst() {
    return mFirst;
  }

  public String getLast() {
    return mLast;
  }

  public String getBirthMonth() {
    return mBirthMonth;
  }

  public String wholeName() {
    return mFirst + " "  + mLast;
  }
}
