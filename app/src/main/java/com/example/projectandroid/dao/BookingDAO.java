package com.example.projectandroid.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.projectandroid.model.Booking;

import java.util.Date;
import java.util.List;

@Dao
public interface BookingDAO {

    @Insert
    long[] insertBooking(Booking... bookings);

    @Update
    void updateBooking(Booking... bookings);

    @Delete
    void deleteBooking(Booking... bookings);

    @Query("SELECT * FROM BOOKING")
    List<Booking> getAllBooking();

    @Query("SELECT * FROM BOOKING WHERE :idBooking = idBooking")
    List<Booking> getBookingById(int idBooking);

    @Query("SELECT BOOKING.* FROM BOOKING " +
            "INNER JOIN BOOKINGSTATUS " +
            "ON BOOKING.idBooking = BOOKINGSTATUS.idBooking " +
            "WHERE BOOKING.idRoom lIKE :idRoom AND BOOKINGSTATUS.status LIKE :status")
    List<Booking> getBookingByIdAndStatus(String idRoom, String status);

    //Hàm đếm booking
    @Query("SELECT COUNT(*) FROM BOOKING ")
    int[] countBooking();

    @Query("SELECT MAX(idBooking) FROM booking")
    int[] maxIdBooking();

    @Query("SELECT BOOKING.* FROM BOOKING " +
            "INNER JOIN BOOKINGSTATUS " +
            "ON BOOKING.idBooking = BOOKINGSTATUS.idBooking " +
            "WHERE BOOKING.dayCome > :dateNow")
    List<Booking> getAllBookingUnderDay(Date dateNow);

    @Query("SELECT BOOKING.* FROM BOOKING " +
            "INNER JOIN BOOKINGSTATUS " +
            "ON BOOKING.idBooking = BOOKINGSTATUS.idBooking " +
            "WHERE status LIKE 'Booking' AND idRoom LIKE :idRoom")
    List<Booking> getAllBookingByIdRoom(String idRoom);

}
//k đc a