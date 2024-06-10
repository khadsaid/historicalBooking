package com.Historical.Booking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class School extends User{
    private String schoolName;
    private  String schoolAddress;
    private String schoolType;
    private Date date;
    private String phoneNumber;
    private String amountOfTechers;
    private String amountOfStudents;

}
