package com.example.kr1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Trace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class СurrencyAdapter extends ArrayAdapter<Сurrency> {
    private LayoutInflater inflater;
    private int layout;
    private List<Сurrency> currencies;

    public СurrencyAdapter(Context context, int resource, List<Сurrency> Currency) {
        super(context, resource, Currency);
        this.currencies = Currency;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @SuppressLint("ResourceAsColor")
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = inflater.inflate(this.layout, parent, false);

        ImageView flagView = (ImageView) view.findViewById(R.id.flag);
        TextView nameView = (TextView) view.findViewById(R.id.name);
        TextView purchaseView = (TextView) view.findViewById(R.id.purchase);
        TextView saleView = (TextView) view.findViewById(R.id.sale);
        TextView countryView = (TextView) view.findViewById(R.id.country);

        Сurrency currency = currencies.get(position);

        flagView.setImageResource(currency.getFlagResource());
        nameView.setText(currency.getName());
        purchaseView.setText(currency.getPurchase());
        saleView.setText(currency.getSale());
        countryView.setText(currency.getCountry());

        return view;
    }
}
