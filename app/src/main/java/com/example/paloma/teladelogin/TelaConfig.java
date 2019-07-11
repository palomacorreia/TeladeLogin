package com.example.paloma.teladelogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TelaConfig extends AppCompatActivity implements  View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_config);


        Button OK = (Button)findViewById(R.id.ok);
        Button BACK = (Button) findViewById(R.id.canc);
        OK.setOnClickListener(this);
        BACK.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ok:

                System.out.println("botar ok:");
                TextView tLogin =(TextView) findViewById(R.id.newuser);
                TextView  tPass =(TextView) findViewById(R.id.newpass);
                TextView  tConfirmPass =(TextView) findViewById(R.id.check);
                String Login = tLogin.getText().toString();
                String Senha = tPass.getText().toString();
                String Confirmarsenha =  tConfirmPass.getText().toString();
                System.out.println("to aqui fora");
                if(Senha.equals(Confirmarsenha))
                {
                    System.out.println("sou bonito");
                    //shared para o usuario
                    SharedPreferences prefs1 = getSharedPreferences("usuario", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edUser = prefs1.edit ();
                    System.out.println("funcia peste");
                    //armazena os valores senha e login para serem inseridos no arquivo xml
                    edUser.putString("senha" , Senha );
                    edUser.putString("login" , Login );
                    //armazenamos a senha e o login com admin no banco
                    edUser.apply();
                    Intent it = new Intent(TelaConfig .this, TelaPrincipal.class);
                    startActivity(it);

                }else
                {
                    alert("Senhas diferentes, por favor tente novamente.");
                    //limpa os campos da senha errada
                    tPass.setText("");
                    tPass.setText("");

                }


                break;
            case R.id.canc  :
                Intent tp = new Intent(TelaConfig .this, TelaPrincipal.class);
                startActivity(tp); //volta p tela principal
                break;
        }


    }

    private void alert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
}


