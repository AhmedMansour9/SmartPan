package tain.traning.Presenter;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tain.traning.Model.City;
import tain.traning.Model.Cityresponse;
import tain.traning.Model.User;
import tain.traning.Model.loginprefrence;
import tain.traning.Retrofit.ApiCLint;
import tain.traning.Retrofit.Apiinterface;
import tain.traning.Views.cityview;
import tain.traning.Views.loginview;

/**
 * Created by HP on 30/06/2018.
 */

public class LoginPrestener {
    loginview loginView;
    Context context;
    cityview cites;
    public LoginPrestener(Context context,loginview loginView)
    {
        this.loginView=loginView;
        this.context=context;

    }
    public LoginPrestener(Context context,cityview City)
    {
        this.cites=City;
        this.context=context;

    }

    public void login(String name, String password) {

        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("emailOrPhone", name);
        queryMap.put("password", password);
        queryMap.put("token", "1");

        Apiinterface apiInterface = ApiCLint.getClient().create(Apiinterface.class);
        Call<loginprefrence> call = apiInterface.login(queryMap);
        call.enqueue(new Callback<loginprefrence>() {
            @Override
            public void onResponse(Call<loginprefrence> call, Response<loginprefrence> response) {

                if (response.isSuccessful())
                {
                    if(response.body().getSuccess().equals("ok")) {
                        User user = new User();
                        user.setUsername(response.body().getArabicName());
                        user.setPassword(response.body().getPic());
                        user.setId(response.body().getUserid());
                        loginView.main(user);
                    }
                    else
                    {
                        Toast.makeText(context,"error",Toast.LENGTH_LONG);

                    }



                }

            }

            @Override
            public void onFailure(Call<loginprefrence> call, Throwable t) {

//                Log.e("LoginFailure", call.request().toString());


            }
        });
    }
   public void getCites(){
       Apiinterface apiInterface = ApiCLint.getClient().create(Apiinterface.class);
       Call<Cityresponse> call = apiInterface.getCity();
       call.enqueue(new Callback<Cityresponse>() {
           @Override
           public void onResponse(Call<Cityresponse> call, Response<Cityresponse> response) {

               if (response.isSuccessful())
               {
                  cites.showlistcites(response.body().getCities());



               }

           }

           @Override
           public void onFailure(Call<Cityresponse> call, Throwable t) {

           }
       });

   }
}
