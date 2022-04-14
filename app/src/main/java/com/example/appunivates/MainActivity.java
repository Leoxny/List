package com.example.appunivates;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.appunivates.adapter.LinguagemAdapter;
import com.example.appunivates.models.Linguagem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button bntSalvar;
    EditText txtNome;
    ListView ltvLista;
    EditText txtDescricao;

    ArrayList<Linguagem> listagem;
    LinguagemAdapter adapter;

    Context context;

    Linguagem objeto;
    Linguagem descricao;
    Linguagem id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNome = findViewById(R.id.txtNome_listagem);
        ltvLista = findViewById(R.id.ltvLista_Linguagem);
        bntSalvar = findViewById(R.id.btnsalvar_liguagem);
        txtDescricao = findViewById(R.id.txtDescricao_listagem);

        context = MainActivity.this;

        listagem = new ArrayList<>();

        bntSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome = txtNome.getText().toString().trim();
                String descricao = txtDescricao.getText().toString().trim();

                if (!nome.equals(""))

                    objeto = new Linguagem();
                    objeto.setId(1);
                    objeto.setNome(nome);
                    objeto.setDescricao(descricao);

                    listagem.add(objeto);

                    adapter = new LinguagemAdapter(context,listagem);

                    ltvLista.setAdapter(adapter);
                    txtDescricao.setText("");
                    txtNome.setText("");
                    txtNome.requestFocus();

            }
        });
    }
}