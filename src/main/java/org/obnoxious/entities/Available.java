package org.obnoxious.entities;

import javax.persistence.*;

@Entity
@Table(name = "available")
public class Available {

    @Id
    @GeneratedValue
    private Long availableId;
    @Column(name = "available_status")
    private String availableStatus;

    public Available(){

    }

    public Available(String availableStatus) {
        this.availableStatus = availableStatus;
    }

    public Long getAvailableId() {
        return availableId;
    }

    public void setAvailableId(Long availableId) {
        this.availableId = availableId;
    }

    public String getAvailableStatus() {
        return availableStatus;
    }

    public void setAvailableStatus(String availableStatus) {
        this.availableStatus = availableStatus;
    }
}
