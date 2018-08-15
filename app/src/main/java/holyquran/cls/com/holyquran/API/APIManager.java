package holyquran.cls.com.holyquran.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by CLS on 8/13/2018.
 */

public class APIManager {

    public static Retrofit retrofitInstance;

    private static Retrofit getInstance(){

        if (retrofitInstance==null){
            retrofitInstance = new Retrofit.Builder()
                .baseUrl("http://mp3quran.net/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        }
        return retrofitInstance;

    }

   public static QuranServices getServices(){
        if (retrofitInstance==null)
            getInstance();

        return getInstance().create(QuranServices.class);
    }
}
