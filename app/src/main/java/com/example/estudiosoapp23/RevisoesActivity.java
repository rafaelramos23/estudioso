package com.example.estudiosoapp23;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.example.estudiosoapp23.Classes.Revisoes;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RevisoesActivity extends TesteNavigationH {

    private DatabaseReference myRef;
    private FirebaseDatabase database;

    private Spinner spnMateriaRevisao;
    private BootstrapEditText edDataRev, edRevDescricao;
    private BootstrapButton btAgendaRev;
    private CheckBox ckbdia1, ckbdia7, ckbdia15, ckbdia30, ckbdia60, ckbdia90;
    private Revisoes revisao;
    String questoes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revisoes);
        widgetsCadRevisoes();
        navigationDrawerRevisoes();
        eventoClicRevisao();
    }

    private void widgetsCadRevisoes(){

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        revisao = new Revisoes();

        spnMateriaRevisao = (Spinner) findViewById(R.id.spnRevisaoMateria);

        edDataRev = (BootstrapEditText)findViewById(R.id.edtDataRevisao);
        edRevDescricao = (BootstrapEditText)findViewById(R.id.edtObservacoesRev);

        btAgendaRev = (BootstrapButton)findViewById(R.id.btnAddRevisao);

        ckbdia1 = (CheckBox)findViewById(R.id.checb1Dia);
        ckbdia7 = (CheckBox)findViewById(R.id.checb7Dias);
        ckbdia15 = (CheckBox)findViewById(R.id.checb15Dias);
        ckbdia30 = (CheckBox)findViewById(R.id.checb30Dias);
        ckbdia60= (CheckBox)findViewById(R.id.checb60Dia);
        ckbdia90= (CheckBox)findViewById(R.id.checb90Dia);

        Intent pegaValor = getIntent();
        if (pegaValor!=null){
            String valor = pegaValor.getStringExtra("tela");
            questoes=valor;
            Toast.makeText(this, "Existem Questões para registrar", Toast.LENGTH_SHORT).show();
            }

    }

    private void eventoClicRevisao(){
        btAgendaRev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                agendaRevisao(spnMateriaRevisao.getSelectedItem().toString(),
                       edDataRev.getText().toString(), edRevDescricao.getText().toString());

                if (questoes!=null){
                    abreTelaQuestoes();
                }
            }
        });
    }

    private void agendaRevisao(String materia, String data, String descricao){
        String key = myRef.child("revisao").push().getKey();

        revisao.setMateria(materia);
        revisao.setData(data);
        revisao.setDescricao(descricao);


        myRef.child("Revisoes").child(materia).child(key).setValue(revisao);

        Toast.makeText(this, "Revisão Agendada!",Toast.LENGTH_LONG).show();

    }

    private void abreTelaQuestoes(){
        Intent intent = new Intent(this, QuestoesActivity.class);
        //intent.putExtra("tela","CadQuestoes");
        startActivity(intent);
        finish();
    }
}
