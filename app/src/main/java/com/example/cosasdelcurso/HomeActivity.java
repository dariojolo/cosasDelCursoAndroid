package com.example.cosasdelcurso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ListView listView;
        final List<String> lista;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toast.makeText(this,"Test Toast", Toast.LENGTH_SHORT).show();
        Snackbar.make(getWindow().getDecorView().getRootView(), "Test snackbar", Snackbar.LENGTH_SHORT).show();

        //Conectamos el listview al componente visual
        listView = findViewById(R.id.lista);

        //cargamos lista de elementos
        lista = new ArrayList<>();
        lista.add("Elemento 1");
        lista.add("Elemento 2");
        lista.add("Elemento 3");
        lista.add("Elemento 4");
        lista.add("Elemento 5");
        lista.add("Elemento 6");
        lista.add("Elemento 7");
        lista.add("Elemento 8");
        lista.add("Elemento 9");

        //Creamos el adaptador  que transformara los elementos de la lista a elementos del listview
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, lista);


        //asociamos el adaptador al listview
        listView.setAdapter(adapter);

        //Agregar evento clik a los elementos de la lista
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String texto =  lista.get(position);
                Toast.makeText(getApplicationContext(), "Elemento clickeado: " + texto, Toast.LENGTH_SHORT).show();
            }
        });

/*      Codigo para obtener el valor de un parametro y mostrarlo en un Textview

        TextView txtSaludo = findViewById(R.id.txtSaludo);

        Bundle extas = getIntent().getExtras();
        String usuario = extas.getString("usuario");
        Intent intent = getIntent();
        String usuario2 = intent.getStringExtra("usuario");


        txtSaludo.setText("HOLA2 "  + usuario);*/



    }
}
