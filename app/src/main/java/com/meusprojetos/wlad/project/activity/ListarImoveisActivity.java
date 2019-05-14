package com.meusprojetos.wlad.project.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

import com.meusprojetos.wlad.project.R;
import com.meusprojetos.wlad.project.adapter.ImovelAdapter;
import com.meusprojetos.wlad.project.helper.RecyclerItemClickListener;
import com.meusprojetos.wlad.project.model.Imovel;
import com.meusprojetos.wlad.project.web.ExecuteTaskDelete;
import com.meusprojetos.wlad.project.web.ExecuteTaskGet;
import com.meusprojetos.wlad.project.web.ExecuteTaskPost;

import java.util.ArrayList;
import java.util.List;

public class ListarImoveisActivity extends DefaultActivity {

    private List<Imovel> imoveis = new ArrayList<>();
    private RecyclerView recyclerImoveis;
    private ImovelAdapter adapterImoveis;
    private AlertDialog dialog;
    private Imovel i = new Imovel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_imoveis);
        inicializarComponentes();

        //Conf recycler;
        recyclerImoveis.setLayoutManager(new LinearLayoutManager(this));
        recyclerImoveis.setHasFixedSize(true);
        adapterImoveis = new ImovelAdapter(imoveis, this);  //list imoveiss
        recyclerImoveis.setAdapter( adapterImoveis );

        //Recuperar Imóveis
        recuperarImoveis();


        //Add evento de click;
        recyclerImoveis.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerImoveis,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                //Recupera a tarefa para edição;
                                Imovel imovelSelecionado = imoveis.get(position);
                                imprimirMensagem("Vcoê selecionou o imóvel: " + imovelSelecionado);
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                                //Recuperar tarefa selecionada para deleção;
                                i = imoveis.get(position);

                                AlertDialog.Builder dialog = new AlertDialog.Builder(ListarImoveisActivity.this);
                                //Conf titulo e msg;
                                dialog.setTitle("Confirmar Exclusão");
                                dialog.setMessage("Deseja Excluir a tarefa: " + i.getTipoImovel() + "de número: " + i.getIdImovel() + "?");

                                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        new ExecuteTaskDelete(ListarImoveisActivity.this).execute(i);
                                    }
                                });

                                dialog.setNegativeButton("Não", null);

                                //Exibir Dialog;
                                dialog.create();
                                dialog.show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
    }

    private void recuperarImoveis() {
        new ExecuteTaskGet(ListarImoveisActivity.this).execute(i);
    }

    private void inicializarComponentes(){
        recyclerImoveis = findViewById(R.id.recyclerImoveis);
    }


    public void deletarImovel(Long idImovel) {

        if(i != null && i.getIdImovel().equals(idImovel)){
            imoveis.remove(i);
            imprimirMensagem("Deletado");
        }
        imprimirMensagem("Deleção falhou");
    }

    public void atualizarImovel(Imovel i) {
        imoveis.remove(i.getIdImovel());


        //
        //
        //        //

        imoveis.add(i);
        imprimirMensagem("Atualizado");
    }

}
