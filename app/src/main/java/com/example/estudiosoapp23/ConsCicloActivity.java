package com.example.estudiosoapp23;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.example.estudiosoapp23.Classes.Ciclo;
import com.example.estudiosoapp23.Classes.RecyclerVIewListaCiclo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ConsCicloActivity extends TesteNavigationH implements RecyclerVIewListaCiclo.ClickCiclo {

    private RecyclerView recyclerView;
    private DatabaseReference myRef;
    private FirebaseDatabase database;
    private Ciclo ciclo;
    private RecyclerVIewListaCiclo recyclerViewListaCiclo;
    private List<Ciclo> ciclos = new ArrayList<Ciclo>();
    private BootstrapButton btEditCiclo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cons_ciclo);

        navigationDrawerConsCiclo();
        widgetsConsCiclo();
        eventoClicConsCiclo();
       // iniciarRecyclerView();
    }

    private void eventoClicConsCiclo() {
        btEditCiclo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreTelaCicloEdit();
            }
        });
    }

    private void iniciarRecyclerView() {

        Ciclo ciclo1 = new Ciclo("Português","18:30","19:30","2","2:30");
        Ciclo ciclo2 = new Ciclo("Matemática","20:30","22:30","3","2:30");
        Ciclo ciclo3 = new Ciclo("Português","18:30","19:30","4","2:30");
        Ciclo ciclo4 = new Ciclo("Engenharia de Software II","18:30","19:30","5","2:30");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewListaCiclo = new RecyclerVIewListaCiclo(getBaseContext(),ciclos,this);

        recyclerView.setAdapter(recyclerViewListaCiclo);



    }

    public void abreTelaCicloEdit(){
        Intent intent = new Intent(this, CicloActivity.class);
        //intent.putExtra("tela", "ConsCiclo");
        startActivity(intent);
    }

    private void widgetsConsCiclo() {

        recyclerView = (RecyclerView)findViewById(R.id.recycler_ciclo_sessao);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        ciclo = new Ciclo();

        btEditCiclo = (BootstrapButton)findViewById(R.id.btnEditCiclo);
    }

    @Override
    public void click_Ciclo(Ciclo ciclo) {

    }
}
