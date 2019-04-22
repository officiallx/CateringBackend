package org.obnoxious.entities;

import javax.persistence.*;

@Entity
@Table(name = "position")
public class Position {

    @Id
    @GeneratedValue
    private Long pId;
    @Column(name = "position_type")
    private String positionType;

    public Position(){

    }

    public Position(String positionType) {
        this.positionType = positionType;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }
}
