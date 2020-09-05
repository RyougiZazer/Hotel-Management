package com.hotel.demo.entity;

import lombok.*;

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

    private Date hiredate;

    private String department;


}
