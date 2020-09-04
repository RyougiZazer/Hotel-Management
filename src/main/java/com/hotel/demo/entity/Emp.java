package com.hotel.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor

@Data
@Builder

public class Emp {

    private Integer eid;

    private String ename;

    private Integer gender;

    private Date hireDate;

    private String department;


}
