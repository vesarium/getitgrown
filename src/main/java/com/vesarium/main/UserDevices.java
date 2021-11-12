package com.vesarium.main;

import javax.persistence.*;

@Entity
@Table(name = "userdevices")
public class UserDevices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userid;
    private Integer deviceid;

}

