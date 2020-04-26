package com.example.projectandroid.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.projectandroid.model.BookingStatus;

import java.util.List;

@Dao
public interface BookingStatusDAO {

    @Insert
    void insertStatusDAO(BookingStatus... bookingStatuses);

    @Update
    void updateStatusDAO(BookingStatus... bookingStatuses);

    @Delete
    void deleteStatusDAO(BookingStatus... bookingStatuses);

    @Query("SELECT * FROM BOOKINGSTATUS")
    List<BookingStatus> getAllBooking();

    @Query("SELECT * FROM BOOKINGSTATUS WHERE idBooking = :idBooking")
    List<BookingStatus> getBookingStatusByIdBooking(int idBooking);

    @Query("SELECT * FROM BOOKINGSTATUS " +
            "INNER JOIN BOOKING " +
            "ON BOOKINGSTATUS.idBooking = BOOKING.idBooking " +
            "WHERE idRoom LIKE :idRoom And status LIKE 'Busy'")
    List<BookingStatus> getIDBookingStatusByIdRoomBusy(String idRoom);
}
