package com.example.cosasdelcurso;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.View;

public class FragmentActivity extends AppCompatActivity {

    Boolean modoDia = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Carga del Fragmento por defecto
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contenedor, new ModoDiaFragment())
                .commit();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = null;

                if (modoDia)
                    fragment = new ModoNocheFragment();
                else
                    fragment = new ModoDiaFragment();

                modoDia = !modoDia;

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contenedor, fragment)
                        .commit();

            }
        });
    }

}
