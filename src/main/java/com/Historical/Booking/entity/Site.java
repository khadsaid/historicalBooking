package com.Historical.Booking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Site extends User{
    private String siteName;
    private String siteLocation;

    private byte[] image;
}

