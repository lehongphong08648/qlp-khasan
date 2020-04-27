package com.example.projectandroid.repository;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.room.Room;

import com.example.projectandroid.dao.BookingDAO;
import com.example.projectandroid.dao.BookingStatusDAO;
import com.example.projectandroid.dao.RoomDAO;
import com.example.projectandroid.database.AppDatabase;
import com.example.projectandroid.model.Booking;
import com.example.projectandroid.model.BookingStatus;
import com.example.projectandroid.model.Rooms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BookingRepo {
    private BookingDAO bookingDAO;
    private BookingStatusDAO bookingStatusDAO;

    public BookingRepo(Context context) {
        AppDatabase database = Room.databaseBuilder(context, AppDatabase.class, "nhom6").allowMainThreadQueries().build();
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

    public List<Booking> getAll(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat getDateNow = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String strDateNow = getDateNow.format(calendar.getTime());
        Date dateNow = null;
        try {
            dateNow = getDateNow.parse(strDateNow);
        }catch (Exception e){
            e.printStackTrace();
        }
        for(Booking b : bookingDAO.getAllBookingUnderDay(dateNow))
            Log.e("Booking", b.getDayCome().toString());
        return bookingDAO.getAllBooking();
    }

    public Booking getBookingById(int idBooking) {
        return bookingDAO.getBookingById(idBooking).get(0);
    }

    public Booking getBookingByIdRoom(String idRoom, String status) {
        return bookingDAO.getBookingByIdAndStatus(idRoom, status).get(0);
    }


    //Lắp thử tét hàm này xem nào e ok a
    //Hàm lấy tất cả các Booking chưa đến ngày
    //được r đấy e
    // van dang dun get all ma a
    //ko cai a in ra log kia kia
    // la cai booking chua den ngay day

    public List<Booking> getListBookingUnderDay(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat getDateNow = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String strDateNow = getDateNow.format(calendar.getTime());
        Date dateNow = null;
        try {
            dateNow = getDateNow.parse(strDateNow);
        }catch (Exception e){
            e.printStackTrace();
        }
        return bookingDAO.getAllBookingUnderDay(dateNow);
    }


    public List<Booking> getAllBookingByIdRoom(String idRoom) {
        return bookingDAO.getAllBookingByIdRoom(idRoom);
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
