package com.hotel.demo.entity;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor

@Data
@Builder
public class Room {

    private Integer roomId;

    private Integer roomType;

    private Integer status;

    private Date inDate;

    private Date outDate;

}
