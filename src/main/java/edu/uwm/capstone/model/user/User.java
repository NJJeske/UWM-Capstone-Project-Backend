package edu.uwm.capstone.model.user;

import java.time.LocalDateTime;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class User {
    protected Long id;
    private String email;
    private String password;
    private String title;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String mobile_phone;
    private String home_phone;
    private String website;
    protected LocalDateTime created_date;
    protected LocalDateTime updated_date;

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getFirstName(){
        return first_name;
    }

    public void setFirstName(String first_name){
        this.first_name = first_name;
    }

    public String getMiddleName(){
        return middle_name;
    }

    public void setMiddleName(String middle_name){
        this.middle_name = middle_name;
    }

    public String getLastName(){
        return last_name;
    }

    public void setLastName(String last_name){
        this.last_name = last_name;
    }

    public String getMobilePhone(){
        return mobile_phone;
    }

    public void setMobilePhone(String mobile_phone){
        this.mobile_phone = mobile_phone;
    }

    public String getHomePhone(){
        return home_phone;
    }

    public void setHomePhone(String home_phone){
        this.home_phone = home_phone;
    }

    public String getWebsite(){
        return website;
    }

    public void setWebsite(String website){
        this.website = website;
    }

    public LocalDateTime getCreatedDate() {
        return created_date;
    }

    public void setCreatedDate(LocalDateTime created_date) { this.created_date = created_date; }

    public LocalDateTime getUpdatedDate() { return updated_date; }

    public void setUpdatedDate(LocalDateTime updated_date) { this.updated_date = updated_date; }

    @Override
    public boolean equals(Object object) {
        return object instanceof User && (this == object || EqualsBuilder.reflectionEquals(this, object));
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