package edu.uwm.capstone.model.certification;

import java.time.LocalDateTime;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Certification {
    protected Long id;
    protected Long userID;
    protected LocalDateTime createDate;
    protected LocalDateTime updatedDate;
    private String name;
    private String authority;
    private String licenseNumber;
    private LocalDateTime acquiredDate;
    private LocalDateTime expiredDate;
    private String website;

    public Long getId(){ return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId(){ return userID; }

    public void setUserId(Long user_id){ this.userID = user_id; }

    public LocalDateTime getCreatedDate() {
        return createDate;
    }

    public void setCreatedDate(LocalDateTime created_date) { this.createDate = created_date; }

    public LocalDateTime getUpdatedDate() { return updatedDate; }

    public void setUpdatedDate(LocalDateTime updated_date) { this.updatedDate = updated_date; }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAuthority(){
        return authority;
    }

    public void setAuthority(String authority){
        this.authority = authority;
    }

    public String getLicenseNumber(){
        return licenseNumber;
    }

    public void setLicenseNumber(String license_number){
        this.licenseNumber = license_number;
    }

    public LocalDateTime getAcquiredDate() {
        return acquiredDate;
    }

    public void setAcquiredDate(LocalDateTime acquired_date) { this.acquiredDate = acquired_date; }

    public LocalDateTime getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDateTime expired_date) { this.expiredDate = expired_date; }

    public String getWebsite(){
        return website;
    }

    public void setWebsite(String website){
        this.website = website;
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Certification && (this == object || EqualsBuilder.reflectionEquals(this, object));
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