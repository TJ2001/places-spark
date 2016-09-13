import java.text.SimpleDateFormat;
import java.util.Date;

public class Places{
  private String mCity;
  private String mCountry;
  private String mDate;
  private String mLandmark;

  public Places(String city, String country, String date, String landmark){
    mCity = city;
    mCountry = country;
    mDate = date;
    mLandmark = landmark;
  }

  public String getCity(){
    return mCity;
  }

  public String getCountry(){
    return mCountry;
  }

  public String getDate(){
    return mDate;
  }

  public String getLandmark(){
    return mLandmark;
  }
}
