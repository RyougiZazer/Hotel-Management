package com.hotel.demo.mapper;

import com.hotel.demo.entity.Room;
import com.hotel.demo.provider.RoomSQLProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface RoomMapper {

    @Insert("INSERT INTO Room(rid,rtype,status) values(#{rid},#{rtype},#{status})")
    void insertRoom(Room room);

    @Select("SELECT rid, rtype,status FROM room WHERE rid = #{rid}")
    @Results(id = "withRooms",value = {
            @Result(id = true, column = "rid", property = "rid"),
            @Result(column = "rtype",property = "rtype"),
            @Result(column = "status",property = "status"),
            @Result(column = "rid",property = "orderList",
            many = @Many(select = "com.hotel.demo.mapper.OrderMapper.selectOrderByOrderId",
                        fetchType = FetchType.LAZY)
            )
    })
    Room selectRoomByRoomId(Integer rid);

    @SelectProvider(type = RoomSQLProvider.class, method = "createSelectAllSQL")
    List<Room> selectAllRoom(Room room);

    @UpdateProvider(type = RoomSQLProvider.class, method = "createUpdateSQL")
    void updateRoom(Room room);

    @Delete("DELETE FROM room WHERE rid = #{rid}")
    void deleteRoomByRoomId(Integer rid);
}
