package com.example.estudiosoapp23.Classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.estudiosoapp23.ConsCicloActivity;
import com.example.estudiosoapp23.R;
import com.example.estudiosoapp23.TesteRecyclerActivity;
import com.google.firebase.database.core.Context;

import java.util.List;

public class RecyclerVIewListaCiclo extends RecyclerView.Adapter<RecyclerVIewListaCiclo.ViewHolder> {

    private Context context;
    private List<Ciclo> ciclos;
    private ClickCiclo clickCiclo;

    public RecyclerVIewListaCiclo(Context context, List<Ciclo> ciclos, ClickCiclo clickCiclo){
        this.context = context;
        this.ciclos = ciclos;
        this.clickCiclo = clickCiclo;

    }

    public RecyclerVIewListaCiclo(android.content.Context baseContext, List<Ciclo> ciclos, ConsCicloActivity clickCiclo) {

    }

    public RecyclerVIewListaCiclo(android.content.Context baseContext, List<Ciclo> ciclos, TesteRecyclerActivity testeRecyclerActivity) {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.consulta_lista_ciclo_recycler,parent,false);
        ViewHolder holder = new ViewHolder(view);

        view.setTag(holder);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Ciclo ciclo = ciclos.get(position);
        holder.txMateriaCiclo.setText(ciclo.getMateria());
        holder.txSessaoCiclo.setText(ciclo.getId());
        holder.txInicioCiclo.setText(ciclo.getHoraInicio());
        holder.txFimCiclo.setText(ciclo.getHoraFinal());
        holder.txRealizado.setText(ciclo.getRealizado());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCiclo.click_Ciclo(ciclo);

            }
        });


    }

    @Override
    public int getItemCount() {
        return ciclos.size();
    }

    public interface ClickCiclo{
        void click_Ciclo(Ciclo ciclo);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        CheckBox cbStatusCiclo;
        TextView txMateriaCiclo, txSessaoCiclo, txInicioCiclo, txFimCiclo, txRealizado;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            cardView = (CardView)itemView.findViewById(R.id.cardViewListaCiclo);
            cbStatusCiclo = (CheckBox)itemView.findViewById(R.id.checkBoxStatusCiclo);
            //txMateriaCiclo = (TextView)itemView.findViewById(R.id.txtConsCiclo);
            txSessaoCiclo = (TextView)itemView.findViewById(R.id.txIdConsCiclo);
            txInicioCiclo = (TextView)itemView.findViewById(R.id.txtInicioConsCiclo);
            txFimCiclo = (TextView)itemView.findViewById(R.id.txtFinalConsCiclo);
            txRealizado = (TextView)itemView.findViewById(R.id.txtRealizadoConsCiclo);


            }
    }
}
