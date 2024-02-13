package com.example.applicacioncontrolcuentas;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Cuentasagregar extends AppCompatActivity {
    EditText email, password, registro;
    CheckBox checkmostrar;
    Button agregar;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuentasagregar);

        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        registro = findViewById(R.id.editTextRegistro);
        checkmostrar = findViewById(R.id.checkMostrar);
        agregar = findViewById(R.id.btnAgregar);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("emails");

        checkmostrar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked)
                {
                    password.setTransformationMethod(null);
                }
                else
                {
                    password.setTransformationMethod(new PasswordTransformationMethod());
                }
            }
        });
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailI = email.getText().toString();
                String passI = password.getText().toString();
                String regI = registro.getText().toString();

                Email nuevoEmail = new Email(emailI, passI, regI);
                databaseReference.push().setValue(nuevoEmail, new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                if (error == null) {
                                    // Éxito al agregar el email
                                    Toast.makeText(Cuentasagregar.this, "Email Agregado Correctamente", Toast.LENGTH_SHORT).show();
                                } else {
                                    // Error al agregar el email
                                    Toast.makeText(Cuentasagregar.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                });
                        // Limpiar los campos de texto
                        email.setText("");
                password.setText("");
                registro.setText("");
            }
        });
    }
}