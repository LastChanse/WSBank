package com.example.kr1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToActivityABA(View view) {
        Intent intent = new Intent(this, BranchesATMActivity.class);
        startActivity(intent);
    }

    public void goToActivityAER(View view) {
        Intent intent = new Intent(this, ExchangeRatesActivity.class);
        startActivity(intent);
    }

    public void login(View view){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        //set title
        alertDialog.setTitle("title")
        //set message
                .setMessage("title")
        //set positive button
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //set what would happen when positive button is clicked
                        alertDialog.dismiss();
                    }
                })
        //set negative button
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

            //set what should happen when negative button is clicked
                        alertDialog.dismiss();
                    }
                })
                .show();
        /*        // Создание Toast сообщения
        Toast toast = new Toast(getApplicationContext());
        // Позиционирование сообщения
        toast.setGravity(Gravity.CENTER, 0, 0);
        // Определение продолжительности
        toast.setDuration(Toast.LENGTH_LONG);

        // Создание View из контента файла xml:
        LayoutInflater inflater = getLayoutInflater();
        View vw = inflater.inflate(R.layout.login, null);
        // Определение View компонента
        toast.setView(vw);
        // Представление сообщения
        toast.show();
    */
    }

}