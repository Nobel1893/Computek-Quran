package holyquran.cls.com.holyquran.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import holyquran.cls.com.holyquran.R;


/**
 * Created by CLS on 8/1/2018.
 */

public class VersesAdapter extends RecyclerView.Adapter<VersesAdapter.ViewHolder>{


    ArrayList<String> AllVerses ;//data source
    OnItemClickListener onItemClickListener;


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public VersesAdapter(ArrayList<String> allVerses) {
        AllVerses = allVerses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_sura ,null);
        ViewHolder viewHolder =new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final String name = AllVerses.get(position);
        holder.SuraName.setText(name +"("+(position+1)+")");
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener!=null)
                onItemClickListener.onItemClick(name,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return AllVerses.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView SuraName;
        View parent;
        public ViewHolder(View cardView){
            super(cardView);
            SuraName=cardView.findViewById(R.id.suraName);
             parent=cardView.findViewById(R.id.parent);

        }



    }

    public static interface OnItemClickListener{
       void onItemClick(String suraName, int position);
    }

}
