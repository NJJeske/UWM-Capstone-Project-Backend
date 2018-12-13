package edu.uwm.capstone.model.company;

import java.time.LocalDateTime;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Company {
    protected Long id;
    protected Long userID;
    protected String name;
    protected String street1;
    protected String street2;
    protected String city;
    protected String state;
    protected String zipCode;
    protected String phoneNumber;
    protected String website;
    protected LocalDateTime createdDate;
    protected LocalDateTime updatedDate;

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserID() { return this.userID; }

    public void setUserID(Long userID) { this.userID = userID; }

    public String getName() {return name; }

    public void setName(String name) { this.name = name;}

    public String getStreet1() { return this.street1; }

    public void setStreet1(String street1) { this.street1 = street1; }

    public String getStreet2() { return this.street2; }

    public void setStreet2(String street2) { this.street2 = street2; }

    public String getCity() { return this.city; }

    public void setCity(String city) { this.city = city; }

    public String getState() { return this.state; }

    public void setState(String state) { this.state = state; }

    public String getZipCode() { return this.zipCode; }

    public void setZipCode(String zipCode) { this.zipCode = zipCode; }

    public String getPhoneNumber() {return phoneNumber; }

    public void setPhoneNumber(String phone_number) { this.phoneNumber = phone_number;}

    public String getWebsite() {return website; }

    public void setWebsite(String website) { this.website = website;}

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime created_date) { this.createdDate = created_date; }

    public LocalDateTime getUpdatedDate() { return updatedDate; }

    public void setUpdatedDate(LocalDateTime updated_date) { this.updatedDate = updated_date; }

    @Override
    public boolean equals(Object object) {
        return object instanceof Company && (this == object || EqualsBuilder.reflectionEquals(this, object));
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, true);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}