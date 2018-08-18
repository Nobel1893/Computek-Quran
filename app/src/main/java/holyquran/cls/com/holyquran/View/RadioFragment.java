package holyquran.cls.com.holyquran.View;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.util.ArrayList;

import holyquran.cls.com.holyquran.API.APIManager;
import holyquran.cls.com.holyquran.Adapters.RadioAdapter;
import holyquran.cls.com.holyquran.Base.MyBaseFragment;
import holyquran.cls.com.holyquran.Model.Channel;
import holyquran.cls.com.holyquran.Model.RadiosResponse;
import holyquran.cls.com.holyquran.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class RadioFragment extends MyBaseFragment {


    protected RecyclerView RadiosList;
    protected View rootView;
    protected RecyclerView radioList;
    LinearLayoutManager layoutManager;
    RadioAdapter adapter;
    ArrayList<Channel> channels;


    public RadioFragment() {
        // Required empty public constructor
    }


    View mainView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_radio, container, false);
        //insert your code here
        initView(rootView);
        layoutManager= new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false);
        radioList.setLayoutManager(layoutManager);
        LoadChannels();
        return rootView;
    }

    public void LoadChannels(){
        ShowProgressBar();
        APIManager.getServices().GetCRadioChanells().enqueue(new Callback<RadiosResponse>() {
            @Override
            public void onResponse(Call<RadiosResponse> call, Response<RadiosResponse> response) {
                HideProgressBar();
              //  response.body().getRadios();
                SetAdapter(response.body().getRadios());

            }

            @Override
            public void onFailure(Call<RadiosResponse> call, Throwable t) {
                HideProgressBar();
                ShowMessage("",t.getLocalizedMessage(),"ok");
            }
        });

    }

    private void initView(View rootView) {
        radioList = (RecyclerView) rootView.findViewById(R.id.radioList);
    }

    public void SetAdapter(ArrayList<Channel> allChannels){

        channels=allChannels;
        adapter=new RadioAdapter(channels);
        radioList.setAdapter(adapter);
        adapter.setOnPlayClickListener(new RadioAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Channel channel, int position) {
                playRadio(channel.getURL());
            }
        });
        adapter.setOnStopClickListener(new RadioAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Channel channel, int position) {
                stopRadio();
            }
        });

    }

    MediaPlayer mediaPlayer;
    public void stopRadio(){
        if (mediaPlayer!=null && mediaPlayer.isPlaying())
            mediaPlayer.stop();
    }
    public void playRadio(String url){
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(url);
           // mediaPlayer.prepare();
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });
            //mediaPlayer.start();
        } catch (IOException e) {
            ShowMessage("error","error play Radio Channel","ok");
            e.printStackTrace();
        }


    }
}
