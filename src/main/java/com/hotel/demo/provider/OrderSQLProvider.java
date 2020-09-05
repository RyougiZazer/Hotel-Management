package com.hotel.demo.provider;

import com.hotel.demo.entity.Order;
import org.apache.ibatis.jdbc.SQL;

public class OrderSQLProvider {
    public String createUpdateSQL(Order order){
//        return new SQL()
//                .UPDATE("dept")
//                .SET("deptname = #{deptName}")
//                .SET("status = #{status}")
//                .WHERE("deptid = #{deptId}")
//                .toString();
        return new SQL(){{
            UPDATE("order");
            if (null != order.getRid() && !"".equals(order.getRid())){
                SET("rid = #{rid}");
            }
            if (null != order.getNumber()) {
                SET("number = #{number}");
            }
            if (null != order.getInDate()) {
                SET("indate = #{inDate}");
            }if (null != order.getOutDate()) {
                SET("outdate = #{outDate}");
            }if (null != order.getOname()) {
                SET("oname = #{oname}");
            }
            if (null != order.getOphone()) {
                SET("ophone = #{ophone}");
            }
            WHERE("oid = #{oid}");
        }}
                .toString();
    }

    public String createSelectAllSQL(Order order){
        return new SQL(){{
            SELECT("oid,rid,number,indate,outdate,oname,ophone");
            FROM("order");
            if (null != order.getOid()){
                WHERE("oid = #{oid}");
            }
            if (null != order.getRid() && !"".equals(order.getRid())){
                WHERE("rid = #{rid}");
            }
            if (null != order.getNumber()) {
                WHERE("number = #{number}");
            }
            if (null != order.getInDate()) {
                WHERE("indate = #{inDate}");
            }if (null != order.getOutDate()) {
                WHERE("outdate = #{outDate}");
            }if (null != order.getOname()) {
                WHERE("oname = #{oname}");
            }if (null != order.getOphone()) {
                WHERE("ophone = #{ophone}");
            }
        }}
                .toString();
    }
}
