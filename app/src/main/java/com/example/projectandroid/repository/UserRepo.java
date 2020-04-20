package com.example.projectandroid.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import com.example.projectandroid.dao.UserDAO;
import com.example.projectandroid.database.AppDatabase;
import com.example.projectandroid.model.User;

import java.util.List;

public class UserRepo {
    private UserDAO userDAO;

    public UserRepo(Context context) {
        AppDatabase database = Room.databaseBuilder(context, AppDatabase.class, "db1").allowMainThreadQueries().build();
        userDAO = database.userDAO();
    }

    public void insert(User user) {
        new InsertUserAsyncTask(userDAO).execute(user);
    }

    public void update(User user) {
        new UpdateUserAsyncTask(userDAO).execute(user);
    }

    public void delete(User user) {
        new DeleteUserAsyncTask(userDAO).execute(user);
    }

    public List<User> getAll() {
        return userDAO.getAllUser();
    }

    private static class InsertUserAsyncTask extends AsyncTask<User, User, Void> {

        UserDAO userDAO;

        InsertUserAsyncTask(UserDAO userDAO) {
            this.userDAO = userDAO;
        }

        @Override
        protected Void doInBackground(User... users) {

            userDAO.insertUsers(users);

            return null;
        }

    }

    private static class UpdateUserAsyncTask extends AsyncTask<User, Void, Void> {

        UserDAO userDAO;

        UpdateUserAsyncTask(UserDAO userDAO) {
            this.userDAO = userDAO;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDAO.updateUsers(users);

            return null;
        }

    }

    private static class DeleteUserAsyncTask extends AsyncTask<User, Void, Void> {

        UserDAO userDAO;

        DeleteUserAsyncTask(UserDAO userDAO) {
            this.userDAO = userDAO;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDAO.deleteUsers(users);

            return null;
        }

    }

}
