package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarContacto extends AppCompatActivity {

    private EditText txt_nombre;
    private EditText txt_telefono;
    private EditText txt_correo;
    private EditText txt_fecha;
    private EditText txt_twitter;
    private Button btn_guardar;
    Contacto UnContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contacto);
        txt_nombre = (EditText)findViewById(R.id.txt_nombre);
        txt_telefono = (EditText)findViewById(R.id.txt_telefono);
        txt_correo = (EditText)findViewById(R.id.txt_correo);
        txt_fecha = (EditText)findViewById(R.id.txt_fecha);
        txt_twitter = (EditText)findViewById(R.id.txt_twitter);
        btn_guardar = (Button) findViewById(R.id.btn_guardar);

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    UnContacto = new Contacto(txt_nombre.getText().toString(),txt_telefono.getText().toString(),
                                 txt_correo.getText().toString(),txt_fecha.getText().toString(),txt_twitter.getText().toString());

                    Toast mensaje =   Toast.makeText(getApplicationContext(),"Contacto guardado con exito", Toast.LENGTH_SHORT);
                    mensaje.show();
                    terminar();
                }
                catch (Exception e){
                    Toast error = Toast.makeText(getApplicationContext(), "Ha ocurrido un error", Toast.LENGTH_SHORT);
                    error.show();
                }
            }
        });

    }

    public void terminar()
    {
        Intent ventana = new Intent();
        ventana.putExtra("retorno",UnContacto);
        setResult(RESULT_OK,ventana);
        super.finish();

    }



}
