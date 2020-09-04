package com.hotel.demo.entity;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor

@Data
@Builder
public class Room {

    private Integer rid;

    private Integer rtype;

    private Integer status;


}
