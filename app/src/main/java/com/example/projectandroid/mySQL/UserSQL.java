package com.example.projectandroid.mySQL;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.projectandroid.model.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class UserSQL {

    private Context context;
    private static String LIST_USER_STRING;

    public UserSQL(Context context) {
        this.context = context;
    }

    public void insert(User user) {
        new InsertNewUser(context).execute(user);
    }

    static class InsertNewUser extends AsyncTask<User, Void, String> {

        Context context;

        InsertNewUser(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(User... users) {
            String res_url = "https://hoangku196.000webhostapp.com/insert_user.php";

            User user = users[0];

            String userName = user.getIdUser();
            String password = user.getPassword();
            String fullName = user.getFullName();
            String position = user.getPosition();

            URL url = null;

            try {
                url = new URL(res_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("userName", "UTF-8") + "=" + URLEncoder.encode(userName, "UTF-8")
                        + "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8")
                        + "&" + URLEncoder.encode("fullName", "UTF-8") + "=" + URLEncoder.encode(fullName, "UTF-8")
                        + "&" + URLEncoder.encode("position", "UTF-8") + "=" + URLEncoder.encode(position, "UTF-8");

                bw.write(data);
                bw.flush();
                bw.close();
                os.close();
                InputStream is = httpURLConnection.getInputStream();
                is.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return "Success";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
        }
    }

    static class UpdateUser extends AsyncTask<User, Void, String> {

        Context context;

        UpdateUser(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(User... users) {
            String res_url = "https://hoangku196.000webhostapp.com/update_user.php";

            User user = users[0];

            String userName = user.getIdUser();
            String password = user.getPassword();
            String fullName = user.getFullName();
            String position = user.getPosition();

            URL url = null;

            try {
                url = new URL(res_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("userName", "UTF-8") + "=" + URLEncoder.encode(userName, "UTF-8")
                        + "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8")
                        + "&" + URLEncoder.encode("fullName", "UTF-8") + "=" + URLEncoder.encode(fullName, "UTF-8")
                        + "&" + URLEncoder.encode("position", "UTF-8") + "=" + URLEncoder.encode(position, "UTF-8");

                bw.write(data);
                bw.flush();
                bw.close();
                os.close();
                InputStream is = httpURLConnection.getInputStream();
                is.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return "Success";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
        }
    }

    private static class GetListUser extends AsyncTask<Void, Void, String> {

        String json_string;

        @Override
        protected String doInBackground(Void... voids) {
            String link = "https://hoangku196.000webhostapp.com/list_user.php";
            URL url = null;
            try {
                url = new URL(link);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();

                while ((json_string = bufferedReader.readLine()) != null) {

                    stringBuilder.append(json_string + "\n");

                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            LIST_USER_STRING = s;
        }
    }
}
