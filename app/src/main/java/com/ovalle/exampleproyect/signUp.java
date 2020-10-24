package com.ovalle.exampleproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class signUp extends AppCompatActivity {
    private EditText txtNombre, txtApellido, txtEmail, txtPassword, txtConfirmPassword, txtTelefono;
    private Spinner spinnerGenero;
    private Button btnRegistrar, btnCancelar;
    private String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        txtConfirmPassword = findViewById(R.id.txtConfirmPassword);
        txtTelefono = findViewById(R.id.txtTelefono);
        spinnerGenero = findViewById(R.id.spinnerGenero);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnCancelar = findViewById(R.id.btnCancelar);

        txtApellido.setEnabled(false);
        txtEmail.setEnabled(false);
        txtPassword.setEnabled(false);
        txtConfirmPassword.setEnabled(false);
        spinnerGenero.setEnabled(false);
        txtTelefono.setEnabled(false);
        btnRegistrar.setEnabled(false);

        cargarSpinner();
        validarRegistro();
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int posicion = spinnerGenero.getSelectedItemPosition();
                if(posicion != 0){
                    Toast.makeText(signUp.this,"Registrado con exito",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(signUp.this,"Falta el genero",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCancelar = new Intent(signUp.this, MainActivity.class);
                startActivity(intentCancelar);
            }
        });

    }

    public void cargarSpinner(){
        ArrayList<String> generos = new ArrayList<>();
        generos.add("----Seleccione un genero----");
        generos.add("Masculino");
        generos.add("Femenino");
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(signUp.this, android.R.layout.simple_spinner_item, generos);
        spinnerGenero.setAdapter(spinnerAdapter);
    }

    public void validarRegistro(){
        txtNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if ( txtNombre.getText().toString().length() >= 3){
                    txtApellido.setEnabled(true);
                }else{
                    txtNombre.setError("Nombre invalido");
                    txtApellido.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        txtApellido.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(txtApellido.getText().toString().length() <= 4){
                    txtApellido.setError("Apellido invalido");
                    txtEmail.setEnabled(false);
                }else{
                    txtEmail.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        txtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(txtEmail.getText().toString().length() <= 5){
                    txtEmail.setError("Correo invalido");
                    txtPassword.setEnabled(false);
                }else{
                    txtPassword.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        txtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(txtPassword.getText().toString().length() <= 3){
                    txtPassword.setError("minimo 4 caracteres");
                    txtConfirmPassword.setEnabled(false);
                }else{
                    txtConfirmPassword.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        txtConfirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(txtPassword.getText().toString().equals(txtConfirmPassword.getText().toString())){
                    spinnerGenero.setEnabled(true);
                    txtTelefono.setEnabled(true);
                }else{
                    txtConfirmPassword.setError("error");
                    //spinnerGenero.setId(0);
                    spinnerGenero.setEnabled(false);
                    txtTelefono.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        txtTelefono.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(txtTelefono.getText().toString().length() <=8){
                    txtTelefono.setError("Telefono invalido");
                    btnRegistrar.setEnabled(false);
                }else{
                    btnRegistrar.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



    }
}