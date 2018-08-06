package holyquran.cls.com.holyquran.View;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import holyquran.cls.com.holyquran.Adapters.AhadeathAdapter;
import holyquran.cls.com.holyquran.Model.HadeathItem;
import holyquran.cls.com.holyquran.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HadeathFragment extends Fragment {


    public HadeathFragment() {
        // Required empty public constructor
    }


    RecyclerView AhadeathList;
    LinearLayoutManager layoutManager;
    AhadeathAdapter adapter;
    ArrayList<HadeathItem> allAhadeath;
    View mainView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView= inflater.inflate(R.layout.fragment_hadeath, container, false);
        AhadeathList = mainView.findViewById(R.id.ahadeathList);
        allAhadeath=ReadAllAhadith();

        adapter=new AhadeathAdapter(allAhadeath);
        layoutManager=new LinearLayoutManager(getContext());

        AhadeathList.setLayoutManager(layoutManager);
        AhadeathList.setAdapter(adapter);
        return mainView;
    }

    public ArrayList<HadeathItem> ReadAllAhadith() {

        ArrayList<HadeathItem> Ahadeath = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getActivity().getAssets().open("ahadith.txt"), "UTF-8"));

            // do reading, usually loop until end of file reading
            String mLine;
            HadeathItem hadeathItem=new HadeathItem();
            while ((mLine = reader.readLine()) != null) {

                if (mLine.equals("#")){
                    Ahadeath.add(hadeathItem);
                    hadeathItem=new HadeathItem();
                }else {
                    hadeathItem.getAllLines().add(mLine);
                }
            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }
        return Ahadeath;
    }
}
