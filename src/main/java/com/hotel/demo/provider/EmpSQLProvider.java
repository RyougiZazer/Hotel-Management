package com.hotel.demo.provider;

import com.hotel.demo.entity.Emp;
import org.apache.ibatis.jdbc.SQL;

public class EmpSQLProvider {
    public String createSelectAllSQL(Emp emp){
        return new SQL(){{
            SELECT("eid, ename, gender, department, hiredate");
            FROM("employee");
            if (null != emp.getEmpId()){
                WHERE("eid = #{empId}");
            }
            if (null != emp.getEmpName() && !"".equals(emp.getEmpName())){
                WHERE("ename = #{empName}");
            }
            if (null != emp.getGender()) {
                WHERE("gender = #{gender}");
            }
            if (null != emp.getDeptName()) {
                WHERE("department = #{deptName}");
            }
            if (null != emp.getHireDate()) {
                WHERE("hiredate = #{hireDate}");
            }
        }}
                .toString();
    }
}
