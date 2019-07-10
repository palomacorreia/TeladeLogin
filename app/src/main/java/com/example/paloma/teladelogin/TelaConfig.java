package com.example.paloma.teladelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaConfig extends AppCompatActivity {
    Button btconfig = (Button) findViewById(R.id.buttonconfig);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_config);


        btconfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(TelaConfig.this, TelaPrincipal.class);
                startActivity(it);
            }
        });

    }
}


