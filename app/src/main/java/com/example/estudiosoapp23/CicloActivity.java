package com.example.estudiosoapp23;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.example.estudiosoapp23.Classes.Ciclo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CicloActivity extends TesteNavigationH {

    private DatabaseReference myRef;
    private FirebaseDatabase database;

    private Spinner spnMateriaCiclo;
    private BootstrapEditText edPrevInicioCiclo, edPrevFinalCiclo;
    private BootstrapButton btAddMateriaCiclo;
    private Ciclo ciclo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo);

        navigationDrawer();
        carregaWidgetsCadCiclo();
        eventoClicCiclo();
    }

    private void carregaWidgetsCadCiclo(){

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        ciclo = new Ciclo();

        edPrevFinalCiclo = (BootstrapEditText)findViewById(R.id.edtHoraFinalCiclo);
        edPrevInicioCiclo = (BootstrapEditText)findViewById(R.id.edtHoraInicialCiclo);

        btAddMateriaCiclo = (BootstrapButton)findViewById(R.id.btnAddMatCiclo);

        spnMateriaCiclo = (Spinner)findViewById(R.id.spnMateriaCiclo);
    }

    private void eventoClicCiclo() {
        btAddMateriaCiclo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastraSessaoCiclo(spnMateriaCiclo.getSelectedItem().toString(),
                        edPrevInicioCiclo.getText().toString(),
                        edPrevFinalCiclo.getText().toString());
            }
        });
    }

    public void cadastraSessaoCiclo(String materia, String horaInicio, String horaFinal){
        String key = myRef.child("ciclo").push().getKey();

        ciclo.setMateria(materia);
        ciclo.setHoraInicio(horaInicio);
        ciclo.setHoraFinal(horaFinal);

        myRef.child("Ciclo").child(key).setValue(ciclo);

        Toast.makeText(this, "Sessão Cadastrada!",Toast.LENGTH_LONG).show();
    }
}
