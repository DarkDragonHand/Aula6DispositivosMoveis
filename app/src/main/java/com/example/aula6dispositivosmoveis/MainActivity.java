package com.example.aula6dispositivosmoveis;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private String[] nomeCores = {"Preto", "Roxo", "Amarelo", "Vermelho", "Verde", "Azul"};
    private String[] cores = {"#000000","#993399", "#FFFF00", "#FF0000", "#00FF00", "#0000FF"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinnerCores);
        ArrayAdapter adapter = new MinhaArrayAdapter(this, android.R.layout.simple_spinner_item, nomeCores);
        spinner.setAdapter(adapter);
    }

    public void aula6Ex1(View view) {
        startActivity(new Intent(this, Aula6Ex1.class));
    }

    public void aula6Ex2(View view) {
        startActivity(new Intent(this, Aula6Ex2.class));
    }

    private class MinhaArrayAdapter extends ArrayAdapter {

        int resources;

        public MinhaArrayAdapter(Context ctx, int item, String[] nomeCores) {
            super(ctx, item, nomeCores);
            resources = item;
        }

        private View CustomView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(resources, parent, false);

            TextView textView = view.findViewById(android.R.id.text1);
            textView.setText(nomeCores[position]);
            textView.setTextColor(Color.WHITE);
            view.setBackgroundColor(Color.parseColor(cores[position]));

            return view;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return CustomView(position, convertView, parent);
        }

        @Override
        public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return CustomView(position, convertView, parent);
        }
    }
}