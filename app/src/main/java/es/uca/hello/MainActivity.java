package es.uca.hello;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre;
    private TextView miTexto;
    private Button btnAceptar;
    private Button btnBoton1;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referenciamos al RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // Mejoramos rendimiento con esta configuración
        mRecyclerView.setHasFixedSize(true);
        // Creamos un LinearLayoutManager para gestionar el item.xml creado antes
        mLayoutManager = new LinearLayoutManager(this);
        // Lo asociamos al RecyclerView
        mRecyclerView.setLayoutManager(mLayoutManager);
        // Creamos un ArrayList de Pokemons
        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
        // Creamos un PokemonAdapter pasándole todos nuestro Pokemons
        mAdapter = new PokemonAdapter(pokemons);
        // Asociamos el adaptador al RecyclerView
        mRecyclerView.setAdapter(mAdapter);

        pokemons.add(new Pokemon(1,
                "Bulbasaur"));
        pokemons.add(new Pokemon(2,
                "Ivysaur"));
        pokemons.add(new Pokemon(3,
                "Venusaur"));
        pokemons.add(new Pokemon(4,
                "Charmander"));
        pokemons.add(new Pokemon(5,
                "Charmeleon"));
        pokemons.add(new Pokemon(6,
                "Charizard"));
        pokemons.add(new Pokemon(7,
                "Squirtle"));
        pokemons.add(new Pokemon(8,
                "Wartortle"));
        pokemons.add(new Pokemon(9,
                "Blastoise"));

        txtNombre = (EditText)findViewById(R.id.TxtNombre);
        btnAceptar = (Button)findViewById(R.id.BtnAceptar);
        btnBoton1 = (Button)findViewById(R.id.BtnPrueba);
        miTexto = (TextView)findViewById(R.id.txtPrueba);

        btnBoton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String texto = txtNombre.getText().toString();
                miTexto.setText(texto);
            }
        });

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent = new Intent(MainActivity.this,
                        SaludoActivity.class);
                //Creamos la información a pasar entre actividades
                Bundle b = new Bundle();
                b.putString("NOMBRE", txtNombre.getText().toString());
                //Añadimos la información al intent
                intent.putExtras(b);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });


    }
}