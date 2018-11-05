package com.example.lhleonardo.gabi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MostrarListaActivity extends AppCompatActivity {

    private ArrayList<String> elementos;

    private ListView lista;

    private Button btnVoltar;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_lista);

        elementos = getIntent().getStringArrayListExtra("elementos");

        lista = findViewById(R.id.lista);
        btnVoltar = findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, elementos);

        lista.setAdapter(adapter);
    }
}
