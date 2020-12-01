package com.example.estudiosoapp23;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.example.estudiosoapp23.Classes.Questoes;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class QuestoesActivity extends TesteNavigationH {

    private DatabaseReference myRef;
    private FirebaseDatabase database;
    private BootstrapButton btRegistraQuestoes;
    private BootstrapEditText edQuestoesResolvidas, edQuestoesCorretas, edDataQuestoes;
    private Spinner spnMateriaQuestoes;
    private TextView txAproveitamento;
    double aproveitamento;
    private Questoes questoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questoes);
        navigationDrawerQuestoes();
        widgetsCadQuestoes();
        eventoClicQuestoes();
    }

    private void widgetsCadQuestoes(){

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        questoes = new Questoes();

        btRegistraQuestoes = (BootstrapButton)findViewById(R.id.btnAddQuestoes);

        edQuestoesResolvidas = (BootstrapEditText)findViewById(R.id.edtQtdeResolvidas);
        edQuestoesCorretas = (BootstrapEditText)findViewById(R.id.edtQtdeAcertos);
        edDataQuestoes = (BootstrapEditText)findViewById(R.id.edtDataQuestoes);

        spnMateriaQuestoes = (Spinner) findViewById(R.id.spnQuestoesMateria);

        txAproveitamento = (TextView)findViewById(R.id.txtAproveitamento);
    }

    private void eventoClicQuestoes(){

        btRegistraQuestoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //String texto = spnMateriaQuestoes.getSelectedItem().toString();
                //Toast.makeText(QuestoesActivity.this, "ué " +texto, Toast.LENGTH_SHORT).show();

                int resolvidas, acertos;

                resolvidas = Integer.parseInt(edQuestoesResolvidas.getText().toString());
                acertos = Integer.parseInt(edQuestoesCorretas.getText().toString());

                aproveitamento = (acertos*100)/resolvidas;

                if (aproveitamento >= 50) {
                    txAproveitamento.setTextColor(Color.BLUE);
                } else {
                    txAproveitamento.setTextColor(Color.RED);
                }
                txAproveitamento.setText("Aproveitamento de " + aproveitamento + "%");


                registrarQuestoes(spnMateriaQuestoes.getSelectedItem().toString(),
                        Integer.parseInt(edQuestoesResolvidas.getText().toString()),
                        Integer.parseInt(edQuestoesCorretas.getText().toString()),
                        edDataQuestoes.getText().toString());
            }
        });



    }

    private void registrarQuestoes(String materia, int resolvidas, int corretas, String data){
        String key = myRef.child("questoes").push().getKey();
        questoes.setMateria(materia);
        questoes.setResolvidas(resolvidas);
        questoes.setCorretas(corretas);
        questoes.setData(data);
        //questoes.setAproveitamento(aproveitamento);

        myRef.child("Questoes").child(materia).child(key).setValue(questoes);

        Toast.makeText(this, "Questões Registradas!",Toast.LENGTH_LONG).show();
    }
}
