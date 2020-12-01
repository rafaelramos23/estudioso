package com.example.estudiosoapp23;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.beardedhen.androidbootstrap.BootstrapButton;

public class MainActivity extends AppCompatActivity {

    private BootstrapButton btCronograma, btCiclo, btLivre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carregaWidgets();
        eventoBotoes();

    }

    private void carregaWidgets(){
        btCronograma = (BootstrapButton)findViewById(R.id.btnCronograma);
        btCiclo = (BootstrapButton)findViewById(R.id.btnCiclo);
        btLivre = (BootstrapButton)findViewById(R.id.btnLivre);
    }

    private void eventoBotoes(){

        btCronograma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreTelaCronograma();
            }
        });

        btCiclo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreTelaCiclo();
            }
        });

        btLivre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreTelaSessao();
            }
        });
    }

    private void abreTelaCiclo(){
        Intent intent = new Intent(this, CicloActivity.class);
        //intent.putExtra("tela", "CadCiclo");
        startActivity(intent);
    }

    private void abreTelaCronograma(){
        Intent intent = new Intent(this, CronogramaActivity.class);
        //intent.putExtra("varTeste", teste);
        startActivity(intent);
    }
    private void abreTelaSessao(){
        Intent intent = new Intent(this, NovaSessaoActivity.class);
        //intent.putExtra("varTeste", teste);
        startActivity(intent);
    }
}
