package com.example.projectandroid.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.example.projectandroid.dao.RoomDAO;
import com.example.projectandroid.database.AppDatabase;
import com.example.projectandroid.model.Rooms;

import java.util.List;

public class RoomRepo {

    private RoomDAO roomDAO;

    public RoomRepo(Context context) {
        AppDatabase database = AppDatabase.getInstance(context);
        roomDAO = database.roomDAO();
    }

    public void insert(Rooms room) {
        new InsertRoomAsyncTask(roomDAO).execute(room);
    }

    public void update(Rooms room) {
        new UpdateRoomAsyncTask(roomDAO).execute(room);
    }

    public void delete(Rooms room) {
        new DeleteRoomAsyncTask(roomDAO).execute(room);
    }

    public List<Rooms> getAll() {
        return roomDAO.getAllRoom();
    }

    private static class InsertRoomAsyncTask extends AsyncTask<Rooms, Void, Void> {

        RoomDAO roomDAO;

        InsertRoomAsyncTask(RoomDAO roomDAO) {
            this.roomDAO = roomDAO;
        }

        @Override
        protected Void doInBackground(Rooms... rooms) {

            roomDAO.insertRoom(rooms);

            return null;
        }

    }

    private static class UpdateRoomAsyncTask extends AsyncTask<Rooms, Void, Void> {

        RoomDAO roomDAO;

        UpdateRoomAsyncTask(RoomDAO roomDAO) {
            this.roomDAO = roomDAO;
        }

        @Override
        protected Void doInBackground(Rooms... rooms) {
            roomDAO.updateRoom(rooms);

            return null;
        }

    }

    private static class DeleteRoomAsyncTask extends AsyncTask<Rooms, Void, Void> {

        RoomDAO roomDAO;

        DeleteRoomAsyncTask(RoomDAO roomDAO) {
            this.roomDAO = roomDAO;
        }

        @Override
        protected Void doInBackground(Rooms... rooms) {
            roomDAO.deleteRoom(rooms);

            return null;
        }

    }

}
