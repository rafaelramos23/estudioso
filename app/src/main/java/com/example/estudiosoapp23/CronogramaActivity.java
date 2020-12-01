package com.example.estudiosoapp23;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.example.estudiosoapp23.Classes.Cronograma;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CronogramaActivity extends TesteNavigationH {

    private DatabaseReference myRef;
    private FirebaseDatabase database;

    private BootstrapButton btAddCronograma;
    private BootstrapEditText edHoraInicioCro, edHoraFinalCro;
    private Spinner spnDiaSemana, spnMateriaCro;
    private Cronograma cronograma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronograma);

        navigationDrawerCadCronograma();
        widgetsCadCrono();
        eventoClicCadCrono();
    }

    private void widgetsCadCrono() {

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        cronograma = new Cronograma();

        edHoraInicioCro = (BootstrapEditText)findViewById(R.id.edtHoraInicialCro);
        edHoraFinalCro = (BootstrapEditText)findViewById(R.id.edtHoraFinalCro);

        spnDiaSemana = (Spinner)findViewById(R.id.spnDiaSemana);
        spnMateriaCro = (Spinner)findViewById(R.id.spnMateriaCro);

        btAddCronograma = (BootstrapButton)findViewById(R.id.btnAddMatCronograma);
    }

    private void eventoClicCadCrono(){

        btAddCronograma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionaMatCronograma(spnDiaSemana.getSelectedItem().toString(),
                        spnMateriaCro.getSelectedItem().toString(),
                        edHoraInicioCro.getText().toString(),
                        edHoraFinalCro.getText().toString());
            }
        });
    }

    private void adicionaMatCronograma(String diaSemana, String materia, String horaInicio, String horaFinal){
        String key = myRef.child("cronograma").push().getKey();

        cronograma.setDiaSemana(diaSemana);
        cronograma.setMateria(materia);
        cronograma.setHoraInicio(horaInicio);
        cronograma.setHoraFinal(horaFinal);

        myRef.child("Cronograma").child(diaSemana).child(key).setValue(cronograma);

        Toast.makeText(this, "Sessão Cadastrada!",Toast.LENGTH_LONG).show();
    }


}
