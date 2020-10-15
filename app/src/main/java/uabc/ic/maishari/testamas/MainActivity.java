package uabc.ic.maishari.testamas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import static android.widget.LinearLayout.HORIZONTAL;

public class MainActivity extends AppCompatActivity implements ItemArrayAdapter.ListItemClickListener{
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List <ItemAmas> todosItems;
    private Button botonllenar;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        //Para ver la actividad en pantalla completa
        requestWindowFeature(Window.FEATURE_NO_TITLE); //oculta el título de la app
        getSupportActionBar().hide(); // oculta la barra
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //habilita la pantalla completa
        setContentView(R.layout.activity_main);
        intent=getIntent();
        botonllenar=findViewById(R.id.button5);
        botonllenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("ELITEM1","El valor del si y no"+todosItems.get(1).toString());
                intent.putExtra("ITEMSLLENOS",(Serializable) todosItems);
                setResult(Activity.RESULT_OK, intent);
            finish();
            }
        });


        InputStream inputStream = getResources().openRawResource(R.raw.amasc);
        CVSFile csvFile = new CVSFile(inputStream);
        todosItems = csvFile.readObjetos();
        Log.i("SOBRECSV","Se leyeron en total xx lineas"+todosItems.size());

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        //recyclerView.addItemDecoration(itemDecor);
        // specify an adapter (see also next example)
        mAdapter = new ItemArrayAdapter(todosItems,this);
        recyclerView.setAdapter(mAdapter);


    }

    @Override
    public void onListItemClick(int position) {
        ItemAmas item=todosItems.get(position);
        Toast.makeText(this, item.getItem(), Toast.LENGTH_SHORT).show();
    }
}