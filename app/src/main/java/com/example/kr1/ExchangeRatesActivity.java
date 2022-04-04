package com.example.kr1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class ExchangeRatesActivity extends AppCompatActivity {

    private List<Сurrency> currencies = new ArrayList();

    ListView countriesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange_rates);

        // начальная инициализация списка
        setInitialData();
        // получаем элемент ListView
        countriesList = (ListView) findViewById(R.id.countriesList);
        // создаем адаптер
        СurrencyAdapter stateAdapter = new СurrencyAdapter(this, R.layout.list_exchange_rates, currencies);
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

        currencies.add(new Сurrency("RUR", "Отделение1", "Работает", "08:00-17:00", R.drawable.ru));
        currencies.add(new Сurrency("USD", "Отделение1", "Работает", "08:00-17:00", R.drawable.us));
        currencies.add(new Сurrency("UKT", "Отделение2", "Не работает", "08:00-17:00", R.drawable.uk));
        currencies.add(new Сurrency("ADS", "Банкомат", "Работает", "08:00-17:00", R.drawable.ad));
        currencies.add(new Сurrency("LOG", "Отделение2", "Работает", "08:00-17:00", R.drawable.ae));
    }
}