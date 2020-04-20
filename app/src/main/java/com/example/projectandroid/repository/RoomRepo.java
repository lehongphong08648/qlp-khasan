package com.example.projectandroid.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import com.example.projectandroid.dao.RoomDAO;
import com.example.projectandroid.database.AppDatabase;
import com.example.projectandroid.model.Rooms;

import java.util.List;

public class RoomRepo {

    private RoomDAO roomDAO;

    public RoomRepo(Context context) {
<<<<<<< HEAD
        AppDatabase database = Room.databaseBuilder(context, AppDatabase.class, "db1").allowMainThreadQueries().build();
=======
        AppDatabase database = Room.databaseBuilder(context, AppDatabase.class, "dbhotlind").allowMainThreadQueries().build();
>>>>>>> ddab3151a97f631cabdd26fd2142afefecf68cd6
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

    //Lấy tất cả phòng đang dọn
    public List<Rooms> getAllBusyRoom() {
        return roomDAO.getBusyRooms();
    }

    //Lấy tất cả phòng đang có người dùng
    public List<Rooms> getAllOnlineRoom() {
        return roomDAO.getOnlineRooms();
    }


    //Lấy tất cả các phòng trống
    public List<Rooms> getAllOfflineRoom() {
        return roomDAO.getOfflineRooms();
    }

    //Lấy tất cả các phòng đã đặt
    public List<Rooms> getAllBookingRoom() {
        return roomDAO.getBookingRooms();
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
