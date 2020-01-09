package com.example.cosasdelcurso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class RecyclerViewActivity extends AppCompatActivity implements RestauranteFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
    }

    @Override
    public void onListFragmentInteraction(Restaurante item) {

    }
}
