package com.example.agenda;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE=10;
    private Button btn_agregar;
    private ListView lv_contactos;

    private ArrayAdapter<Contacto> adaptador;
    private ArrayList<Contacto> lista_contactos = new ArrayList<>();

   Contacto c = new Contacto("Martín","445-131-2420","martindmmz@gmail.com","07/01/1997","@martindmmz");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        lv_contactos = (ListView)findViewById(R.id.lv_contactos);
        lista_contactos = new ArrayList();
        lista_contactos.add(c);
        lista_contactos.add(c);



        adaptador = new ArrayAdapter<Contacto>(this, android.R.layout.simple_list_item_1, lista_contactos);
        lv_contactos.setAdapter(adaptador);

        btn_agregar = (Button)findViewById(R.id.btn_agregar);
        btn_agregar.setOnClickListener(new View.OnClickListener() {

          @Override
        public void onClick(View v) {
          AbrirAgregar();
          }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode==RESULT_OK && requestCode==REQUEST_CODE){

            if(data.hasExtra("retorno")){
                Contacto recibidos = (Contacto)data.getExtras().getParcelable("retorno");
                lista_contactos.add(recibidos);

            }

        }
    }

    public void AbrirAgregar()
    {
        Intent ventana = new Intent(this,AgregarContacto.class);
        startActivityForResult(ventana,REQUEST_CODE);
    }



}