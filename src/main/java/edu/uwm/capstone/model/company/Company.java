package edu.uwm.capstone.model.company;

import java.time.LocalDateTime;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Company {
    protected Long id;
    private String name;
    private String address;
    private String phone_number;
    private String website;
    protected LocalDateTime created_date;
    protected LocalDateTime updated_date;

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {return name; }

    public void setName(String name) { this.name = name;}

    public String getAddress() {return address; }

    public void setAddress(String address) { this.address = address;}

    public String getPhoneNumber() {return phone_number; }

    public void setPhoneNumber(String phone_number) { this.phone_number = phone_number;}

    public String getWebsite() {return website; }

    public void setWebsite(String website) { this.website = website;}

    public LocalDateTime getCreatedDate() {
        return created_date;
    }

    public void setCreatedDate(LocalDateTime created_date) { this.created_date = created_date; }

    public LocalDateTime getUpdatedDate() { return updated_date; }

    public void setUpdatedDate(LocalDateTime updated_date) { this.updated_date = updated_date; }

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