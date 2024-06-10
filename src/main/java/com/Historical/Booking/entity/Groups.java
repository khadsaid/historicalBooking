package com.Historical.Booking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Groups extends User{

    private String GroupName;
    private  String GroupType;
    private  String Address;
    private  String TotalNumber;
    private String PhoneNumber;
    private Date date;
}
