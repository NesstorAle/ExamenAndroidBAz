package com.baz.examenandroidbaz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText editTextPassword, editTextUser;
    Button buttonLogin;
    private FirebaseAuth firebaseAuth;
    Toast t;
    ProgressDialog progressDialog;
    String email, password;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialize();

    }


    private void initialize() {
        editTextUser = findViewById(R.id.activity_login_etEmail);
        editTextPassword = findViewById(R.id.activity_login_etPassword);
        buttonLogin = findViewById(R.id.activity_login_login_button);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
    }


    public void login(View view) {
        email = editTextUser.getText().toString();
        password = editTextPassword.getText().toString();

        if (validateData()) {
            progressDialog.setMessage("iniciando sesion");
            progressDialog.show();
            firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                                showToast("Bienvenido");
                            } else {
                                showToast("Credenciales incorrectas");
                            }
                            progressDialog.dismiss();
                        }
                    });
        }
    }

    private boolean validateData() {
        if (TextUtils.isEmpty(email)) {
            validateNoEmptyEt(editTextUser, "ingresar email");
            return false;
        }

        if (TextUtils.isEmpty(password)) {
            validateNoEmptyEt(editTextPassword, "ingresar contraseña");
            return false;
        }

        if (!email.contains("@") || !email.contains(".com")) {
            validateNoEmptyEt(editTextUser, "formato incorrecto: example@example.com");
            return false;
        }
        return true;
    }

    private void validateNoEmptyEt(EditText et, String message) {
        et.setError(message);
        et.requestFocus();
    }

    private void showToast (String message){
        t = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        t.show();
    }
}