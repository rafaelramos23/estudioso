package com.example.estudiosoapp23;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.estudiosoapp23.Classes.Ciclo;
import com.example.estudiosoapp23.Classes.RecyclerVIewListaCiclo;

import java.util.ArrayList;
import java.util.List;

public class TesteRecyclerActivity extends AppCompatActivity implements RecyclerVIewListaCiclo.ClickCiclo  {

    private RecyclerView recyclerView;
    private RecyclerVIewListaCiclo recyclerViewListaCiclo;
    private Ciclo ciclo;
    private List<Ciclo> ciclos = new ArrayList<Ciclo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_recycler);

       // iniciarRecyclerView();
    }

    private void iniciarRecyclerView() {
        recyclerView = (RecyclerView)findViewById(R.id.recycler_ciclo_sessao);

        Ciclo ciclo1 = new Ciclo("Português","18:30","19:30","2","2:30");
        Ciclo ciclo2 = new Ciclo("Matemática","20:30","22:30","3","2:30");
        Ciclo ciclo3 = new Ciclo("Português","18:30","19:30","4","2:30");
        Ciclo ciclo4 = new Ciclo("Engenharia de Software II","18:30","19:30","5","2:30");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewListaCiclo = new RecyclerVIewListaCiclo(getBaseContext(),ciclos,this);

        recyclerView.setAdapter(recyclerViewListaCiclo);



    }

    @Override
    public void click_Ciclo(Ciclo ciclo) {

    }
}
