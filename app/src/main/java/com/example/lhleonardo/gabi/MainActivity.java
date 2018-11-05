package com.example.lhleonardo.gabi;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText txtQuantidade;
    private LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.linear = findViewById(R.id.linear);
        this.txtQuantidade = findViewById(R.id.txtQuantidade);
    }

    public void onClickCalcular(View v) {
        if (txtQuantidade.getText().toString().isEmpty()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Campos inválidos!");
            builder.setMessage("Informe a quantidade de elementos para continuar.");
            builder.show();
        } else {
            Integer quantidade = Integer.parseInt(this.txtQuantidade.getText().toString());

            this.linear.removeAllViews();

            for (int i = 0; i<quantidade; i++) {
                this.linear.addView(new EditText(this));
            }
        }

    }

    public void abrirTela(View v) {
        if (this.linear.getChildCount() != 0) {
            ArrayList<String> lista = new ArrayList<>();

            for(int i = 0; i < this.linear.getChildCount(); i++) {
                EditText elemento = (EditText) this.linear.getChildAt(i);
                lista.add(elemento.getText().toString());
            }

            Log.d("elementos", lista.toString());

            Intent intent = new Intent(this, MostrarListaActivity.class);
            intent.putExtra("elementos", lista);

            startActivity(intent);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Falha de execução");
            builder.setMessage("Sem itens preenchidos para enviar para próxima tela.");
            builder.show();
        }
    }
}
