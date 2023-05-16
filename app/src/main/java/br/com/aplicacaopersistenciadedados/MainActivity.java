package br.com.aplicacaopersistenciadedados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declarar as variaveis
    EditText user, email;
    Button send;

    //Declarar o arquivo de preferência
    public static final String MyPREFERENCES = "arquivo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        send = (Button) findViewById(R.id.button);

        //Declaração da classe sharedpreferences
        SharedPreferences sharedPreferences = getSharedPreferences(MyPREFERENCES, 0);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Declaração de variaveis locais
                String usuariolocal = user.getText().toString();
                String emaillocal = email.getText().toString();

                //Declaração do editor - sharedpreferences no mode edição
                SharedPreferences.Editor editor = sharedPreferences.edit();

                //Fazer a persistência dos dados
                editor.putString("usuario", usuariolocal);
                editor.putString("email",emaillocal);

                //Confirmar a persistência
                editor.commit();

                //Nottificação no app
                Toast.makeText(MainActivity.this, "Dados Cadastrado com sucesso",Toast.LENGTH_LONG).show();

                //Limpar o formulario(global) para o próximo cadastro
                user.getText().clear();
                email.getText().clear();
                user.requestFocus();

            }
        });



    }




}