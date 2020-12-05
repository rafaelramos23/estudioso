package com.example.estudiosoapp23;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.beardedhen.androidbootstrap.BootstrapButton;

public class ConsCronogramaActivity extends TesteNavigationH {
    private BootstrapButton btEditCro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cons_cronograma);

        navigationDrawerConsCronograma();
        widgestsCronogramaCons();
        eventoClicCroEdit();
    }

    private void widgestsCronogramaCons() {
        btEditCro = (BootstrapButton)findViewById(R.id.btnEditCro);
    }

    private void eventoClicCroEdit(){
        btEditCro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreTelaCro();
            }
        });
    }

    private void abreTelaCro() {
        Intent intent = new Intent(this, CronogramaActivity.class);
        startActivity(intent);
    }
}
