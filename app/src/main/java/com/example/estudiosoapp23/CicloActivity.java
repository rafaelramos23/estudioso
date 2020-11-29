package com.example.estudiosoapp23;

import android.os.Bundle;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapDropDown;
import com.beardedhen.androidbootstrap.BootstrapEditText;

public class CicloActivity extends TesteNavigationH {

    private BootstrapDropDown spnMateriaCiclo;
    private BootstrapEditText edPrevInicioCiclo, edPrevFinalCiclo;
    private BootstrapButton btAddMateriaCiclo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo);
        navigationDrawer();
    }

    private void carregaWidgetsCadCiclo(){
        edPrevFinalCiclo = (BootstrapEditText)findViewById(R.id.edtHoraFinalCiclo);
        edPrevInicioCiclo = (BootstrapEditText)findViewById(R.id.edtHoraInicialCro);

        btAddMateriaCiclo = (BootstrapButton)findViewById(R.id.btnAddMatCiclo);

        spnMateriaCiclo = (BootstrapDropDown)findViewById(R.id.spnMateriaCiclo);
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuaction, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.adicionar:
                Toast.makeText(getApplicationContext(),"você clicou na opção adicionar",
                        Toast.LENGTH_LONG).show();
                return (true);

        }
        return (super.onOptionsItemSelected(item));
    } */
}
