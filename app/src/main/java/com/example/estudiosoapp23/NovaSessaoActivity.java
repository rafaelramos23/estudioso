package com.example.estudiosoapp23;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.example.estudiosoapp23.Classes.Sessao;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NovaSessaoActivity extends TesteNavigationH {

    private DatabaseReference myRef;
    private FirebaseDatabase database;

    private BootstrapButton btIniciar, btParar, btSalvarSessao;
    private Spinner spnSessaoMateria, spnSessaoTema, spnSessaoTopico;
    private BootstrapEditText edDataSessao, edHoraEstudada;
    private TextView txManual, txCronometro;
    private Chronometer chronometro;
    private Switch swSessao, swRevisao, swQuestoes;
    private Sessao sessao;
    String tipoSessao;
    Boolean correr=false, RegQuestoes=false, AgeRevisao=false;
    long deter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_sessao);
        navigationDrawerCadSessao();
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

        btSalvarSessao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvaSessaoBD(spnSessaoMateria.getSelectedItem().toString(),
                        spnSessaoTema.getSelectedItem().toString(),
                        spnSessaoTema.getSelectedItem().toString(),
                        edDataSessao.getText().toString(),
                        edHoraEstudada.getText().toString());

                if (AgeRevisao) {
                    abreTelaRevisao();
                }
                    else
                        if (RegQuestoes){
                            abreTelaQuestoes();
                }
            }
        });

        swRevisao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    AgeRevisao=true;
                }
                else
                    AgeRevisao=false;
            }
            });

        swQuestoes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    RegQuestoes=true;
                }
                else
                    RegQuestoes=false;
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
                    tipoSessao= chronometro.getText().toString();
                }
                else{
                    chronometro.setVisibility(View.INVISIBLE);
                    btParar.setVisibility(View.INVISIBLE);
                    btIniciar.setVisibility(View.INVISIBLE);
                    edDataSessao.setVisibility(View.VISIBLE);
                    edHoraEstudada.setVisibility(View.VISIBLE);
                    txCronometro.setTextColor(Color.GRAY);
                    txManual.setTextColor(Color.BLUE);
                    tipoSessao=edHoraEstudada.getText().toString();
                }
            }
        });
    }

    private void carrregaWidgetsSessao(){

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        sessao = new Sessao();

        btIniciar = (BootstrapButton)findViewById(R.id.btnIniciarCro);
        btParar = (BootstrapButton)findViewById(R.id.btnPararCro);
        btSalvarSessao = (BootstrapButton)findViewById(R.id.btnSalvarSessao);

        swSessao = (Switch)findViewById(R.id.switchTipoSessao);
        swQuestoes = (Switch)findViewById(R.id.switchQuestoes);
        swRevisao = (Switch)findViewById(R.id.switchRevisao);

        spnSessaoMateria = (Spinner)findViewById(R.id.spnMateriaSessao);
        spnSessaoTema = (Spinner)findViewById(R.id.spnTemaSessao);
        spnSessaoTopico = (Spinner)findViewById(R.id.spnTopicoSessao);

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

    private void salvaSessaoBD(String materia, String tema, String topico, String data, String tempoEstudado){
        String key = myRef.child("sessao").push().getKey();

        sessao.setMateria(materia);
        sessao.setTema(tema);
        sessao.setTopico(topico);
        sessao.setData(data);
        sessao.setTempoEstudado(tempoEstudado);

        myRef.child("Sessao_Estudo").child(key).setValue(sessao);

        Toast.makeText(this, "Sessão Cadastrada!",Toast.LENGTH_LONG).show();
    }

    private void abreTelaRevisao(){
        Intent intent = new Intent(this, RevisoesActivity.class);
        if (RegQuestoes) {
            intent.putExtra("tela", "CadQuestoes");
        }
        startActivity(intent);
        finish();
    }

    private void abreTelaQuestoes(){
        Intent intent = new Intent(this, QuestoesActivity.class);
        startActivity(intent);
        finish();
    }

}
