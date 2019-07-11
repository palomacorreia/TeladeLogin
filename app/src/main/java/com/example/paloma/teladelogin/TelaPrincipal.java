package com.example.paloma.teladelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaPrincipal extends AppCompatActivity  implements  View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        Button btConfig = (Button)findViewById(R.id.buttonconfig);
        Button botaoCancel = (Button) findViewById(R.id.buttoncancel);
        btConfig.setOnClickListener(this);
        botaoCancel.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonconfig:
                Intent it = new Intent(TelaPrincipal.this, TelaConfig.class);
                startActivity(it);
                break;
            case R.id.buttoncancel  :
                finish();  // sai da aplicação
                break;
        }


    }


}
