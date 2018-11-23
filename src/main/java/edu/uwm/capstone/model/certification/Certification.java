package edu.uwm.capstone.model.certification;

import java.time.LocalDateTime;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Certification {
    protected Long id;
    protected Long user_id;
    protected LocalDateTime created_date;
    protected LocalDateTime updated_date;
    private String name;
    private String authority;
    private String license_number;
    private LocalDateTime acquired_date;
    private LocalDateTime expired_date;
    private String website;

    public Long getId(){ return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId(){ return user_id; }

    public void setUserId(Long user_id){ this.user_id = user_id; }

    public LocalDateTime getCreatedDate() {
        return created_date;
    }

    public void setCreatedDate(LocalDateTime created_date) { this.created_date = created_date; }

    public LocalDateTime getUpdatedDate() { return updated_date; }

    public void setUpdatedDate(LocalDateTime updated_date) { this.updated_date = updated_date; }

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
        return license_number;
    }

    public void setLicenseNumber(String license_number){
        this.license_number = license_number;
    }

    public LocalDateTime getAcquiredDate() {
        return acquired_date;
    }

    public void setAcquiredDate(LocalDateTime acquired_date) { this.acquired_date = acquired_date; }

    public LocalDateTime getExpiredDate() {
        return expired_date;
    }

    public void setExpiredDate(LocalDateTime expired_date) { this.expired_date = expired_date; }

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