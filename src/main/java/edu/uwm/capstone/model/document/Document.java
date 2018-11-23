package edu.uwm.capstone.model.document;

import java.time.LocalDateTime;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Document {
    protected Long id;
    protected Long user_id;
    protected LocalDateTime created_date;
    protected LocalDateTime updated_date;
    private String name;
    private String path;

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

    public String getPath(){
        return path;
    }

    public void setPath(String authority){
        this.path = path;
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Document && (this == object || EqualsBuilder.reflectionEquals(this, object));
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