package edu.uwm.capstone.util;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import edu.uwm.capstone.model.profile.Profile;
import edu.uwm.capstone.model.address.Address;
import edu.uwm.capstone.model.user.User;

public class TestDataUtility {

    /**
     * This is a utility class and as such it only has a private constructor.
     */
    protected TestDataUtility() {
    }

    /**
     * Generate a {@link Profile} object that is fully loaded with random values for testing purposes.
     * @return {@link Profile}
     */
    public static Profile profileWithTestValues() {
        Profile profile = new Profile();
        // intentionally left blank -- profile.setId();
        profile.setName(randomAlphabetic(randomInt(1, 100)));
        profile.setProject(randomAlphanumeric(randomInt(1, 100)));
        // intentionally left blank -- profile.setCreatedDate(randomLocalDateTime());
        // intentionally left blank -- profile.setUpdatedDate(randomLocalDateTime());
        return profile;
    }

    /**
     * Generate a {@link Address} object that is fully loaded with random values for testing purposes.
     * @return {@link Address}
     */
    public static Address addressWithTestValues() {
        Address address = new Address();
        // intentionally left blank -- address.setId();
        address.setUserID(randomLong());
        address.setStreet1(randomAlphabetic(randomInt(1, 100)));
        address.setStreet2(randomAlphabetic(randomInt(1, 100)));
        address.setCity(randomAlphabetic(randomInt(1, 100)));
        address.setState(randomAlphabetic(randomInt(1, 100)));
        address.setZipcode(randomAlphabetic(randomInt(1, 100)));
        // intentionally left blank -- address.setCreatedDate(randomLocalDateTime());
        // intentionally left blank -- address.setUpdatedDate(randomLocalDateTime());
        return address;
    }

    /**
     * Generate a {@link User} object that is fully loaded with random values for testing purposes.
     * @return {@link User}
     */
    public static User userWithTestValues(){
        User user = new User();
        // intentionally left blank -- user.setId(randomLong());
        user.setEmail(randomAlphanumeric(randomInt(1, 100)));
        user.setPassword(randomAlphanumeric(randomInt(1, 100)));
        user.setTitle(randomAlphanumeric(randomInt(1, 100)));
        user.setFirstName(randomAlphabetic(randomInt(1, 100)));
        user.setLastName(randomAlphabetic(randomInt(1, 100)));
        user.setMiddleName(randomAlphabetic(randomInt(1, 100)));
        user.setLastName(randomAlphabetic(randomInt(1, 100)));
        user.setMobilePhone(randomNumeric(randomInt(1, 100)));
        user.setHomePhone(randomNumeric(randomInt(1, 100)));
        user.setWebsite(randomAlphabetic(randomInt(1, 100)));
        // intentionally left blank -- user.setCreatedDate(randomLocalDateTime());
        // intentionally left blank -- user.setUpdatedDate(randomLocalDateTime());
        return user;
    }

    /**
     * Generate a random {@link Double} using a minimum value of 1L and a maximum value of {@link Double#MAX_VALUE}.
     * @return random {@link Double}
     */
    public static Double randomDouble(){
        return randomDouble(Double.MIN_VALUE, Double.MAX_VALUE);
    }

    /**
     * Generate a random {@link Double} using the provided minimum and maximum values.
     * @param min {@link Double} minimum value
     * @param max {@link Double} maximum value
     * @return random {@link Double}
     */
    public static Double randomDouble(Double min, Double max){
        return new Random().doubles(min, max).findAny().getAsDouble();
    }

    /**
     * Generate a random {@link Long} using a minimum value of 1L and a maximum value of {@link Long#MAX_VALUE}.
     * @return random {@link Long}
     */
    public static Long randomLong() {
        return randomLong(1L, Long.MAX_VALUE);
    }

    /**
     * Generate a random {@link Long} using the provided minimum and maximum values.
     * @param min {@link Long} minimum value
     * @param max {@link Long} maximum value
     * @return random {@link Long}
     */
    public static Long randomLong(Long min, Long max) {
        return new Random().longs(min, max).findAny().getAsLong();
    }

    /**
     * Generate a random {@link Integer} using a minimum value of 1 and a maximum value of {@link Integer#MAX_VALUE}.
     * @return random {@link Integer}
     */
    public static int randomInt() {
        return randomInt(1, Integer.MAX_VALUE);
    }

    /**
     * Generate a random {@link int} using the provided minimum and maximum values.
     * @param min {@link int} minimum value
     * @param max {@link int} maximum value
     * @return random {@link int}
     */
    public static int randomInt(int min, int max) {
        return new Random().ints(min, max).findAny().getAsInt();
    }

    /**
     * Generate a {@link String} that contains the provided number of random alphabetic characters.
     * @param characterCount Number of characters
     * @return random {@link String} of alphabetic characters
     */
    public static String randomAlphabetic(int characterCount) {
        return RandomStringUtils.randomAlphabetic(characterCount);
    }

    /**
     * Generate a {@link String} that contains the provided number of random numeric characters.
     * @param characterCount Number of characters
     * @return random {@link String} of alphanumeric characters
     */
    public static String randomNumeric(int characterCount) {
        return RandomStringUtils.randomNumeric(characterCount);
    }

    /**
     * Generate a {@link String} that contains the provided number of random alphanumeric characters.
     * @param characterCount Number of characters
     * @return random {@link String} of alphanumeric characters
     */
    public static String randomAlphanumeric(int characterCount) {
        return RandomStringUtils.randomAlphanumeric(characterCount);
    }

    public static LocalDateTime randomLocalDateTime() {
        LocalDateTime start = LocalDateTime.of(1900, randomMonth(), 1, randomInt(0, 23), randomInt(1, 59));
        long days = ChronoUnit.DAYS.between(start, LocalDateTime.now());
        return start.plusDays(new Random().nextInt((int) days + 1));
    }

    public static Month randomMonth() {
        List<Month> months = Arrays.asList(Month.values());
        int index = new Random().nextInt(months.size());
        return months.get(index);
    }

}