package com.hotel.demo.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
public class Emp {

    private Integer eid;

    private String ename;

    private Integer gender;

    @DateTimeFormat(pattern = "yyyy-MM-ss")
    private Date hiredate;

    private String department;


}
