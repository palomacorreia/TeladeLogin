package com.example.paloma.teladelogin;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {
    private int cont=0;
    private int bloqueado = 0;
    private String senha_armazenada, login_armazanado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btLogin = (Button) findViewById(R.id.entrar);
        Button botaoCancelar = (Button) findViewById(R.id.sair);
        btLogin.setOnClickListener(this);
        botaoCancelar.setOnClickListener(this);




        SharedPreferences sharedpreferences;

        final EditText user = (EditText) findViewById(R.id.tLogin);
        final EditText password = (EditText) findViewById(R.id.tPassword);

    }


    @Override
    public void onClick(View view) {


        switch (view.getId()){
            case R.id.entrar:
                TextView  tLogin =(TextView) findViewById(R.id.tLogin);
                TextView  tPass =(TextView) findViewById(R.id.tPassword);
                String Login = tLogin.getText().toString();
                String Senha = tPass.getText().toString();

                cont++;
                //shared para o usuario
                SharedPreferences prefs1 = getSharedPreferences("usuario", Context.MODE_PRIVATE);
                SharedPreferences.Editor edUser = prefs1.edit ();

                //shared para o bloqueio
                SharedPreferences prefs2 = getSharedPreferences("bloquear", Context.MODE_PRIVATE);
                SharedPreferences.Editor edBlock = prefs2.edit ();

                //armazena os valores senha e login para serem inseridos no arquivo xml
                edUser.putString("senha" , "admin" );
                edUser.putString("login" , "admin" );
                //armazenamos a senha e o login com admin no banco
                edUser.apply();




                //se o usuario tiver 3 tentaivas erradas
                if(cont > 3){

                    //ativamos a variavel de bloqueio
                    edBlock.putInt("bloqueado" , 1 );
                    //armazenamos ela no arquivo
                    edBlock.apply();
                    //bloqueia o usuario
                    block();
                }


                //recuperamos o valor do arquivo
                bloqueado = (prefs2.getInt("bloqueado", 0));


                //se o valor for 1 é pq o usuario está bloqueado
                if(bloqueado == 1)
                {
                    block();

                }


                //caso não esteja bloqueado, recuperamos a senha e o login
                senha_armazenada = (prefs1.getString ("senha", ""));
                login_armazanado = (prefs1.getString ("login", ""));

                //se ele acertar a senha
                if( (Login.equals(login_armazanado) ) && (Senha.equals(senha_armazenada)))
            {
                //desativamos a variavel de bloqueio
                edBlock.putInt("bloqueado" , 0 );


                //armazenamos ela no arquivo
                edBlock.apply();

                //chama a nova tela depois de acertar a senha
                Intent it = new Intent(MainActivity.this, TelaPrincipal.class);
                startActivity(it);
            }else{
                    //se a pessoa errar

                        alert("Usuário/Senha incorreto");

                }

               break;
            case R.id.sair  :
                finish();  // sai da aplicação
                break;
        }


    }
    @Override
    protected void onResume() {
        if(getIntent().getBooleanExtra("SAIR", false)){
            finish();
        }
        super.onResume();
    }


    //----------------------------
    private void alert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    private void block() {

        new AlertDialog.Builder(this).setTitle("Aplicação Bloqueada").
                setMessage("Esta Aplicação foi Permanentemente Bloqueada por Excesso de Tentativas de Login").show();


    }
}

