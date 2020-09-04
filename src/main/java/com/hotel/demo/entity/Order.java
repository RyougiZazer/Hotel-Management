package com.hotel.demo.entity;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor

@Data
@Builder
public class Order {

    private Integer orderId;

    private Integer roomId;

    private Integer number;

    private Date inDate;

    private Date outDate;

    private String orderMan;

    private String OMPhone;
}
