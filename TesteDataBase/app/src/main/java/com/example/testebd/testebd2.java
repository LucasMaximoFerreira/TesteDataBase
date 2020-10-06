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

public class testebd2 extends AppCompatActivity implements View.OnClickListener {

    EditText txtsenha;
    Button btncad2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testebd2);

        txtsenha = findViewById(R.id.txtsenha);
        btncad2 = findViewById(R.id.btncad2);
        btncad2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btncad2:
                conectarBD cad = new conectarBD(this);

                teste testeTela = new teste();
                testeTela.setSenha(txtsenha.getText().toString());
                testeTela.setNome(dadosEntreTela.getNomeTela());

                cad.setTesteClasse(testeTela);

                cad.execute(0);
                break;

        }
    }
}
