package io.bachirio.gighyapp.giphies.network;

import io.bachirio.gighyapp.giphies.data.GifsResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by bachiri on 9/19/17.
 */

public interface GifsClient {

    @GET("/v1/gifs/trending?limit=20&fmt=json&offset=1&api_key=hewxRBG5FdomuauBppsiO0OV8OXv4Xkw")
    Call<GifsResponse> getGifs();


}
