package com.meusprojetos.wlad.project.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.meusprojetos.wlad.project.R;
import com.meusprojetos.wlad.project.model.Imovel;
import com.meusprojetos.wlad.project.web.ExecuteTaskPost;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends DefaultActivity {

    private EditText campoTipoImovel;
    private EditText campoTipoNegociacao;
    private EditText campoObservacao;

    private TextInputEditText campoQtdSuite;
    private TextInputEditText campoQtdQuarto;
    private TextInputEditText campoQtdBanheiro;
    private TextInputEditText campoValor;
    private TextInputEditText campoArea;

    private CheckBox checkProprietario;
    private RadioButton radioDisponivel;
    private RadioButton radioOcupado;
    private RadioButton radioOutro;

    private Spinner spinnerCidade;

    private Imovel i;

    String URL = "http://192.168.0.200:8080/WebServiceProject/rest/imobilit/imovel";

    private List<Imovel> imoveis = new ArrayList<>();

    String[] cidades = {"Selecione", "Patos", "Campina Grande", "João Pessoa", "Cabedelo", "Cajazeiras", "Pombal", "Malta", "Quixaba"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoTipoImovel = findViewById(R.id.campoTipoImovel);
        campoTipoNegociacao = findViewById(R.id.campoTipoNegociacao);
        campoObservacao = findViewById(R.id.campoObs);

        campoQtdSuite = findViewById(R.id.campoSuite);
        campoQtdQuarto = findViewById(R.id.campoQuarto);
        campoQtdBanheiro = findViewById(R.id.campoBanheiro);
        campoValor = findViewById(R.id.campoValor);
        campoArea = findViewById(R.id.campoArea);

        checkProprietario = findViewById(R.id.checkProprietario);

        radioDisponivel = findViewById(R.id.radioDisponivel);
        radioOcupado = findViewById(R.id.radioOcupado);
        radioOutro = findViewById(R.id.radioOutro);

        spinnerCidade = findViewById(R.id.spinnerCidade);


        spinnerCidade.setAdapter(new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, cidades));

        /*botaoLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Cria o gerador do AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                //define o titulo
                builder.setTitle("Limpar");
                //define a mensagem
                builder.setMessage("Deseja realmente limpar?");
                //define um botão como positivo
                builder.setPositiveButton("Positivo", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        limpar();
                    }
                });
                //define um botão como negativo.
                builder.setNegativeButton("Negativo", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        imprimirMensagem("Cancelado");
                    }
                });
                //cria o AlertDialog
                alerta = builder.create();
                //Exibe
                alerta.show();
            }
        });*/
    }

    public Imovel salvarImovel() {

        //Recuperar textos dos campos
        String banheiro = campoQtdBanheiro.getText().toString();
        String quarto = campoQtdQuarto.getText().toString();
        String suite = campoQtdSuite.getText().toString();
        String tipoNegociacao = campoTipoNegociacao.getText().toString();
        String tipoImovel = campoTipoImovel.getText().toString();
        String obs = campoObservacao.getText().toString();
        String area = campoArea.getText().toString();
        String valor = campoValor.getText().toString();

        String proprietario = checkProprietario.getText().toString();
        String cidade = String.valueOf(spinnerCidade.getSelectedItemPosition());

        String ocupacao;
        if (radioDisponivel.isChecked()) {
            ocupacao = radioDisponivel.getText().toString();
        } else if (radioOcupado.isChecked()) {
            ocupacao = radioOcupado.getText().toString();
        } else {
            ocupacao = radioOutro.getText().toString();
        }

        if (!area.isEmpty()) {

            if (!quarto.isEmpty()) {

                if (!suite.isEmpty()) {

                    if (!banheiro.isEmpty()) {

                        if (!ocupacao.isEmpty()) {

                            if (!cidade.isEmpty()) {

                                if (!proprietario.isEmpty()) {

                                    if (!valor.isEmpty()) {

                                        if (!tipoImovel.isEmpty()) {

                                            if (!tipoNegociacao.isEmpty()) {

                                                if (!obs.isEmpty()) {

                                                    try {

                                                        i = new Imovel();

                                                        i.setObs(obs);
                                                        i.setTipoImovel(tipoImovel);
                                                        i.setTipoNegociacao(tipoNegociacao);
                                                        i.setValor(Double.parseDouble(valor));
                                                        i.setProprietario(proprietario);
                                                        i.setCidade(Integer.parseInt(cidade));
                                                        i.setOcupacao(ocupacao);
                                                        i.setQtdBanheiro(Integer.parseInt(banheiro));
                                                        i.setQtdSuite(Integer.parseInt(suite));
                                                        i.setQtdQuartos(Integer.parseInt(quarto));
                                                        i.setArea(Double.parseDouble(area));

                                                        new ExecuteTaskPost(MainActivity.this).execute(i);

                                                    } catch (Exception e) {
                                                        Log.e("Teste", Log.getStackTraceString(e));
                                                    }
                                                } else {
                                                    imprimirMensagem("Observação Vazia");
                                                }

                                            } else {
                                                imprimirMensagem("Tipo de Negociação inválido");
                                            }

                                        } else {
                                            imprimirMensagem("Tipo de Imóvel inválido");
                                        }

                                    } else {
                                        imprimirMensagem("Valor inválido");
                                    }
                                } else {
                                    imprimirMensagem("Quarto tem formato inválido");
                                }
                            } else {
                                imprimirMensagem("Cidade tem formato inválido");
                            }
                        } else {
                            imprimirMensagem("Ocupação tem formato inválido");
                        }
                    } else {
                        imprimirMensagem("Banheiro tem formato inválido");
                    }
                } else {
                    imprimirMensagem("Suíte tem formato inválido");
                }
            } else {
                imprimirMensagem("Quarto tem formato inválido");
            }
        } else {
            imprimirMensagem("Área tem formato inválido");
        }
        return i;
    }

    public void adicionarImovel(Imovel i) {
        imoveis.add(i);
        imprimirMensagem("Cadastrado com Sucesso");
        iniciarActivity(ListarImoveisActivity.class);
        limpar();
    }

    private void limpar() {

        campoTipoImovel.setText("");
        campoTipoNegociacao.setText("");
        campoObservacao.setText("");

        campoQtdSuite.setText("");
        campoQtdQuarto.setText("");
        campoQtdBanheiro.setText("");
        campoValor.setText("");
        campoArea.setText("");

        checkProprietario.setChecked(false);
        radioDisponivel.setChecked(false);
        radioOcupado.setChecked(false);
        radioOutro.setChecked(false);

        spinnerCidade.setSelection(0);
    }
}
