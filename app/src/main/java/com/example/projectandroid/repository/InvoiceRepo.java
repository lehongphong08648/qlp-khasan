package com.example.projectandroid.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import com.example.projectandroid.dao.InvoiceDAO;
import com.example.projectandroid.database.AppDatabase;
import com.example.projectandroid.model.Invoice;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class InvoiceRepo {

    private InvoiceDAO invoiceDAO;

    public InvoiceRepo(Context context) {
        AppDatabase database = Room.databaseBuilder(context, AppDatabase.class, "databasevnkye2").allowMainThreadQueries().build();
        invoiceDAO = database.invoiceDAO();
    }

    public void insert(Invoice invoice) {
        new InsertInvoiceAsyncTask(invoiceDAO).execute(invoice);
    }

    public void update(Invoice invoice) {
        new UpdateInvoiceAsyncTask(invoiceDAO).execute(invoice);
    }

    public void delete(Invoice invoice) {
        new DeleteInvoiceAsyncTask(invoiceDAO).execute(invoice);
    }

    public List<Invoice> getAll() {
        return invoiceDAO.getAllInvoice();
    }

    //Lấy tổng hóa đơn trong ngày
    public float getInvoiceToday() {
        return invoiceDAO.getInvoiceToday().get(0);
    }

    public float getInvoiceByDay(int day){
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), day);

        Date date = new Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));

        return invoiceDAO.getInvoiceByDay(date).get(0);
    }

    //Lấy hóa đơn theo tháng
    public float getInvoiceByMonth(int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), month - 1, calendar.get(Calendar.DATE));

        Date date = new Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));

        return invoiceDAO.getInvoiceByMonth(date).get(0);
    }

    //Lấy doanh thu năm
    public float getInvoiceByYear(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));

        Date date = new Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));

        return invoiceDAO.getInvoiceByYear(date).get(0);
    }

    public Invoice getInvoiceByID(int id) {
        return invoiceDAO.getInvoiceById(id).get(0);
    }

    private static class InsertInvoiceAsyncTask extends AsyncTask<Invoice, Void, Void> {

        InvoiceDAO invoiceDAO;

        InsertInvoiceAsyncTask(InvoiceDAO invoiceDAO) {
            this.invoiceDAO = invoiceDAO;
        }


        @Override
        protected Void doInBackground(Invoice... invoices) {
            invoiceDAO.insertInvoice(invoices);

            return null;
        }
    }

    private static class UpdateInvoiceAsyncTask extends AsyncTask<Invoice, Void, Void> {

        InvoiceDAO invoiceDAO;

        UpdateInvoiceAsyncTask(InvoiceDAO invoiceDAO) {
            this.invoiceDAO = invoiceDAO;
        }

        @Override
        protected Void doInBackground(Invoice... invoices) {
            invoiceDAO.updateInvoice(invoices);

            return null;
        }

    }

    private static class DeleteInvoiceAsyncTask extends AsyncTask<Invoice, Void, Void> {

        InvoiceDAO invoiceDAO;

        DeleteInvoiceAsyncTask(InvoiceDAO invoiceDAO) {
            this.invoiceDAO = invoiceDAO;
        }

        @Override
        protected Void doInBackground(Invoice... invoices) {
            invoiceDAO.updateInvoice(invoices);

            return null;
        }

    }

}
