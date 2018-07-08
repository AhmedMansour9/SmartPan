package tain.traning.Retrofit;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import tain.traning.Model.Cityresponse;
import tain.traning.Model.loginprefrence;

/**
 * Created by HP on 30/06/2018.
 */

public interface Apiinterface {
  @POST("Login")
    Call<loginprefrence>login(@QueryMap Map<String,String> query);

  @POST("getcities")
  Call<Cityresponse>getCity();
}
