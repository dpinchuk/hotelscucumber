package configuration;

public interface Configuration {

    String URL = "https://www.hotels.com/?pos=HCOM_US&locale=en_US";
    String WEB_DRIVER = "chrome";
    String PROPERTY_CHROM_DRIVER = "webdriver.chrome.driver";
    String PATH_TO_WEB_DRIVER = "src/main/resources/chromedriver/2.41/chromedriver.exe";

    String DATE_FORMAT = "MM/dd/yy";

    String TEST_CITY = "New York, New York, United States Of America";
    String TEST_TEXT = "John F. Kennedy";
    int DAYS = 7;
    int CHECK_IN = 1;
    int ROOMS = 1;
    int ADULTS = 2;
    int CHILDREN = 2;
    int[] CHILD_AGE = {2, 3};

    int TIME_OUT_WAIT = 10;
}
