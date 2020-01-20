/* Author: Dr. Niema C. Orakwusi
Created: January 18, 2020
This is a Maven, Testng, Rest Assured Api Testing Framework
Description : This project will test an api GET, POST, PUT
as well as from the UI Create a new User and Filter for that user
 */
package Service.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseApi {
    @SuppressWarnings("TryWithIdenticalCatches")
    protected static Properties proAPI;

    /* This base class provide data to the api test
     */
    public BaseApi() {
        try {

            InputStream fl = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/Service/config/config.properties");
            proAPI = new Properties();
            proAPI.load(fl);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
