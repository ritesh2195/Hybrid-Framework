package IGPPack.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    private Properties properties;
    private File file;
    private FileInputStream fis;
    private final String filePath="src//test//resources//Locators.properties";

    public ReadConfig(){

        file = new File(filePath);

        try {

        fis = new FileInputStream(file);

        properties = new Properties();

        properties.load(fis);

        } catch (IOException e) {

        e.printStackTrace();

        }
    }

    public String getURL(){

        return properties.getProperty("AppURL");
    }

    public String getBrowserType(){

        return properties.getProperty("browserType");
    }

    public String getExcelFilePath(){

        return properties.getProperty("excelFilePath");
    }

    public String getChromePath(){

        return properties.getProperty("chromeDriverPath");
    }

    public String getFirefoxPath(){

        return properties.getProperty("geckoDriverPath");
    }

}
