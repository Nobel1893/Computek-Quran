package holyquran.cls.com.holyquran.API;

import holyquran.cls.com.holyquran.Model.RadiosResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by CLS on 8/13/2018.
 */

public interface QuranServices {


    @GET("radio/radio_ar.json")
    Call<RadiosResponse> GetCRadioChanells();

}
