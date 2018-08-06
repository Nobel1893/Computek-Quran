package holyquran.cls.com.holyquran.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import holyquran.cls.com.holyquran.Adapters.SurasAdapter;
import holyquran.cls.com.holyquran.Base.MyBaseActivity;
import holyquran.cls.com.holyquran.R;

public class QuranActivity extends MyBaseActivity {
    public static String[] ArSuras = {"الفاتحه", "البقرة", "آل عمران", "النساء", "المائدة", "الأنعام", "الأعراف", "الأنفال", "التوبة", "يونس", "هود"
            , "يوسف", "الرعد", "إبراهيم", "الحجر", "النحل", "الإسراء", "الكهف", "مريم", "طه", "الأنبياء", "الحج", "المؤمنون"
            , "النّور", "الفرقان", "الشعراء", "النّمل", "القصص", "العنكبوت", "الرّوم", "لقمان", "السجدة", "الأحزاب", "سبأ"
            , "فاطر", "يس", "الصافات", "ص", "الزمر", "غافر", "فصّلت", "الشورى", "الزخرف", "الدّخان", "الجاثية", "الأحقاف"
            , "محمد", "الفتح", "الحجرات", "ق", "الذاريات", "الطور", "النجم", "القمر", "الرحمن", "الواقعة", "الحديد", "المجادلة"
            , "الحشر", "الممتحنة", "الصف", "الجمعة", "المنافقون", "التغابن", "الطلاق", "التحريم", "الملك", "القلم", "الحاقة", "المعارج"
            , "نوح", "الجن", "المزّمّل", "المدّثر", "القيامة", "الإنسان", "المرسلات", "النبأ", "النازعات", "عبس", "التكوير", "الإنفطار"
            , "المطفّفين", "الإنشقاق", "البروج", "الطارق", "الأعلى", "الغاشية", "الفجر", "البلد", "الشمس", "الليل", "الضحى", "الشرح"
            , "التين", "العلق", "القدر", "البينة", "الزلزلة", "العاديات", "القارعة", "التكاثر", "العصر",
            "الهمزة", "الفيل", "قريش", "الماعون", "الكوثر", "الكافرون", "النصر", "المسد", "الإخلاص", "الفلق", "الناس"};

    protected RecyclerView SurasList;
    SurasAdapter adapter;
    LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_quran);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();
        adapter=new SurasAdapter(ArSuras);
        layoutManager=new LinearLayoutManager(activity);

        SurasList.setLayoutManager(layoutManager);
        SurasList.setAdapter(adapter);
        adapter.setOnItemClickListener(new SurasAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String suraName, int position) {
                SuraContent.suraNumber=position+1;//send parameter
                Intent i=new Intent(activity,SuraContent.class);
                i.putExtra("suraName",suraName);//send parameter
                startActivity(i);
            }
        });





    }

    private void initView() {
        SurasList =  findViewById(R.id.SurasList);
    }
}
