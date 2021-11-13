package com.ruangciptateknologi.kinkouproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    EditText NamaIn,NoHpIn,AlamatIn,emailIn,passwordIn;
    Button BTNRegister;
    TextView Login;

    @Override
    protected void onCreate[Bundle savedInstanceState]{
            super.onCreate(savedInstanceState);
            setContentView(R.layout.layout_register);

        NamaIn = findViewById(R.id.NamaR);
        NoHpIn = findViewById(R.id.NoHp);
        AlamatIn = findViewById(R.id.AlamatR);
        emailIn = findViewById(R.id.email);
        passwordIn = findViewById(R.id.passwd);
        BTNRegister = findViewById(R.id.RegBTN);
        Login = findViewById(R.id.ToLogin);
        BTNRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Nama,Alamat,NomorHp,email,password;
                Nama = String.valueOf(NamaIn.getText());
                NomorHp = String.valueOf(NoHpIn.getText());
                Alamat = String.valueOf(AlamatIn.getText());
                email = String.valueOf(emailIn.getText());
                password = String.valueOf(passwordIn.getText());

                if (!Nama.equals("") && !NomorHp.equals("") && !Alamat.equals("") && !email.equals("")&& !password.equals("")){
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[5];
                            field[0] = "Nama";
                            field[1] = "Nomor_Hp";
                            field[2] = "Alamat";
                            field[3] = "email";
                            field[4] = "password";
                            String[] data = new String[5];
                            data[0] = "Nama";
                            data[1] = "Nomor_Hp";
                            data[2] = "Alamat";
                            data[3] = "email";
                            data[4] = "password";
                            PutData putData new PutData("http://192.168.1.5/androidDB/signup.php", "POST",field,data);
                            if (putData.startPut()){
                                if(putData.onComplete()){
                                    String result = putData.getResult();
                                    if(result.equals("Sign Up Success")){
                                        Intent intent = new Intent(getApplicationContext(),Login.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }

                        }
                    });
                }
                else {
                    Toast.makeText(getApplicationContext(),"All fields required",Toast.LENGTH_SHORT).show();
                }

            }
        });

        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                String[] field = new String[5];
                field[0] = "Nama";
                field[1] = "Nomor_Hp";
                field[2] = "Alamat";
                field[3] = "email";
                field[4] = "password";
                String[] data = new String[5];
                data[0] = "data 1";
                data[1] = "data 2";
                PutData putData new PutData("", POST);
                if (putData.startPut()){
                    if(putData.onComplete()){
                        String result = putData.getResult();
                    }
                }

            }
        });
    }
}
