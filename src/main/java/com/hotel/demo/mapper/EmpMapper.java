package com.hotel.demo.mapper;

import com.hotel.demo.entity.Emp;
import com.hotel.demo.provider.EmpSQLProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmpMapper {
    @Insert("INSERT INTO employee(eid, ename, gender, department, hiredate) " +
            "VALUES(#{eid}, #{ename}, #{gender}, #{department}, #{hireDate})")
    void insertEmp(Emp emp);

    @Delete("DELETE FROM employee WHERE eid = #{eid}")
    void deleteEmp(Integer empId);

    @Select("SELECT * FROM employee WHERE eid = #{eid}")
    Emp selectEmp(Integer empId);

    @SelectProvider(type= EmpSQLProvider.class, method = "createSelectAllSQL")
    List<Emp> selectAllEmps(Emp emp);

    @UpdateProvider(type = EmpSQLProvider.class,method = "createUpdateSQL")
    void updateEmp(Emp emp);
}
