package com.example.lhleonardo.gabi;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

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
}
