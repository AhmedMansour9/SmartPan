package tain.traning.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HP on 30/06/2018.
 */

public class ApiCLint {
    //public static final String BASE_URL = "http://192.168.1.23:4445/AndroidAPI/";
//    public static final String BASE_URL = "http://192.168.1.210:7778/AndroidAPI/";
    public static final String BASE_URL = "http://www.smartpan.com.sa:5202/AndroidAPI/";
    // public static final String BASE_URL = "http://www.smartpan.com.sa:1002/AndroidAPI/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build();
        }

        return retrofit;
    }
}
