package com.example.estudiosoapp23;

import android.os.Bundle;

public class CicloActivity extends TesteNavigationH {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo);
        navigationDrawer();
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
