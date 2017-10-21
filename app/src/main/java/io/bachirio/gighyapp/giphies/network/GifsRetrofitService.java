package io.bachirio.gighyapp.giphies.network;

import io.bachirio.gighyapp.data.network.RetrofitClient;

/**
 * Created by bachiri on 9/21/17.
 */

public class GifsRetrofitService {

    public static GifsClient getGifsRetrofitService() {
        return RetrofitClient.getRetrofitInstance().create(GifsClient.class);
    }

}
