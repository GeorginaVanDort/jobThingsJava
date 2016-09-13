//REMEMBER TO RENAME
public class Job {
  String mTitle;
  String mDescription;
  String mCompany;
  String mDates;
  boolean mOpening;

  public Job(String title, String description, String company, String dates, boolean opening){
    mTitle = title;
    mDescription = description;
    mCompany = company;
    mDates = dates;
    mOpening = opening;

  }
    public String getTitle() {
      return mTitle;
    }

    public String getDescription() {
      return mDescription;
    }

    public String getCompany() {
      return mCompany;
    }

    public String getDates() {
      return mDates;
    }

    public boolean getOpening() {
      return mOpening;
    }
}
