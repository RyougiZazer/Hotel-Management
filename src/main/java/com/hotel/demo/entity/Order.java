package com.hotel.demo.entity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor

@Data
@Builder
public class Order {

    private Integer oid;

    private Integer rid;

    private Integer number;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date outDate;

    private String oname;

    private String ophone;

}
