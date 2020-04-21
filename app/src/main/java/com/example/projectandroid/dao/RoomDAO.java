package com.example.projectandroid.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.projectandroid.model.Rooms;

import java.util.List;

@Dao
public interface RoomDAO {

    @Insert
    void insertRoom(Rooms... rooms);

    @Update
    void updateRoom(Rooms... rooms);

    @Delete
    void deleteRoom(Rooms... rooms);

    @Query("SELECT * FROM ROOM")
    List<Rooms> getAllRoom();

    @Query("SELECT * FROM ROOM WHERE STATUS LIKE 'Online'")
    List<Rooms> getOnlineRooms();

    @Query("SELECT * FROM ROOM WHERE STATUS LIKE 'Ofline'")
    List<Rooms> getOfflineRooms();

    @Query("SELECT * FROM ROOM WHERE STATUS LIKE 'Busy'")
    List<Rooms> getBusyRooms();

    @Query("SELECT * FROM ROOM WHERE STATUS LIKE 'Booking'")
    List<Rooms> getBookingRooms();

    @Query("SELECT * FROM ROOM WHERE idRoom LIKE :idRoom")
    List<Rooms> getRoomById(String idRoom);

}
