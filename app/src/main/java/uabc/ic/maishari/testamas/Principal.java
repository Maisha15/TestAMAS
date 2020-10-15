package uabc.ic.maishari.testamas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

public class Principal extends AppCompatActivity {

    private Button botonCaptura;
    private Button botonAMAS;
    private Button botonverresult;
    Persona persona=new Persona();
    static final int CODIGO_CAPTURA=10;
    static final int CODIGO_AMAS=20;
    private boolean capturaPersonas=false;
    private boolean capturaAmas=false;
    private List<ItemAmas> todosItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        botonCaptura=findViewById(R.id.button);
        botonAMAS=findViewById(R.id.button2);
        botonverresult=findViewById(R.id.button4);
        botonCaptura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),CapturaDatos.class);
               intent.putExtra("PERSONA", persona);
                startActivityForResult(intent,CODIGO_CAPTURA);
                Toast.makeText(getApplicationContext(),"regresando?"+persona,Toast.LENGTH_SHORT).show();
            }
        });

        botonAMAS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("LISTAITEMS", (Serializable) todosItems);
                startActivityForResult(intent,CODIGO_AMAS);
            }
        });
        botonverresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent=new Intent()
                Toast.makeText(getApplicationContext(),"Falta ver el calculo",Toast.LENGTH_SHORT).show();


            }
        });

    }
    @Override
    protected void onActivityResult( int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode== Activity.RESULT_OK){
        switch (requestCode) {
            case CODIGO_CAPTURA:
                persona = (Persona) data.getSerializableExtra("PERSONA");
                Log.i("MIPERSONA",persona.toString());
                capturaPersonas=true;
                break;
            case CODIGO_AMAS:
                //TODO
                todosItems=(List<ItemAmas>) data.getSerializableExtra("ITEMSLLENOS");

                capturaAmas=true;
                calcularResultadosAMAS();
                break;
        }
        }
        else{
            Toast.makeText(getApplicationContext(),"Error en la captura",Toast.LENGTH_SHORT).show();

        }

    }
    public void calcularResultadosAMAS(){

        int contadorinquietud=0;
        int contadorAnsiFis=0;
        int contadorAndiExam=0;
        int contadorAnsiSoc=0;
        int contadorMentira=0;

        for (ItemAmas item:todosItems){
            Log.i("ITEM x",item.getId()+""+item.toString());
        }



    }
}