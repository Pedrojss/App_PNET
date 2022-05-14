package es.uca.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre;
    private Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre = (EditText)findViewById(R.id.TxtNombre);
        btnAceptar = (Button) findViewById(R.id.BtnAceptar);
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