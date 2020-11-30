package com.example.estudiosoapp23;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapDropDown;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.example.estudiosoapp23.Classes.Revisoes;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class RevisoesActivity extends AppCompatActivity {

    private DatabaseReference myRef;
    private FirebaseDatabase database;

    private BootstrapDropDown spnMateriaRevisao;
    private BootstrapEditText edDataRev, edRevDescricao;
    private BootstrapButton btAgendaRev;
    private CheckBox ckbdia1, ckbdia7, ckbdia15, ckbdia30, ckbdia60, ckbdia90;
    private Revisoes revisao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revisoes);
        widgetsCadRevisoes();
    }

    private void widgetsCadRevisoes(){

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        revisao = new Revisoes();

        spnMateriaRevisao = (BootstrapDropDown)findViewById(R.id.spnRevisaoMateria);

        edDataRev = (BootstrapEditText)findViewById(R.id.edtDataRevisao);
        edRevDescricao = (BootstrapEditText)findViewById(R.id.edtObservacoesRev);

        btAgendaRev = (BootstrapButton)findViewById(R.id.btnAddRevisao);

        ckbdia1 = (CheckBox)findViewById(R.id.checb1Dia);
        ckbdia7 = (CheckBox)findViewById(R.id.checb7Dias);
        ckbdia15 = (CheckBox)findViewById(R.id.checb15Dias);
        ckbdia30 = (CheckBox)findViewById(R.id.checb30Dias);
        ckbdia60= (CheckBox)findViewById(R.id.checb60Dia);
        ckbdia90= (CheckBox)findViewById(R.id.checb90Dia);

    }

    private void eventoClicRevisao(){
        btAgendaRev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //agendaRevisao(spnMateriaRevisao.getSelectedItem(),
                //        edDataRev.getText().toString(), edRevDescricao.getText().toString());
            }
        });
    }

    private void agendaRevisao(String materia, Date data, String descricao){
        String key = myRef.child("questoes").push().getKey();

        revisao.setMateria(materia);
        revisao.setData(data);
        revisao.setDescricao(descricao);


        myRef.child("Revisoes").child(materia).child(key).setValue(revisao);

        Toast.makeText(this, "Revisão Agendada!",Toast.LENGTH_LONG).show();

    }
}
