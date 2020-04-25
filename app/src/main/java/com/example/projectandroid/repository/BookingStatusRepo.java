package com.example.projectandroid.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import com.example.projectandroid.dao.BookingStatusDAO;
import com.example.projectandroid.database.AppDatabase;
import com.example.projectandroid.model.BookingStatus;

import java.util.List;

public class BookingStatusRepo {
    private BookingStatusDAO statusDAO;

    public BookingStatusRepo(Context context) {
        AppDatabase database = Room.databaseBuilder(context, AppDatabase.class, "vnkye2").allowMainThreadQueries().build();
        statusDAO = database.bookingStatusDAO();
    }

    public void insert(BookingStatus status) {
        new BookingStatusRepo.InsertBookingStatusAsyncTask(statusDAO).execute(status);
    }

    public void update(BookingStatus status) {
        new BookingStatusRepo.UpdateBookingStatusAsyncTask(statusDAO).execute(status);
    }

    public void delete(BookingStatus status) {
        new BookingStatusRepo.DeleteBookingStatusAsyncTask(statusDAO).execute(status);
    }

    public List<BookingStatus> getAll() {
        return statusDAO.getAllBooking();
    }

    public List<BookingStatus> getBookingStatusById(int idBooking){
        return statusDAO.getBookingStatusByIdBooking(idBooking);
    }



    private static class InsertBookingStatusAsyncTask extends AsyncTask<BookingStatus, Void, Void> {

        BookingStatusDAO statusDAO;

        InsertBookingStatusAsyncTask(BookingStatusDAO statusDAO) {
            this.statusDAO = statusDAO;
        }


        @Override
        protected Void doInBackground(BookingStatus... bookingStatuses) {
            statusDAO.insertStatusDAO(bookingStatuses);

            return null;
        }
    }

    private static class UpdateBookingStatusAsyncTask extends AsyncTask<BookingStatus, Void, Void> {

        BookingStatusDAO statusDAO;

        UpdateBookingStatusAsyncTask(BookingStatusDAO statusDAO) {
            this.statusDAO = statusDAO;
        }

        @Override
        protected Void doInBackground(BookingStatus... bookingStatuses) {
            statusDAO.updateStatusDAO(bookingStatuses);

            return null;
        }

    }

    private static class DeleteBookingStatusAsyncTask extends AsyncTask<BookingStatus, Void, Void> {

        BookingStatusDAO statusDAO;

        DeleteBookingStatusAsyncTask(BookingStatusDAO statusDAO) {
            this.statusDAO = statusDAO;
        }

        @Override
        protected Void doInBackground(BookingStatus... bookingStatuses) {
            statusDAO.deleteStatusDAO(bookingStatuses);

            return null;
        }

    }
}
