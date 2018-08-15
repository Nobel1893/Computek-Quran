package holyquran.cls.com.holyquran.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import holyquran.cls.com.holyquran.Model.Channel;
import holyquran.cls.com.holyquran.R;


/**
 * Created by CLS on 8/1/2018.
 */

public class RadioAdapter extends RecyclerView.Adapter<RadioAdapter.ViewHolder>{


    ArrayList<Channel> AllChannels ;//data source
    OnItemClickListener onPlayClickListener;
    OnItemClickListener onStopClickListener;


    public void setOnPlayClickListener(OnItemClickListener onPlayClickListener) {
        this.onPlayClickListener = onPlayClickListener;
    }

    public void setOnStopClickListener(OnItemClickListener onStopClickListener) {
        this.onStopClickListener = onStopClickListener;
    }

    public RadioAdapter(ArrayList<Channel> AllChannels) {
        this.AllChannels = AllChannels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_radio,null);
        ViewHolder viewHolder =new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Channel channel= AllChannels.get(position);
        holder.channelName.setText(channel.getNAME() );
        holder.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onPlayClickListener!=null)
                    onPlayClickListener.onItemClick(channel,position);
            }
        });
        holder.stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onStopClickListener!=null)
                onStopClickListener.onItemClick(channel,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return AllChannels.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView channelName;
        ImageButton play;
        ImageButton stop;

        View parent;
        public ViewHolder(View cardView){
            super(cardView);
            channelName=cardView.findViewById(R.id.radio_name);
            play=cardView.findViewById(R.id.play);
            stop=cardView.findViewById(R.id.stop);

        }



    }

    public static interface OnItemClickListener{
       void onItemClick(Channel channel, int position);
    }

}
