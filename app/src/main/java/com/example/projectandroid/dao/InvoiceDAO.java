package com.example.projectandroid.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.projectandroid.model.Invoice;

import java.util.Date;
import java.util.List;

@Dao
public interface InvoiceDAO {
    @Insert
    void insertInvoice(Invoice... invoices);

    @Update
    void updateInvoice(Invoice... invoices);

    @Delete
    void deleteInvoice(Invoice... invoices);

    @Query("SELECT * FROM INVOICE")
    List<Invoice> getAllInvoice();

    @Query("SELECT SUM(total) FROM INVOICE INNER JOIN BOOKING " +
            "ON INVOICE.idBooking = BOOKING.idBooking " +
            "WHERE strftime('%Y-%m-%d',dayGo) = strftime('%Y-%m-%d','now')")
    List<Float> getInvoiceToday();

    @Query("SELECT SUM(total) FROM INVOICE INNER JOIN BOOKING " +
            "ON INVOICE.idBooking = BOOKING.idBooking " +
            "WHERE strftime('%Y-%m-%d',dayGo) = strftime('%Y-%m-%d', :date)")
    List<Float> getInvoiceByDay(Date date);

    @Query("SELECT SUM(total) FROM INVOICE INNER JOIN BOOKING " +
            "ON INVOICE.idBooking = BOOKING.idBooking " +
            "WHERE strftime('%m', dayGo) = strftime('%m', :date)")
    List<Float> getInvoiceByMonth(Date date);

    @Query("SELECT SUM(total) FROM INVOICE INNER JOIN BOOKING " +
            "ON INVOICE.idBooking = BOOKING.idBooking " +
            "WHERE strftime('%Y', dayGo) = strftime('%Y', :date)")
    List<Float> getInvoiceByYear(Date date);

    @Query("SELECT * FROM INVOICE WHERE id = :idInvoice")
    List<Invoice> getInvoiceById(int idInvoice);

}
