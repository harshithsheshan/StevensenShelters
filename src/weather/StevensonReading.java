package weather;

/**
 * This class represents a Stevenson Reading data.
 */
public final class StevensonReading implements WeatherReading {
  private final double temperature;
  private final double dewPoint;
  private final double windSpeed;
  private final double totalRain;
  private double relativeHumidity;
  private double heatIndex;
  private double windChill;

  /**
   * Copy Constructor to initialize the values of the Reading.
   *
   * @param temperature The temperature reading from the tower
   * @param dewPoint    The Dew Point reading from the tower
   * @param windSpeed   The Wind Speed reading from the tower
   * @param totalRain   The Total Rain reading from the tower
   */
  public StevensonReading(double temperature, double dewPoint, double windSpeed, double totalRain) {
    this.temperature = temperature;
    this.dewPoint = dewPoint;
    if (this.dewPoint > this.temperature) {
      throw new IllegalArgumentException("Dew Point is not valid");
    }

    this.windSpeed = windSpeed;
    if (this.windSpeed < 0) {
      throw new IllegalArgumentException("Dew Point is not valid");
    }

    this.totalRain = totalRain;
    if (this.totalRain < 0) {
      throw new IllegalArgumentException("Dew Point is not valid");
    }
    calculate();
  }

  /**
   * To Calculate the other parameters of Reading.
   */
  public void calculate() {
    relativeHumidity = 5 * dewPoint - 5 * temperature + 100;
    double c1 = -8.78469475556;
    double c2 = 1.61139411;
    double c3 = 2.33854883889;
    double c4 = -0.14611605;
    double c5 = -0.012308094;
    double c6 = -0.0164248277778;
    double c7 = 0.002211732;
    double c8 = 0.00072546;
    double c9 = -0.000003582;
    heatIndex =
        c1 + c2 * temperature + c3 * relativeHumidity + c4 * temperature
            * relativeHumidity
            + c5 * Math.pow(temperature, 2) + c6 * Math.pow(relativeHumidity, 2)
            + c7 * Math.pow(temperature, 2) * relativeHumidity
            + c8 * temperature * Math.pow(relativeHumidity, 2)
            + c9 * Math.pow(temperature, 2) * Math.pow(relativeHumidity, 2);
    double tempF = 9 * temperature / 5.0  + 32 ;
    windChill = 35.74 + 0.6215 * tempF - 35.75 * Math.pow(windSpeed, 0.16)
        + 0.4275 * tempF * Math.pow(windSpeed, 0.16);

  }

  /**
   * Get the temperature of this reading rounded to the nearest integer.
   *
   * @return the temperature
   */
  public int getTemperature() {
    return (int) Math.round(this.temperature);
  }

  /**
   * Get the dew point for this reading rounded to the nearest integer.
   *
   * @return the dew point
   */
  public int getDewPoint() {
    return ((int) Math.round(this.dewPoint));
  }

  /**
   * Get the wind speed for this reading rounded to the nearest integer.
   *
   * @return the wind speed
   */
  public int getWindSpeed() {
    return ((int) Math.round(this.windSpeed));
  }

  /**
   * Get the total rain of this reading (in mm).
   *
   * @return the total rain
   */
  public int getTotalRain() {
    return ((int) Math.round(this.totalRain));
  }

  /**
   * Get the relative humidity of this weather reading rounded to the nearest
   * integer.
   *
   * @return the relative humidity
   */
  public int getRelativeHumidity() {
    return ((int) Math.round(this.relativeHumidity));
  }

  /**
   * Get the heat index for this weather reading rounded to the nearest integer.
   *
   * @return the heat index
   */
  public int getHeatIndex() {
    return ((int) Math.round(this.heatIndex));
  }

  /**
   * Get the wind chill rounded to the nearest integer.
   *
   * @return the wind chill
   */
  public int getWindChill() {
    return ((int) Math.round(this.windChill));
  }

  /**
   * To Return the values as a string.
   *
   * @return Formatted string of readings
   */
  public String toString() {
    return String.format("Reading: T = %d, D = %d, v = %d, rain = %d",
        getTemperature(), getDewPoint(), getWindSpeed(), getTotalRain());
  }

  /**
   * To Return the hashcode.
   *
   * @return hashcode
   */
  @Override
  public int hashCode() {

    return Long.hashCode( (long)getTemperature() * getTotalRain() * getDewPoint() * getWindSpeed());
  }

  /*
   * To check equals() between classes.
   *
   * @param o the second object
   * @return True or False
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof StevensonReading)) {
      return false;
    }
    StevensonReading that = (StevensonReading) o;
    return CharSequence.compare(this.toString(), that.toString()) == 0;
  }
}
