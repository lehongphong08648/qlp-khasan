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

    @Query("SELECT ROOM.* FROM ROOM " +
            "INNER JOIN BOOKING " +
            "ON ROOM.idRoom = BOOKING.idRoom " +
            "INNER JOIN BookingStatus " +
            "ON BOOKING.idBooking = BOOKINGSTATUS.idBooking " +
            "WHERE BOOKINGSTATUS.status LIKE :status")
    List<Rooms> getRoomByStatus(String status);

    @Query("SELECT * FROM ROOM " +
            "WHERE idRoom NOT IN (SELECT idRoom FROM BOOKING)")
    List<Rooms> getAllRoomNotBooking();

    @Query("SELECT * FROM ROOM " +
            "INNER JOIN BOOKING " +
            "ON ROOM.idRoom = BOOKING.idRoom " +
            "INNER JOIN BOOKINGSTATUS " +
            "ON BOOKING.idBooking = BOOKINGSTATUS.idBooking " +
            "WHERE BOOKINGSTATUS.status LIKE 'Offline'")
    List<Rooms> getAllRoomStatusOffline();

    @Query("SELECT * FROM ROOM WHERE idRoom LIKE :idRoom")
    List<Rooms> getRoomById(String idRoom);
}
