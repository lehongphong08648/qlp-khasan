package com.example.projectandroid.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import com.example.projectandroid.dao.BookingDAO;
import com.example.projectandroid.dao.BookingStatusDAO;
import com.example.projectandroid.dao.RoomDAO;
import com.example.projectandroid.database.AppDatabase;
import com.example.projectandroid.model.Booking;
import com.example.projectandroid.model.BookingStatus;
import com.example.projectandroid.model.Rooms;

import java.util.List;

public class BookingRepo {
    private BookingDAO bookingDAO;
    private BookingStatusDAO bookingStatusDAO;

    public BookingRepo(Context context) {
        AppDatabase database = Room.databaseBuilder(context, AppDatabase.class, "vnkye2").allowMainThreadQueries().build();
        bookingDAO = database.bookingDAO();
        bookingStatusDAO = database.bookingStatusDAO();
    }

    public void insert(Booking booking) {
        new InsertBookingAsyncTask(bookingDAO).execute(booking);
    }

    public void update(Booking booking) {
        new UpdateBookingAsyncTask(bookingDAO).execute(booking);
    }

    public void delete(Booking booking) {
        new DeleteBookingAsyncTask(bookingDAO).execute(booking);
    }

    //TODO: Hàm tự sinh id Booking
    //E truyền cái này vào 1 text View để hiển thị idBooking cho nó
    public int autoGenerateIdBooking() {
        if (bookingDAO.countBooking()[0] == 0) {
            return 1;
        } else {
            return bookingDAO.maxIdBooking()[0] + 1;
        }
    }

    public List<Booking> getAll() {
        return bookingDAO.getAllBooking();
    }

    public Booking getBookingById(int idBooking) {
        return bookingDAO.getBookingById(idBooking).get(0);
    }

    public Booking getBookingByIdRoom(String idRoom) {
        return bookingDAO.getBookingByIdAndStatus(idRoom, "Online").get(0);
    }


    private static class InsertBookingAsyncTask extends AsyncTask<Booking, Void, Void> {

        BookingDAO bookingDAO;

        InsertBookingAsyncTask(BookingDAO bookingDAO) {
            this.bookingDAO = bookingDAO;
        }


        @Override
        protected Void doInBackground(Booking... bookings) {
            bookingDAO.insertBooking(bookings);

            return null;
        }
    }

    private static class UpdateBookingAsyncTask extends AsyncTask<Booking, Void, Void> {

        BookingDAO bookingDAO;

        UpdateBookingAsyncTask(BookingDAO bookingDAO) {
            this.bookingDAO = bookingDAO;
        }

        @Override
        protected Void doInBackground(Booking... bookings) {
            bookingDAO.updateBooking(bookings);

            return null;
        }

    }

    private static class DeleteBookingAsyncTask extends AsyncTask<Booking, Void, Void> {

        BookingDAO bookingDAO;

        DeleteBookingAsyncTask(BookingDAO bookingDAO) {
            this.bookingDAO = bookingDAO;
        }

        @Override
        protected Void doInBackground(Booking... bookings) {
            bookingDAO.deleteBooking(bookings);

            return null;
        }

    }
}
