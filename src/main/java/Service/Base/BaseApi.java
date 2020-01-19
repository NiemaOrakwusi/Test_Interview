package Service.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseApi {
    @SuppressWarnings("TryWithIdenticalCatches")
    protected static Properties proAPI;

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
