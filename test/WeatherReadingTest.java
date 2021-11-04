import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import weather.StevensonReading;
import weather.WeatherReading;

/**
 * Testing the Methods of Weather Reading.
 */
public class WeatherReadingTest {

  WeatherReading s = new StevensonReading(20, 2, 20, 2);
  WeatherReading s2 = s;

  /**
   * Testing getTemperature() by comparing against highest and lowest temperatures recorded so far.
   */
  @org.junit.Test
  public void testGetTemperature() {
    int t = s.getTemperature();
    //System.out.println(T);
    assertTrue("Failed Temperature", t < 58 && t > -88);
  }

  /**
   * Testing getDewPoint() by comparing with highest and lowest due points recorded so far.
   */
  @org.junit.Test
  public void testGetDewPoint() {
    int d = s.getDewPoint();
    //System.out.println(d);
    assertTrue("Failed Due Point", d < 95 && d > -90);
  }

  /**
   * Testing getWindSpeed().
   */
  @org.junit.Test
  public void testGetWindSpeed() {
    int w = s.getWindSpeed();
    //out.println(W);
    assertTrue("Failed Wind Speed", w < 231 && w > 0);
  }

  /**
   * Testing getTotalRain().
   */
  @org.junit.Test
  public void testGetTotalRain() {
    int r = s.getTotalRain();
    //out.println(W);
    assertTrue("Failed Total Rain", r < 250 && r > 5);
  }

  /**
   * Testing getRelativeHumidity().
   */
  @org.junit.Test
  public void testGetRelativeHumidity() {
    int h = s.getRelativeHumidity();
    System.out.println(h);
    assertTrue("Failed Relative Humidity", h < 60 && h > 20);
  }

  /**
   * Testing getHeatIndex().
   */
  @org.junit.Test
  public void testGetHeatIndex() {
    int hI = s.getHeatIndex();
    System.out.println(hI);
    assertTrue("Failed Heat Index", hI < 50 && hI > 20);
  }

  /**
   * Testing getWindchill().
   */
  @org.junit.Test
  public void testGetWindChill() {
    int wC = s.getWindChill();
    System.out.println(wC);
    assertTrue("Failed Wind Chill", wC < 150 && wC > 20);
  }

  /**
   * Testing get toString().
   */
  @org.junit.Test
  public void testToString() {
    assertEquals("String not equal", s.toString(), s2.toString());
  }

  /**
   * Testing hashCode().
   */
  @org.junit.Test
  public void testHashcode() {
    assertEquals("String hashcode is equal", hashCode(s2), hashCode(s));
  }

  /**
   * Function to call Stevenson Reading hashcode().
   *
   * @param s2 instance
   * @return long hashcode
   */
  private long hashCode(WeatherReading s2) {
    return s2.hashCode();
  }

}