package io.bachirio.gighyapp.data;

import android.support.annotation.NonNull;

import java.util.List;

import io.bachirio.gighyapp.data.Gif;

/**
 * Created by bachiri on 9/24/17.
 */

public interface GifsDataSource {

    interface LoadGifsCallBack{

        void onGifsLoaded(List<Gif> tasks);

        void onDataNotAvailable();

    }

    public void getGifs(@NonNull LoadGifsCallBack loadGifsCallBack);
}
