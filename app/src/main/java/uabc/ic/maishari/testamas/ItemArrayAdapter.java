package uabc.ic.maishari.testamas;

import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemArrayAdapter extends RecyclerView.Adapter<ItemArrayAdapter.MyViewHolder> {
    //List es abstracta, por eso debo crear el objeto
    private List<ItemAmas> listaItems = new ArrayList();
    private static ListItemClickListener mOnClickListener=null;

// Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and
// you provide access to all the views for a data item in a view holder
public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    // each data item is just a string in this case
    public TextView textView;
    public View view;
    RadioButton checksi;
    RadioButton checkno;
    RadioGroup grupoRadio;

    public MyViewHolder(View v){
        super(v);
        view = v;
        textView=v.findViewById(R.id.textView);
        checksi=v.findViewById(R.id.radioButton2);
        checkno=v.findViewById(R.id.radioButton);
        grupoRadio=v.findViewById(R.id.radiogrupo);
        view.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int position = getAdapterPosition();
        mOnClickListener.onListItemClick(position);
    }
}

    // Provide a suitable constructor (depends on the kind of dataset)
    public ItemArrayAdapter(List misDatos,ListItemClickListener onClickListener) {
        listaItems=misDatos;
        this.mOnClickListener=onClickListener;
        //mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ItemArrayAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        // create a new view
       // TextView v = (TextView) LayoutInflater.from(parent.getContext())
         //       .inflate(R.layout.vistapregunta, parent, false);
        View v = (View) LayoutInflater.from(parent.getContext())
               .inflate(R.layout.vistapregunta, parent, false);
        //TextView v = (TextView)inflater.getI
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
       final ItemAmas item=(ItemAmas) listaItems.get(position);

        holder.textView.setText(" "+item.getId()+". "+item.getItems());
        //Log.i("ADAPTER","item leido: "+item.getItems());

      //Necesito programar lo eventos del Radiobutton para que el valor del
      //objeto cambie.
        RadioGroup radioGroup = (RadioGroup) holder.grupoRadio;
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton= (RadioButton) group.findViewById(checkedId);

               // radioButton.findViewById(checkedId);
                if(radioButton.getText().equals("Si")){
                    Log.i("RADIOBUTTON","se selecciono: "+radioButton.getText());
                item.setSi("checked");
                item.setNo("NOchecked");

                }
                if(radioButton.getText().equals("No")){
                    Log.i("RADIOBUTTON","se selecciono: "+radioButton.getText());
                    item.setSi("NOchecked");
                    item.setNo("checked");

                }

            }
        });



    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listaItems.size();//.length;
    }

    interface ListItemClickListener{
        void onListItemClick(int position);
    }

}