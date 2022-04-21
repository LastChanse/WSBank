package com.example.kr1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public boolean change_content_view = false;
    public EditText login;
    public EditText password;

    private boolean mVisible;
    private View mControlsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mVisible = true;
        hide();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return false;
    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        //mControlsView.setVisibility(View.GONE);
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        //mHideHandler.removeCallbacks(mShowPart2Runnable);
        //mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    public void goToActivityABA(View view) {
        Intent intent = new Intent(this, BranchesATMActivity.class);
        startActivity(intent);
    }

    public void goToActivityAER(View view) {
        Intent intent = new Intent(this, ExchangeRatesActivity.class);
        startActivity(intent);
    }

    public void close(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void сreateDialog(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder
                .setView(R.layout.login)
                .create();
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.login, null);
        builder.setView(dialogView);
        login = (EditText) dialogView.findViewById(R.id.input_login);
        password = (EditText) dialogView.findViewById(R.id.input_password);
        builder.create().show();
    }

    public void addLogin(View view) throws JSONException {
        String login = this.login.getText().toString();
        String password = this.password.getText().toString();
        JSONObject json = new JSONObject();
        json.put("email", login);
        json.put("password", password);

        String url = "http://cinema.areas.su/auth/login";

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, json,
                result -> Toast.makeText(this, "Успешный вход", Toast.LENGTH_LONG).show(),
                error -> Toast.makeText(this, "Неверный логин или парроль", Toast.LENGTH_LONG).show()
        );
        requestQueue.add(request);
    }

    public void login(View view) {
        сreateDialog(this);
    }
}