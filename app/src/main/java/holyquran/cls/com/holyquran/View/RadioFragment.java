package holyquran.cls.com.holyquran.View;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
                channels=response.body().getRadios();
                adapter=new RadioAdapter(channels);
                radioList.setAdapter(adapter);

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
}
