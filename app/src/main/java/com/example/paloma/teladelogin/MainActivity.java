package com.example.paloma.teladelogin;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private int cont=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btLogin,btCancel;
        EditText user,pass;



        btLogin =(Button) findViewById(R.id.button);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView  tLogin =(TextView) findViewById(R.id.tLogin);
                TextView  tPass =(TextView) findViewById(R.id.tPassword);
                String Login = tLogin.getText().toString();
                String Senha = tPass.getText().toString();

                    cont++;



                if(Login.equals("admin")&& Senha.equals("admin")){
                    alert("Login Realizado com sucesso");


                            Intent it = new Intent(MainActivity.this, TelaPrincipal.class);
                            startActivity(it);


                }else {

                    alert("Usuário/Senha incorreto");

                    
                    if(cont > 3){
                       // alert("APLICAÇÃO BLOQUEADA!");
                        block();
                    }
                }

            }
        });
        // btCancel  = (Button) findViewById(R.id.button2);
    }
    private void  alert(String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }

    private void block() {

            new AlertDialog.Builder(this).setTitle("Aplicação Bloqueada").
                    setMessage("Esta Aplicação foi Permanentemente Bloqueada por Excesso de Tetantivas de Login").show();


        }
}
