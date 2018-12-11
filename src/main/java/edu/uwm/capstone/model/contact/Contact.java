package edu.uwm.capstone.model.contact;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDateTime;

public class Contact {
    protected Long id;
    protected Long userID;
    protected Long companyID;
    protected String position;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String phoneNumber;
    protected String notes;
    protected LocalDateTime createdDate;
    protected LocalDateTime updatedDate;

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserID() { return this.userID; }
    public void setUserID(Long userID) { this.userID = userID; }

    public Long getCompanyID() { return this.companyID; }
    public void setCompanyID(Long companyID) { this.companyID = companyID;}

    public String getPosition() { return this.position; }
    public void setPosition(String position) { this.position = position; }

    public String getFirstName() { return this.firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return this.lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return this.email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return this.phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getNotes() { return this.notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public LocalDateTime getCreatedDate() { return this.createdDate; }
    public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; }

    public LocalDateTime getUpdatedDate() { return this.updatedDate; }
    public void setUpdatedDate(LocalDateTime updatedDate) { this.updatedDate = updatedDate; }

    @Override
    public boolean equals(Object object) { return object instanceof Contact && (this == object || EqualsBuilder.reflectionEquals(this, object)); }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, true);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
