package com.example.cess.whatsappclone.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.SimpleAdapter;

import com.example.cess.whatsappclone.R;
import com.example.cess.whatsappclone.ValidatorActivity;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class LoginActivity extends AppCompatActivity {
    EditText telefoneNumber;
    EditText codPais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        telefoneNumber = (EditText)findViewById(R.id.login_telefoneNumber);
        SimpleMaskFormatter maskFormatterTelefone = new SimpleMaskFormatter("(NN) NNNNN-NNNN");
        MaskTextWatcher watcherTelefone = new MaskTextWatcher(telefoneNumber, maskFormatterTelefone);
        telefoneNumber.addTextChangedListener(watcherTelefone);

        codPais = (EditText)findViewById(R.id.login_codPais);
        SimpleMaskFormatter maskFormatterCodPais = new SimpleMaskFormatter("+NN");
        MaskTextWatcher watcherCodPais = new MaskTextWatcher(codPais, maskFormatterCodPais);
        codPais.addTextChangedListener(watcherCodPais);

    }

    void goToValidator(View v){
        startActivity(new Intent(this, ValidatorActivity.class));
    }
}
