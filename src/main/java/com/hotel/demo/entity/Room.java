package com.hotel.demo.entity;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor

@Data
@Builder
public class Room {

    private Integer rid;

    private Integer rtype;

    private Integer status;

    private List<Order> orderList;

    public String getTypeString(){
        switch (rtype){
            case 1:
                return "单人间";
            case 2:
                return "双人间";
            case 3:
                return "大间";
            case 4:
                return "总统套房";
            case 8:
                return "青年旅社套房";
            default:
                return "双人间";
        }

    }

}
