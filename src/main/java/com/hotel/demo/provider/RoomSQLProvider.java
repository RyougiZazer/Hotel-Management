package com.hotel.demo.provider;

import com.hotel.demo.entity.Room;
import org.apache.ibatis.jdbc.SQL;

public class RoomSQLProvider {
    public String createUpdateSQL(Room room){
//        return new SQL()
//                .UPDATE("dept")
//                .SET("deptname = #{deptName}")
//                .SET("status = #{status}")
//                .WHERE("deptid = #{deptId}")
//                .toString();
        return new SQL(){{
            UPDATE("room");
            if (null != room.getRtype() && !"".equals(room.getRtype())){
                SET("rtype = #{rtype}");
            }
            if (null != room.getStatus()) {
                SET("status = #{status}");
            }
            WHERE("rid = #{rid}");
        }}
                .toString();
    }

    public String createSelectAllSQL(Room room){
        return new SQL(){{
            SELECT("rid, rtype, status");
            FROM("room");
            if (null != room.getRid()){
                WHERE("rid = #{rid}");
            }
            if (null != room.getRtype() && !"".equals(room.getRtype())){
                WHERE("rtype = #{rtype}");
            }
            if (null != room.getStatus()) {
                WHERE("status = #{status}");
            }
        }}
                .toString();
    }
}
