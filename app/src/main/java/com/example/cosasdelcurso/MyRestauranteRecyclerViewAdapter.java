package com.example.cosasdelcurso;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.cosasdelcurso.RestauranteFragment.OnListFragmentInteractionListener;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Restaurante} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyRestauranteRecyclerViewAdapter extends RecyclerView.Adapter<MyRestauranteRecyclerViewAdapter.ViewHolder> {

    private final List<Restaurante> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyRestauranteRecyclerViewAdapter(List<Restaurante> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_restaurante, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.txtNombre.setText(mValues.get(position).getNombre());
        holder.txtDireccion.setText(mValues.get(position).getDireccion());
        Picasso.get()
                .load(mValues.get(position).getUrlFoto())
                .resize(400,150)
                .centerCrop()
                .into(holder.imgFoto);
        holder.valoracion.setRating(mValues.get(position).getValoracion());


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView txtNombre;
        public final TextView txtDireccion;
        public final ImageView imgFoto;
        public final RatingBar valoracion;

        public Restaurante mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            txtNombre = view.findViewById(R.id.txtNombre);
            txtDireccion = view.findViewById(R.id.txtDireccionRestaurant);
            imgFoto = view.findViewById(R.id.imgFoto);
            valoracion = view.findViewById(R.id.ratingBar);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + txtNombre.getText() + "'";
        }
    }
}
