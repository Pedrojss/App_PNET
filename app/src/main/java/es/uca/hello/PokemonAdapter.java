package es.uca.hello;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PokemonAdapter
        extends RecyclerView.Adapter<PokemonAdapter.MyViewHolder> {

    private ArrayList<Pokemon> pokemons;
    private Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView number;
        TextView name;
        Button show;
        public MyViewHolder(View v) {
            super(v);
            number = (TextView) v.findViewById(R.id.number);
            name = (TextView) v.findViewById(R.id.name);
            show = (Button) v.findViewById(R.id.show);
        }
    }

    public PokemonAdapter(ArrayList<Pokemon> myDataset) {
        pokemons = myDataset;
    }

    @Override
    public PokemonAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int
            viewType) {
        View v =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item,
                        parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        context = parent.getContext();
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.number.setText(String.valueOf(pokemons.get(position).getNumber()));
        holder.name.setText(pokemons.get(position).getName());
        holder.show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence text = "You've clicked on " +
                        pokemons.get(position).getName();
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }
}

