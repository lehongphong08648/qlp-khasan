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

    @Query("SELECT ROOM.* FROM ROOM " +
            "INNER JOIN BOOKING " +
            "ON ROOM.idRoom = BOOKING.idRoom " +
            "WHERE BOOKING.idRoom NOT IN (SELECT idBooking FROM BOOKINGSTATUS)")
    List<Rooms> getAllRoomNotBooking();

    @Query("SELECT ROOM.* FROM ROOM " +
            "INNER JOIN BOOKING " +
            "ON ROOM.idRoom = BOOKING.idRoom " +
            "WHERE BOOKING.idRoom NOT IN (SELECT idBooking FROM BOOKINGSTATUS)")
    List<Rooms> getAllRoomByBookingStatusOffline();

    @Query("SELECT * FROM ROOM WHERE idRoom LIKE :idRoom")
    List<Rooms> getRoomById(String idRoom);
}
