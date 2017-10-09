package com.example.cess.whatsappclone.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cess.whatsappclone.R;
import com.example.cess.whatsappclone.helper.Preferencias;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.util.HashMap;
import java.util.Random;

public class LoginActivity extends AppCompatActivity {
    EditText et_telefoneNumber;
    EditText et_codPais;
    EditText et_nome;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_nome = (EditText)findViewById(R.id.login_name);

        et_telefoneNumber = (EditText)findViewById(R.id.login_telefoneNumber);
        SimpleMaskFormatter maskFormatterTelefone = new SimpleMaskFormatter("(NN) NNNNN-NNNN");
        MaskTextWatcher watcherTelefone = new MaskTextWatcher(et_telefoneNumber, maskFormatterTelefone);
        et_telefoneNumber.addTextChangedListener(watcherTelefone);

        et_codPais = (EditText)findViewById(R.id.login_codPais);
        SimpleMaskFormatter maskFormatterCodPais = new SimpleMaskFormatter("+NN");
        MaskTextWatcher watcherCodPais = new MaskTextWatcher(et_codPais, maskFormatterCodPais);
        et_codPais.addTextChangedListener(watcherCodPais);

        btn_login = (Button)findViewById(R.id.login_btn);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = et_nome.getText().toString();
                String codPais = et_codPais.getText().toString();
                String telefone = et_telefoneNumber.getText().toString();
                String telefoneCompleto = codPais+telefone;

                telefoneCompleto = telefoneCompleto.replace("+","");
                telefoneCompleto = telefoneCompleto.replace("-","");
                telefoneCompleto = telefoneCompleto.replace("(","");
                telefoneCompleto = telefoneCompleto.replace(")","");
                telefoneCompleto = telefoneCompleto.replace(" ","");
//                Log.i("Telefone", "Tel: "+telefoneCompleto);
                Random random = new Random();
                int numeroAleatorio = random.nextInt(9999-1000)+1000;
                String token = String.valueOf(numeroAleatorio);

                Preferencias preferencias = new Preferencias(getApplicationContext());
                preferencias.salvaUsuarioPreferencias(nome, telefoneCompleto, token);

                HashMap<String , String >dadosUsuario = preferencias.getDadosUsuario();
                Log.i("Telefone", "Tel: "+dadosUsuario.get("telefone"));

            }
        });

    }

//    void goToValidator(View v){
//        startActivity(new Intent(this, ValidatorActivity.class));
//    }
}
