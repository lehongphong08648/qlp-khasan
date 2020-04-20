package com.example.projectandroid.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import com.example.projectandroid.dao.KindOfRoomDAO;
import com.example.projectandroid.database.AppDatabase;
import com.example.projectandroid.model.KindOfRoom;

import java.util.List;

public class KorRepo {
    private KindOfRoomDAO korDAO;

    public KorRepo(Context context) {
        AppDatabase database = Room.databaseBuilder(context, AppDatabase.class, "db1").allowMainThreadQueries().build();
        korDAO = database.korDAO();
    }

    public void insert(KindOfRoom kor) {
        new InsertKORAsyncTask(korDAO).execute(kor);
    }

    public void update(KindOfRoom kor) {
        new UpdateKORAsyncTask(korDAO).execute(kor);
    }

    public void delete(KindOfRoom kor) {
        new DeleteKORAsyncTask(korDAO).execute(kor);
    }

    public List<KindOfRoom> getAll() {
        return korDAO.getAllKindOfRoom();
    }

    private static class InsertKORAsyncTask extends AsyncTask<KindOfRoom, Void, Void> {

        KindOfRoomDAO korDAO;

        InsertKORAsyncTask(KindOfRoomDAO korDAO) {
            this.korDAO = korDAO;
        }


        @Override
        protected Void doInBackground(KindOfRoom... clients) {
            korDAO.insertKORs(clients);

            return null;
        }
    }

    private static class UpdateKORAsyncTask extends AsyncTask<KindOfRoom, Void, Void> {

        KindOfRoomDAO korDAO;

        UpdateKORAsyncTask(KindOfRoomDAO korDAO) {
            this.korDAO = korDAO;
        }

        @Override
        protected Void doInBackground(KindOfRoom... clients) {
            korDAO.updateKORs(clients);

            return null;
        }

    }

    private static class DeleteKORAsyncTask extends AsyncTask<KindOfRoom, Void, Void> {

        KindOfRoomDAO korDAO;

        DeleteKORAsyncTask(KindOfRoomDAO korDAO) {
            this.korDAO = korDAO;
        }

        @Override
        protected Void doInBackground(KindOfRoom... clients) {
            korDAO.deleteKORs(clients);

            return null;
        }

    }
}
