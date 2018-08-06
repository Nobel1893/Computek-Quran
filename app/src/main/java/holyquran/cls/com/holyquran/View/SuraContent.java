package holyquran.cls.com.holyquran.View;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import holyquran.cls.com.holyquran.Adapters.VersesAdapter;
import holyquran.cls.com.holyquran.Base.MyBaseActivity;
import holyquran.cls.com.holyquran.R;

public class SuraContent extends MyBaseActivity implements View.OnClickListener {

    public static int suraNumber;
    protected RecyclerView Verses;
    protected TextView name;
    VersesAdapter adapter;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_sura_content);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();
        String SuraName = getIntent().getStringExtra("suraName");//recieve parameter
        name.setText(SuraName);
        ArrayList<String> VersesList = ReadSura(suraNumber + ".txt");
        adapter = new VersesAdapter(VersesList);
        layoutManager = new LinearLayoutManager(activity);
        Verses.setAdapter(adapter);
        Verses.setLayoutManager(layoutManager);


    }


    public ArrayList<String> ReadSura(String filename) {

        ArrayList<String> fileContent = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(filename), "UTF-8"));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                fileContent.add(mLine);
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
        return fileContent;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.Verses) {

        }
    }

    private void initView() {
        Verses = (RecyclerView) findViewById(R.id.Verses);
        Verses.setOnClickListener(SuraContent.this);
        name = (TextView) findViewById(R.id.name);
    }
}
