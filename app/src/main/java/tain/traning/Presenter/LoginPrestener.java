package tain.traning.Presenter;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tain.traning.Model.Category;
import tain.traning.Model.CategoryResponse;
import tain.traning.Model.Categoryitem;
import tain.traning.Model.Categoryrespinse;
import tain.traning.Model.City;
import tain.traning.Model.Cityresponse;
import tain.traning.Model.RegisterResponce;
import tain.traning.Model.User;
import tain.traning.Model.loginprefrence;
import tain.traning.Retrofit.ApiCLint;
import tain.traning.Retrofit.Apiinterface;
import tain.traning.Views.CategoryView;
import tain.traning.Views.Categoryitemview;
import tain.traning.Views.RegisterView;
import tain.traning.Views.cityview;
import tain.traning.Views.loginview;

/**
 * Created by HP on 30/06/2018.
 */

public class LoginPrestener {
    loginview loginView;
    Context context;
    cityview cites;
    RegisterView registerView;
    CategoryView categ;
    int id;
    Categoryitemview catss;
    public LoginPrestener(Context context,RegisterView registerView)
    {
        this.registerView=registerView;

    }
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

    public LoginPrestener(Context context,CategoryView categ)
    {
        this.categ=categ;
        this.context=context;

    }
    public LoginPrestener(Context context,Categoryitemview categ)
    {
        this.catss=categ;
        this.context=context;

    }

    public void register(User user,City city) {
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("name", user.getName());
        queryMap.put("password", user.getPassword());
        queryMap.put("mail", user.getMail());
        queryMap.put("gender", user.getGender());
        queryMap.put("cityId",  String.valueOf(city.getId()));
        queryMap.put("districtId","1" );
        queryMap.put("address", user.getAddress());
        queryMap.put("phone", user.getPhone());

        Apiinterface apiInterface = ApiCLint.getClient().create(Apiinterface.class);


        Call<RegisterResponce> call = apiInterface.register(queryMap);
        call.enqueue(new Callback<RegisterResponce>() {
            @Override
            public void onResponse(Call<RegisterResponce> call, Response<RegisterResponce> response) {

                if (response.isSuccessful()) {
                    registerView.openMain();
                } else {
                    registerView.showError("");
                }
            }


            @Override
            public void onFailure(Call<RegisterResponce> call, Throwable t) {
                registerView.showError("");

            }
        });
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
       Map<String, String> queryMap = new HashMap<>();
       queryMap.put("restaurantid","1");

       Call<CategoryResponse> call = apiInterface.getCatageories(queryMap);
       call.enqueue(new Callback<CategoryResponse>() {
           @Override
           public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {

               if (response.isSuccessful() &&response.body().getSuccess().equals("ok"))
               {
                  categ.showlot(response.body().getCategories());

               }

           }

           @Override
           public void onFailure(Call<CategoryResponse> call, Throwable t) {

           }
       });

   }
    public void getCategoriesItems(int id){

        Apiinterface apiInterface = ApiCLint.getClient().create(Apiinterface.class);
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("restaurantid","1");
        queryMap.put("categoryId",String.valueOf(id));
        Call<Categoryrespinse> ca = apiInterface.getCatageoriesitems(queryMap);
        ca.enqueue(new Callback<Categoryrespinse>() {
            @Override
            public void onResponse(Call<Categoryrespinse> call, Response<Categoryrespinse> response) {

                if (response.isSuccessful() &&response.body().getSuccess().equals("ok"))
                {
                    catss.listitemsid(response.body().getItems());

                }

            }

            @Override
            public void onFailure(Call<Categoryrespinse> call, Throwable t) {

            }
        });

    }
    public void getCeties(){
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
