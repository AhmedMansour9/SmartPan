package tain.traning.Retrofit;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import tain.traning.Model.CategoryResponse;
import tain.traning.Model.Categoryrespinse;
import tain.traning.Model.Cityresponse;
import tain.traning.Model.RegisterResponce;
import tain.traning.Model.loginprefrence;

/**
 * Created by HP on 30/06/2018.
 */

public interface Apiinterface {
  @POST("Login")
    Call<loginprefrence>login(@QueryMap Map<String,String> query);

  @POST("getcities")
  Call<Cityresponse>getCity();

  @POST ("Register")
  Call<RegisterResponce> register(@QueryMap Map<String,String> queryMab);
  @GET("getCatagories")
  Call<CategoryResponse> getCatageories(@QueryMap Map<String,String> stringMap);
  @GET("GetcategoryItems")
  Call<Categoryrespinse> getCatageoriesitems(@QueryMap Map<String,String> stringMap);

}
