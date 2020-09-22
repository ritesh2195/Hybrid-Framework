package IGPPack.Utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGenerator {

    public static String generateEmail(){

        return RandomStringUtils.randomAlphabetic(7)+"@gmail.com";

    }

    public static String generateFirstName(){

        return RandomStringUtils.randomAlphabetic(5);
    }

    public static String generateLastName(){

        return RandomStringUtils.randomAlphabetic(5);
    }

    public static String generateMobile(){

        return RandomStringUtils.randomNumeric(10);
    }

    public static String generatePassword(){

        return RandomStringUtils.randomAlphabetic(6);
    }
}
