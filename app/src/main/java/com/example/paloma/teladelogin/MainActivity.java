package com.example.paloma.teladelogin;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
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
    private int bloqueado = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button btLogin,btCancel;
        //EditText user,pass;
        SharedPreferences sharedpreferences;

        final EditText user = (EditText) findViewById(R.id.tLogin);
        final EditText password = (EditText) findViewById(R.id.tPassword);

        Button btLogin =(Button) findViewById(R.id.button);



        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView  tLogin =(TextView) findViewById(R.id.tLogin);
                TextView  tPass =(TextView) findViewById(R.id.tPassword);
                String Login = tLogin.getText().toString();
                String Senha = tPass.getText().toString();

                cont++;
                SharedPreferences prefs = getSharedPreferences("usuario", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed = prefs.edit ();
                //ed.putString("user" , tLogin.getText().toString());
                //ed.putString("password" , tPass.getText().toString());
                //ed.putInt("contador" ,  cont );
                //ed.apply();

                //cont = (prefs.getInt("contador",0));
                //System.out.println("cont"+cont);
                
                if(cont > 3){
                    ed.putInt("bloqueado" , 1 );
                    ed.apply();
                    block();
                }

                bloqueado = (prefs.getInt("bloqueado",0));
                if(bloqueado == 1)
                {
                    block();
                }

//                if(Login.equals("admin")&& Senha.equals("admin")){
//                    alert("Login Realizado com sucesso");
//                }else {
//
//                    alert("Usuário/Senha incorreto22");
//
//
//                    if(cont > 3){
//                        alert("palhaçada2");
//                        block();
//                    }
//                }



            }
        });
        // btCancel  = (Button) findViewById(R.id.button2);
    }


    private void  alert(String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }

    private void block() {

            new AlertDialog.Builder(this).setTitle("Aplicação Bloqueada").
                    setMessage("Esta Aplicação foi Permanentemente Bloqueada por Excesso de Tentativas de Login").show();

    }
}
