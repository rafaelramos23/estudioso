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
                setContentView(R.layout.activity_cronograma);
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
                setContentView(R.layout.activity_nova_sessao);
            }
        });
    }

    private void abreTelaCiclo(){
        Intent intent = new Intent(this, CicloActivity.class);
        //intent.putExtra("varTeste", teste);
        startActivity(intent);
    }
}
