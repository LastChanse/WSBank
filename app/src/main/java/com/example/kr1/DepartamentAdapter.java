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

public class DepartamentAdapter extends ArrayAdapter<Departament> {
    private LayoutInflater inflater;
    private int layout;
    private List<Departament> departaments;

    public DepartamentAdapter(Context context, int resource, List<Departament> Departament) {
        super(context, resource, Departament);
        this.departaments = Departament;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @SuppressLint("ResourceAsColor")
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = inflater.inflate(this.layout, parent, false);

        //ImageView flagView = (ImageView) view.findViewById(R.id.flag);
        TextView addressView = (TextView) view.findViewById(R.id.address);
        TextView bank_typeView = (TextView) view.findViewById(R.id.bank_type);
        TextView if_it_readyView = (TextView) view.findViewById(R.id.if_it_ready);
        TextView hours_in_worckView = (TextView) view.findViewById(R.id.hours_in_worck);
        View line = (View) view.findViewById(R.id.line);

        Departament departament = departaments.get(position);

        //flagView.setImageResource(departament.getFlagResource());
        addressView.setText(departament.getAddress());
        bank_typeView.setText(departament.getBank_type());
        if_it_readyView.setText(departament.getIf_it_ready());
        if (departament.getIf_it_ready().equals("Работает")) {
            if_it_readyView.setTextColor(parent.getContext().getResources().getColor(R.color.green));
            line.setBackgroundColor(parent.getContext().getResources().getColor(R.color.green));
        } else if (departament.getIf_it_ready().equals("Не работает")) {
            if_it_readyView.setTextColor(parent.getContext().getResources().getColor(R.color.red));
            line.setBackgroundColor(parent.getContext().getResources().getColor(R.color.red));
        }
        hours_in_worckView.setText(departament.getHours_in_worck());

        return view;
    }
}
