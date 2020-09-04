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
    private Integer empId;

    private String empName;

    private String gender;

    private Date hireDate;

    private String deptName;


}
