package edu.uwm.capstone.util;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import edu.uwm.capstone.model.address.Address;
import edu.uwm.capstone.model.education.Education;
import edu.uwm.capstone.model.project.Project;
import edu.uwm.capstone.model.contact.Contact;
import edu.uwm.capstone.model.position.Position;
import edu.uwm.capstone.model.profile.Profile;

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
     * Generate a {@link Position} object that is fully loaded with random values for testing purposes.
     * @return {@link Position}
     */
    public static Position positionWithTestValues(){
        Position position = new Position();
        // intentionally left blank -- position.setId();
        position.setName(randomAlphabetic(randomInt(1, 100)));
        position.setCompanyId(randomLong());
        position.setDescription(randomAlphanumeric(randomInt(1, 100)));
        // intentionally left blank -- position.setCreatedDate(randomLocalDateTime());
        // intentionally left blank -- position.setUpdatedDate(randomLocalDateTime());
        position.setStartDate(randomLocalDateTime());
        position.setEndDate(randomLocalDateTime());
        position.setStartPay(randomDouble());
        position.setEndPay(randomDouble());
        return position;
    }

    /**
     * Generate a {@link Education} object that is fully loaded with random values for testing purposes.
     * @return {@link Education}
     */
    public static Education educationWithTestValues() {
        Education education = new Education();
        // intentionally left blank -- education.setId();
        education.setUserID(randomLong());
        education.setAddressID(randomLong());
        education.setSchoolName(randomAlphabetic(randomInt(1, 100)));
        education.setDegree(randomAlphabetic(randomInt(1, 100)));
        education.setFieldOfStudy(randomAlphabetic(randomInt(1, 100)));
        education.setStartDate(randomLocalDateTime());
        education.setEndDate(randomLocalDateTime());
        // intentionally left blank -- education.setCreatedDate(randomLocalDateTime());
        // intentionally left blank -- education.setUpdatedDate(randomLocalDateTime());
        return education;
    }

    /**
     * Generate a {@link Project} object that is fully loaded with random values for testing purposes.
     * @return {@link Project}
     */
    public static Project projectWithTestValues() {
        Project project = new Project();
        // intentionally left blank -- project.setId();
        project.setUserID(randomLong());
        project.setPositionID(randomLong());
        project.setEducationID(randomLong());
        project.setTitle(randomAlphanumeric(randomInt(1, 100)));
        project.setDescription(randomAlphanumeric(randomInt(1, 100)));
        project.setStartDate(randomLocalDateTime());
        project.setEndDate(randomLocalDateTime());
        // intentionally left blank -- project.setCreatedDate(randomLocalDateTime());
        // intentionally left blank -- project.setUpdatedDate(randomLocalDateTime());
        return project;
    }

    /**
     * Generate a {@link Contact} object that is fully loaded with random values for testing purposes.
     * @return {@link Contact}
     */
    public static Contact contactWithTestValues() {
        Contact contact = new Contact();
        // intentionally left blank -- contact.setId();
        contact.setCompanyID(randomLong());
        contact.setPosition(randomAlphabetic(randomInt(1, 100)));
        contact.setFirstName(randomAlphabetic(randomInt(1, 100)));
        contact.setLastName(randomAlphabetic(randomInt(1, 100)));
        contact.setEmail(randomAlphabetic(randomInt(1, 100)));
        contact.setPhoneNumber(randomAlphabetic(randomInt(1, 100)));
        contact.setNotes(randomAlphabetic(randomInt(1, 100)));
        // intentionally left blank -- contact.setCreatedDate(randomLocalDateTime());
        // intentionally left blank -- contact.setUpdatedDate(randomLocalDateTime());
        return contact;
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
