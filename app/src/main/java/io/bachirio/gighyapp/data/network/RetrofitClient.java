package io.bachirio.gighyapp.data.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bachiri on 9/21/17.
 */

public class RetrofitClient {

    public static final String BASE_URL = "http://api.giphy.com/";


    public static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

}
