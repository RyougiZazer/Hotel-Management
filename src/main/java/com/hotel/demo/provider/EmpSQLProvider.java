package com.hotel.demo.provider;

import com.hotel.demo.entity.Emp;
import org.apache.ibatis.jdbc.SQL;

public class EmpSQLProvider {
    public String createSelectAllSQL(Emp emp){
        return new SQL(){{
            SELECT("eid, ename, gender, department, hiredate");
            FROM("employee");
            if (null != emp.getEid()){
                WHERE("eid = #{eid}");
            }
            if (null != emp.getEname() && !"".equals(emp.getEname())){
                WHERE("ename = #{ename}");
            }
            if (null != emp.getGender()) {
                WHERE("gender = #{gender}");
            }
            if (null != emp.getDepartment()) {
                WHERE("department = #{department}");
            }
            if (null != emp.getHireDate()) {
                WHERE("hiredate = #{hireDate}");
            }
        }}
                .toString();
    }
    public String createUpdateSQL(Emp emp){
        return new SQL()
                .UPDATE("employee")
                .SET("eid = #{eid}")
                .SET("ename = #{ename}")
                .SET("gender=#{gender}")
                .SET("department=#{department}")
                .SET("hiredate=#{hiredate}")
                .WHERE("eid = #{eid}")
                .toString();
    }
}
