package com.hotel.demo.mapper;

import com.hotel.demo.entity.Emp;
import com.hotel.demo.provider.EmpSQLProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmpMapper {
    @Insert("INSERT INTO employee(eid, ename, gender, department, hiredate) " +
            "VALUES(#{empId}, #{empName}, #{gender}, #{deptName}, #{hireDate})")
    void insertEmp(Emp emp);

    @Delete("DELETE FROM employee WHERE eid = #{empId}")
    void deleteEmp(Integer empId);

    @Select("SELECT * FROM employee WHERE eid = #{empId}")
    Emp selectEmp(Integer empId);

    @SelectProvider(type= EmpSQLProvider.class, method = "createSelectAllSQL")
    List<Emp> selectAllEmps(Emp emp);

}
