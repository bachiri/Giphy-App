package io.bachirio.gighyapp.giphies;

import java.util.List;

import io.bachirio.gighyapp.data.Gif;
import io.bachirio.gighyapp.data.GifsDataSource;

/**
 * Created by bachiri on 9/15/17.
 */

public class GifsPresenter implements GifsContart.Presenter {

    private final GifsContart.View mGifsView;
    private final GifsDataSource gifsDataSource;

    @Override
    public void start() {
        getGifs();
    }


    public GifsPresenter(GifsContart.View mGifsView, GifsDataSource gifsDataSource) {
        this.mGifsView = mGifsView;
        this.gifsDataSource = gifsDataSource;
        mGifsView.setPresenter(this);

    }

    @Override
    public void getGifs() {
        mGifsView.setLoadingIndicator(true);
        gifsDataSource.getGifs(new GifsDataSource.LoadGifsCallBack() {
            @Override
            public void onGifsLoaded(List<Gif> gifs) {
                mGifsView.showTasks(gifs);
            }

            @Override
            public void onDataNotAvailable() {
                mGifsView.setOnErrorLoading();
            }
        });

    }


}
