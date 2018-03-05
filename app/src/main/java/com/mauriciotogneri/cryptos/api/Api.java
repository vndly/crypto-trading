package com.mauriciotogneri.cryptos.api;

import com.mauriciotogneri.cryptos.api.json.JsonState;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class Api
{
    public static StateService service()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://script.google.com/macros/s/AKfycbxmL2WCCqb3Ky0spDk9nI76a9QtKQagjygJyJByHp4/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(StateService.class);
    }

    public interface StateService
    {
        @GET("dev")
        Call<JsonState> state();
    }
}