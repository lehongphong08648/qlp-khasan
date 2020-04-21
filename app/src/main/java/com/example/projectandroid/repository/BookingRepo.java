package com.example.projectandroid.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import com.example.projectandroid.dao.BookingDAO;
import com.example.projectandroid.dao.RoomDAO;
import com.example.projectandroid.database.AppDatabase;
import com.example.projectandroid.model.Booking;
import com.example.projectandroid.model.Rooms;

import java.util.List;

public class BookingRepo {
    private BookingDAO bookingDAO;
    private RoomDAO roomDAO;

    public BookingRepo(Context context) {
        AppDatabase database = Room.databaseBuilder(context, AppDatabase.class, "hotlindbling").allowMainThreadQueries().build();
        bookingDAO = database.bookingDAO();
        roomDAO = database.roomDAO();
    }

    public void insert(Booking booking) {
        new InsertBookingAsyncTask(bookingDAO, roomDAO).execute(booking);
    }

    public void update(Booking booking) {
        new UpdateBookingAsyncTask(bookingDAO).execute(booking);
    }

    public void delete(Booking booking) {
        new DeleteBookingAsyncTask(bookingDAO).execute(booking);
    }

    public List<Booking> getAll() {
        return bookingDAO.getAllBooking();
    }

    //TODO: lấy booking theo id
    public Booking getBookingById(int idBooking) {
        return bookingDAO.getBookingById(idBooking);
    }


    private static class InsertBookingAsyncTask extends AsyncTask<Booking, Void, Void> {

        BookingDAO bookingDAO;
        RoomDAO roomDAO;

        InsertBookingAsyncTask(BookingDAO bookingDAO, RoomDAO roomDAO) {
            this.bookingDAO = bookingDAO;
            this.roomDAO = roomDAO;
        }


        @Override
        protected Void doInBackground(Booking... bookings) {
            if (bookingDAO.insertBooking(bookings)[0] > 0) {
                String idRoom = bookings[0].getIdRoom();
                Rooms room = roomDAO.getRoom(idRoom);
                room.setStatus("Online");
                roomDAO.updateRoom(room);
            }

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
