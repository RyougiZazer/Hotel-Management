package com.hotel.demo.entity;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor

@Data
@Builder
public class Order {

    private Integer oid;

    private Integer rid;

    private Integer number;

    private Date inDate;

    private Date outDate;

    private String oname;

    private String ophone;
}
