package com.example.testebd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import dao.conectarBD;
import model.dadosEntreTela;
import model.teste;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtnome;
    Button btncad1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtnome = findViewById(R.id.txtnome);
        btncad1 = findViewById(R.id.btncad1);
        btncad1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btncad1:

                dadosEntreTela.setNomeTela(txtnome.getText().toString());


                Intent telaCad = new Intent(this, testebd2.class);
                startActivity(telaCad);
                break;


        }
    }
}
