package edu.uwm.capstone.model.position;

import java.time.LocalDateTime;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Position {
    protected Long id;
    private String name;
    protected Long company_ID;
    private String description;
    protected LocalDateTime created_date;
    protected LocalDateTime updated_date;
    protected LocalDateTime start_date;
    protected LocalDateTime end_date;
    private Double start_pay;
    private Double end_pay;


    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {return name; }

    public void setName(String name) { this.name = name;}

    public Long getCompanyId(){ return company_ID; }

    public void setCompanyId(Long company_id) { this.company_ID = company_id; }

    public String getDescription() {return description; }

    public void setDescription(String description) { this.description = description;}

    public LocalDateTime getCreatedDate() {
        return created_date;
    }

    public void setCreatedDate(LocalDateTime created_date) { this.created_date = created_date; }

    public LocalDateTime getUpdatedDate() { return updated_date; }

    public void setUpdatedDate(LocalDateTime updated_date) { this.updated_date = updated_date; }

    public LocalDateTime getStartDate() {
        return start_date;
    }

    public void setStartDate(LocalDateTime start_date) { this.start_date = start_date; }

    public LocalDateTime getEndDate() { return end_date; }

    public void setEndDate(LocalDateTime end_date) { this.end_date = end_date; }

    public Double getStartPay() { return start_pay; }

    public void setStartPay(Double start_pay){ this.start_pay = start_pay; }

    public Double getEndPay() { return end_pay; }

    public void setEndPay(Double end_pay){ this.end_pay = end_pay; }

    @Override
    public boolean equals(Object object) {
        return object instanceof Position && (this == object || EqualsBuilder.reflectionEquals(this, object));
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