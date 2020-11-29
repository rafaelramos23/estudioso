package com.example.estudiosoapp23;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapDropDown;
import com.beardedhen.androidbootstrap.BootstrapEditText;

public class NovaSessaoActivity extends AppCompatActivity {

    private BootstrapButton btIniciar, btParar, btSalvarSessao;
    private BootstrapDropDown spnSessaoMateria, spnSessaoTema, spnSessaoTopico;
    private BootstrapEditText edDataSessao, edHoraEstudada;
    private TextView txManual, txCronometro;
    private Chronometer chronometro;
    private Switch swSessao, swRevisao, swQuestoes;
    Boolean correr=false;
    long deter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_sessao);
        carrregaWidgetsSessao();
        eventoSessao();
    }

    private void eventoSessao() {

        btIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCronometro();
            }
        });

        btParar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pararCronometro();
            }
        });

        swSessao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // do something, the isChecked will be
                // true if the switch is in the On position
                if (isChecked){
                    chronometro.setVisibility(View.VISIBLE);
                    btParar.setVisibility(View.VISIBLE);
                    btIniciar.setVisibility(View.VISIBLE);
                    edDataSessao.setVisibility(View.INVISIBLE);
                    edHoraEstudada.setVisibility(View.INVISIBLE);
                    txCronometro.setTextColor(Color.BLUE);
                    txManual.setTextColor(Color.GRAY);
                }
                else{
                    chronometro.setVisibility(View.INVISIBLE);
                    btParar.setVisibility(View.INVISIBLE);
                    btIniciar.setVisibility(View.INVISIBLE);
                    edDataSessao.setVisibility(View.VISIBLE);
                    edHoraEstudada.setVisibility(View.VISIBLE);
                    txCronometro.setTextColor(Color.GRAY);
                    txManual.setTextColor(Color.BLUE);

                }
            }
        });
    }

    private void carrregaWidgetsSessao(){
        btIniciar = (BootstrapButton)findViewById(R.id.btnIniciarCro);
        btParar = (BootstrapButton)findViewById(R.id.btnPararCro);
        btSalvarSessao = (BootstrapButton)findViewById(R.id.btnSalvarSessao);

        swSessao = (Switch)findViewById(R.id.switchTipoSessao);
        swQuestoes = (Switch)findViewById(R.id.switchQuestoes);
        swRevisao = (Switch)findViewById(R.id.switchRevisao);

        spnSessaoMateria = (BootstrapDropDown) findViewById(R.id.spnMateriaSessao);
        spnSessaoTema = (BootstrapDropDown) findViewById(R.id.spnTemaSessao);
        spnSessaoTopico = (BootstrapDropDown) findViewById(R.id.spnTopicoSessao);

        edDataSessao = (BootstrapEditText)findViewById(R.id.edtDataSessao);
        edHoraEstudada = (BootstrapEditText) findViewById(R.id.edtHoraEstudada);

        txManual = (TextView) findViewById(R.id.txtManual);
        txCronometro = (TextView) findViewById(R.id.txtCronometro);

        chronometro = (Chronometer)findViewById(R.id.cronometro);

        btParar.setVisibility(View.INVISIBLE);
        btIniciar.setVisibility(View.INVISIBLE);
    }

    private void startCronometro(){
        if (!correr){
            chronometro.setBase(SystemClock.elapsedRealtime()-deter);
            chronometro.start();
            correr=true;
        }
    }

    private void pararCronometro(){
        if (correr){
            chronometro.stop();
            deter = SystemClock.elapsedRealtime() - chronometro.getBase();
            correr=false;
        }
    }

}
