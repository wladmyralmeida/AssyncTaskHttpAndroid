package com.meusprojetos.wlad.project.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.meusprojetos.wlad.project.R;
import com.meusprojetos.wlad.project.activity.ListarImoveisActivity;
import com.meusprojetos.wlad.project.model.Imovel;

import java.util.List;

public class ImovelAdapter extends RecyclerView.Adapter<ImovelAdapter.MyViewHolder> {

    //Criar construtor para receber a lista de tarefas que vem do main;
    private List<Imovel> listaImoveis;

    public ImovelAdapter(List<Imovel> list, ListarImoveisActivity listarImoveisActivity) {
        this.listaImoveis = list;
    }

    @NonNull
    @Override
    //Criar o layout para Retornar o item de lista para a MyViewHolder...View itemView;
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //retornar o LayoutTarefaAdapter
        View itemLista  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lista_imoveis_adapter, viewGroup, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Imovel imovel = listaImoveis.get(i);
        //utilizar o retorno do MyViewHolder juntamente com o item criado, tarefa e configura o texto;
        myViewHolder.tipoImovel.setText( imovel.getTipoImovel() );
        myViewHolder.tipoNegociacao.setText( imovel.getTipoNegociacao() );
        myViewHolder.valor.setText( String.valueOf(imovel.getValor()) );

    }

    @Override
    public int getItemCount() {
        return this.listaImoveis.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tipoImovel;
        TextView tipoNegociacao;
        TextView valor;

        public MyViewHolder(View itemView){
            super(itemView);

            //Recebe o item que recebeu como parâmetro e o utiliza no onBind;
            tipoImovel = itemView.findViewById(R.id.tipoImovel);
            tipoNegociacao = itemView.findViewById(R.id.tipoNegociacao);
            valor = itemView.findViewById(R.id.valor);

        }
    }
}
