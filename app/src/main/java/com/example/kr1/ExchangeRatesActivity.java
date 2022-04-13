package com.example.kr1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ExchangeRatesActivity extends AppCompatActivity {

    private List<Сurrency> currencies = new ArrayList();

    ListView countriesList;

    public String res = new String(); // Текст ответа от сервера

    public Document doc; // Документ для XML ответа от сервера

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange_rates);

        // начальная инициализация списка с отправкой запроса на сервер (API)
        try {
            setInitialData();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void setInitialData() throws JSONException {

        Toast.makeText(this, "Загрузка данных с сервера", Toast.LENGTH_LONG).show();

        JSONObject json = new JSONObject();
        String url = "http://www.cbr.ru/scripts/XML_daily.asp?date_req=13/04/2022";

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(Request.Method.GET, url,
                result -> ifResult(result),
                error -> Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show()
        );
        requestQueue.add(request);
    }

    private static Document convertStringToXMLDocument(String xmlString) {
        //Parser that produces DOM object trees from XML content
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //API to obtain DOM Document instance
        DocumentBuilder builder = null;
        try {
            //Create DocumentBuilder with default configuration
            builder = factory.newDocumentBuilder();

            //Parse the content to Document object
            Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void ifResult(String res) {
        if (res.isEmpty()) {
            currencies.add(new Сurrency("NON", "00.00", "00.00", "Неизвестная валюта", R.mipmap.ic_launcher));
            Toast.makeText(this, "Получен некорректный ответ от сервера.", Toast.LENGTH_LONG).show();
        } else {
            doc = convertStringToXMLDocument(res);
            //Toast.makeText(this, res, Toast.LENGTH_LONG).show();

            Element element = doc.getDocumentElement();
            NodeList nodeListCharCode = element.getElementsByTagName("CharCode");
            NodeList nodeListNominal = element.getElementsByTagName("Nominal");
            NodeList nodeListName = element.getElementsByTagName("Name");
            NodeList nodeListValue = element.getElementsByTagName("Value");
            int length = nodeListValue.getLength();
            for (int i = 0; i < length; ++i) {
                Element elCharCode = (Element) nodeListCharCode.item(i);
                Element elNominal = (Element) nodeListNominal.item(i);
                Element elName = (Element) nodeListName.item(i);
                Element elValue = (Element) nodeListValue.item(i);
                currencies.add(new Сurrency(elCharCode.getTextContent(), elNominal.getTextContent()+".00", elValue.getTextContent(), elName.getTextContent(), getApplicationContext().getResources().getIdentifier(elCharCode.getTextContent().toLowerCase(Locale.ROOT).substring(0,2), "drawable", getApplicationContext().getPackageName())));//R.drawable.ru));
            }
//getApplicationContext().getResources().getIdentifier(elName.getTextContent().toLowerCase(Locale.ROOT).substring(0,1), "drawable", getApplicationContext().getPackageName())
            currencies.add(new

                    Сurrency("RUR", "10.00", "20.00", "Русский рубль", R.drawable.ru));
            currencies.add(new

                    Сurrency("USD", "10.00", "20.00", "Американский доллар", R.drawable.us));
            currencies.add(new

                    Сurrency("UKT", "10.00", "20.00", "Британский фунт", R.drawable.uk));
            currencies.add(new

                    Сurrency("EUR", "10.00", "20.00", "Андоррский евро", R.drawable.ad));
            currencies.add(new

                    Сurrency("AED", "10.00", "20.00", "Дирхам Объединенных Арабских Эмиратов", R.drawable.ae));
        }
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

}