package com.example.cosasdelcurso;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class RestauranteFragment extends Fragment {

    MyRestauranteRecyclerViewAdapter adapterRestaurantes;
    // TODO: Customize parameters
    private int mColumnCount = 1;

    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RestauranteFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurante_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            //Lista personalizada de elementos Restaurantes

            List<Restaurante> restaurantes = new ArrayList<Restaurante>();
            restaurantes.add(new Restaurante("Pizzeria Carlos", "https://pizzeriamisko.hr/wp-content/uploads/2019/09/pizzeria_misko_logo_mob_light.png", 4.0f,"Madrid, España" ));
            restaurantes.add(new Restaurante("Hamburgueseria rapida", "https://pizzeriamisko.hr/wp-content/uploads/2019/09/pizzeria_misko_logo_mob_light.png", 3.1f,"Mexico DF, Mexico" ));
            restaurantes.add(new Restaurante("Parrilla casera", "https://pizzeriamisko.hr/wp-content/uploads/2019/09/pizzeria_misko_logo_mob_light.png", 3.7f,"Buenos Aires, Argentina" ));
            adapterRestaurantes = new MyRestauranteRecyclerViewAdapter(restaurantes, mListener);
            recyclerView.setAdapter(adapterRestaurantes);
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Restaurante item);
    }
}
