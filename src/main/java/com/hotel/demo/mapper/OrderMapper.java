package com.hotel.demo.mapper;

import com.hotel.demo.entity.Order;
import com.hotel.demo.entity.Room;
import com.hotel.demo.provider.OrderSQLProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface OrderMapper {
    @Insert("INSERT INTO `order` (oid, rid, number, indate, outdate, oname, ophone)" +
            " VALUES(#{oid}, #{rid}, #{number}, #{inDate}, #{outDate}, #{oname}, #{ophone})")
    void insertOrder(Order order);

    @Select("SELECT `oid`,`rid`,`number`,`indate`,`outdate`,`oname`,`ophone` FROM `order` WHERE oid = #{oid}")
    @Results(id = "withOrders",value = {
            @Result(id = true, column = "oid", property = "oid"),
            @Result(column = "rid",property = "rid"),
            @Result(column = "number",property = "number"),
            @Result(column = "indate",property = "inDate"),
            @Result(column = "outdate",property = "outDate"),
            @Result(column = "oname",property = "oname"),
            @Result(column = "omphone",property = "ophone")
    })
    Order selectOrderByOrderId(Integer oid);

    @Select("SELECT `oid`,`rid`,`number`,`indate`,`outdate`,`oname`,`ophone` " +
            "FROM `order` WHERE oid = #{oid} ")
    List<Order> selectOrderByRoomId(Integer rid);

    @UpdateProvider(type = OrderSQLProvider.class, method = "createUpdateSQL")
    void updateOrder(Order order);

    @Delete("DELETE FROM `order` WHERE oid = #{oid}")
    void deleteOrderByOrderId(Integer oid);

}
