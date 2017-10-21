package io.bachirio.gighyapp.data.source;

import android.support.annotation.NonNull;

import io.bachirio.gighyapp.data.GifsDataSource;
import io.bachirio.gighyapp.giphies.data.GifsResponse;
import io.bachirio.gighyapp.giphies.network.GifsClient;
import io.bachirio.gighyapp.giphies.network.GifsRetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by bachiri on 9/24/17.
 */

public class GifsRemoteDataSource implements GifsDataSource {



    @Override
    public void getGifs(@NonNull final LoadGifsCallBack loadGifsCallBack) {

        GifsClient mService = GifsRetrofitService.getGifsRetrofitService();

        mService.getGifs().enqueue(new Callback<GifsResponse>() {
            @Override
            public void onResponse(Call<GifsResponse> call, Response<GifsResponse> response) {
                if (!response.isSuccessful()) {
                    Timber.e(call.request().url() + ": failed: " + response.code());
                    return;
                }
                GifsResponse gifsResponse = response.body();
                loadGifsCallBack.onGifsLoaded(gifsResponse.getGifList());
            }

            @Override
            public void onFailure(Call<GifsResponse> call, Throwable t) {
                loadGifsCallBack.onDataNotAvailable();
            }
        });
    }
}
