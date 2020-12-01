package com.example.estudiosoapp23;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.example.estudiosoapp23.Classes.Materia;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MateriaActivity extends TesteNavigationH {

    private DatabaseReference myRef;
    private FirebaseDatabase database;
    private BootstrapEditText edNomeMateria, edTemaMateria, edTopicoMateria;
    private BootstrapButton btAddNovaMateria, btAddTema, btAddTopico;
    private Materia materia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia);
        navigationDrawerCadMateria();
        widgetsMateria();
        eventoBotoesMateria();
    }

    private void widgetsMateria(){

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        materia = new Materia();

        edNomeMateria = (BootstrapEditText)findViewById(R.id.edtNovaMateria);
        edTemaMateria = (BootstrapEditText)findViewById(R.id.edtTemaMateria);
        edTopicoMateria = (BootstrapEditText)findViewById(R.id.edtTopicoMateria);

        btAddNovaMateria = (BootstrapButton)findViewById(R.id.btnSalvarMateria);
        btAddTema = (BootstrapButton)findViewById(R.id.btnAddTema);
        btAddTopico = (BootstrapButton)findViewById(R.id.btnAddTopico);
    }

    private void eventoBotoesMateria(){

        btAddNovaMateria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarMateria(edNomeMateria.getText().toString());
            }
        });

        btAddTema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //myRef.setValue(edNomeMateria.getText().toString(), edTemaMateria.getText().toString());
            cadastrarTema(edNomeMateria.getText().toString(), edTemaMateria.getText().toString());
            }
        });

        btAddTopico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarTopico(edNomeMateria.getText().toString(), edTemaMateria.getText().toString(),
                        edTopicoMateria.getText().toString());
            }
        });

    }

    private void cadastrarMateria(String nomeMateria){

      //  String key = myRef.child("materia").push().getKey();
        materia.setNomeMateria(nomeMateria);
       // materia.setTema(tema);

        myRef.child("Materia").child(nomeMateria).setValue(materia);

        Toast.makeText(this, "Matéria Adicionada!",Toast.LENGTH_LONG).show();
    }

    private void cadastrarTema(String nomeMateria, String tema){
        materia.setTema(tema);
        myRef.child("Materia").child(nomeMateria).setValue(materia);

        Toast.makeText(this, "Tema Adicionada!",Toast.LENGTH_LONG).show();
    }

    private void cadastrarTopico(String nomeMateria, String tema, String topico){
        materia.setTopico(topico);
        myRef.child("Materia").child(tema).child(topico).setValue(materia);
        Toast.makeText(this, "Topico Adicionada!",Toast.LENGTH_LONG).show();
    }
}
