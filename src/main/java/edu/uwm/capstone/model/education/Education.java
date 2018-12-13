package edu.uwm.capstone.model.education;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDateTime;

public class Education {

    protected Long id;
    protected Long userID;
    protected String street1;
    protected String street2;
    protected String city;
    protected String state;
    protected String zipCode;
    protected String schoolName;
    protected String degree;
    protected String fieldOfStudy;
    protected LocalDateTime startDate;
    protected LocalDateTime endDate;
    protected LocalDateTime createdDate;
    protected LocalDateTime updatedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserID() { return userID; }
    public void setUserID(Long userID) { this.userID = userID; }

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

    public String getSchoolName() { return schoolName; }
    public void setSchoolName(String schoolName) { this.schoolName = schoolName; }

    public String getDegree() { return degree; }
    public void setDegree(String degree) { this.degree = degree; }

    public String getFieldOfStudy() { return fieldOfStudy; }
    public void setFieldOfStudy(String fieldOfStudy) { this.fieldOfStudy = fieldOfStudy; }

    public LocalDateTime getStartDate() { return this.startDate; }
    public void setStartDate(LocalDateTime startDate) { this.startDate = startDate; }

    public LocalDateTime getEndDate() { return this.endDate; }
    public void setEndDate(LocalDateTime endDate) { this.endDate = endDate; }

    public LocalDateTime getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; }

    public LocalDateTime getUpdatedDate() { return updatedDate; }
    public void setUpdatedDate(LocalDateTime updatedDate) { this.updatedDate = updatedDate; }

    @Override
    public boolean equals(Object object) { return object instanceof Education && (this == object || EqualsBuilder.reflectionEquals(this, object)); }

    @Override
    public int hashCode() { return HashCodeBuilder.reflectionHashCode(this, true); }

    @Override
    public String toString() { return ToStringBuilder.reflectionToString(this); }

}
