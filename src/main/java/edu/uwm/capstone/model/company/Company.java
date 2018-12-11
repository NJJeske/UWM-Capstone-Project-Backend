package edu.uwm.capstone.model.company;

import java.time.LocalDateTime;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Company {
    protected Long id;
    protected Long userID;
    private String name;
    private String address;
    private String phoneNumber;
    private String website;
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

    public String getAddress() {return address; }

    public void setAddress(String address) { this.address = address;}

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