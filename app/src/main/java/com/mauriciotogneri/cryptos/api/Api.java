package com.mauriciotogneri.cryptos.api;

import android.util.Log;

import com.mauriciotogneri.cryptos.api.json.JsonState;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class Api
{
    public static StateService service()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .client(client())
                .baseUrl("https://script.google.com/macros/s/AKfycbxHfbJvV7hR22Nzwco3yYgZ2KOkrD689Y9OS3BjevAXw2UOOHKs/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(StateService.class);
    }

    public static OkHttpClient client()
    {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(message -> Log.d("RETROFIT_LOG", message));
        logging.setLevel(Level.BODY);
        builder.addInterceptor(logging);

        return builder.build();
    }

    public interface StateService
    {
        @GET("dev")
        Call<JsonState> state();
    }
}