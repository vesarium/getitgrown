package com.vesarium.main;
import javax.persistence.*;
@Entity
@Table(name = "device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    private String name;
    private Integer serial;

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
