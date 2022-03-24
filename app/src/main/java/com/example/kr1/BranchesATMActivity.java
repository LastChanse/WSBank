package com.example.kr1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BranchesATMActivity extends Activity {

    private List<Departament> departaments = new ArrayList();

    ListView countriesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branches_atmactivity);

        // начальная инициализация списка
        setInitialData();
        // получаем элемент ListView
        countriesList = (ListView) findViewById(R.id.countriesList);
        // создаем адаптер
        DepartamentAdapter stateAdapter = new DepartamentAdapter(this, R.layout.list_departament, departaments);
        // устанавливаем адаптер
        countriesList.setAdapter(stateAdapter);
        // слушатель выбора в списке
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // получаем выбранный пункт
                Departament selectedState = (Departament) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedState.getAddress(),
                        Toast.LENGTH_SHORT).show();
            }
        };
        countriesList.setOnItemClickListener(itemListener);
    }

    private void setInitialData() {

        departaments.add(new Departament("Адресс1", "Отделение1", "Работает", "08:00-17:00"));//R.drawable.home));
        departaments.add(new Departament("Адресс2", "Отделение1", "Работает", "08:00-17:00"));//R.drawable.home));
        departaments.add(new Departament("Адресс3", "Отделение2", "Не работает", "08:00-17:00"));//R.drawable.home));
        departaments.add(new Departament("Адресс4", "Банкомат", "Работает", "08:00-17:00"));//R.drawable.home));
        departaments.add(new Departament("Адресс5", "Отделение2", "Работает", "08:00-17:00"));//R.drawable.home));
    }
}