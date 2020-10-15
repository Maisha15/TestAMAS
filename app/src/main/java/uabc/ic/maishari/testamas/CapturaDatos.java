package uabc.ic.maishari.testamas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CapturaDatos extends AppCompatActivity {

    private Button botonRegistrar;
    private EditText nom;
    private EditText mat;
    private EditText corr;
    Persona persona;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captura_datos);
        botonRegistrar=findViewById(R.id.button3);
        nom=findViewById(R.id.elnombre);
        mat=findViewById(R.id.lamat);
        corr=findViewById(R.id.elcorreo);

        final Intent intent=getIntent();
        persona = (Persona) intent.getSerializableExtra("PERSONA");

        if(persona!=null){
            Log.i("PEROSNA","llego el objeto ");
            //Toast.makeText(getApplicationContext(),"Ya se creo el objeto",Toast.LENGTH_SHORT).show();

            botonRegistrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    persona.setNombre(nom.getText().toString());
                    persona.setMatricula(mat.getText().toString());
                   // String correo=corr.getText().toString()+"@uabc.edu.mx";
                    persona.setCorreo(corr.getText().toString()+"@uabc.edu.mx");

                    intent.putExtra("PERSONALLENA",persona);
                    setResult(Activity.RESULT_OK, intent);

                    finish();
                }
            });



        }
        else{
           // Toast.makeText(getApplicationContext(),"No se creo el objeto",Toast.LENGTH_SHORT).show();
            Log.i("PEROSNA","NOOOOO llego el objeto ");
        }


    }
}