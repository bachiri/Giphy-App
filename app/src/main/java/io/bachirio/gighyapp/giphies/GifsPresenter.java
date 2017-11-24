package io.bachirio.gighyapp.giphies;

import java.util.List;

import io.bachirio.gighyapp.data.Gif;
import io.bachirio.gighyapp.data.GifsDataSource;

/**
 * Created by bachiri on 9/15/17.
 */

public class GifsPresenter implements GifsContract.Presenter {

    private final GifsContract.View mGifsView;
    private final GifsDataSource gifsDataSource;
    private boolean mFirstLoad = true;

    @Override
    public void start() {
        getGifs(false);
    }


    public GifsPresenter(GifsContract.View mGifsView, GifsDataSource gifsDataSource) {
        this.mGifsView = mGifsView;
        this.gifsDataSource = gifsDataSource;
        mGifsView.setPresenter(this);

    }

    @Override
    public void getGifs(Boolean forceUpdate) {
        if (forceUpdate || mFirstLoad) {
            loadGifs();
        }
        mFirstLoad = false;

    }

    private void loadGifs() {
        mGifsView.setLoadingIndicator(true);
        gifsDataSource.getGifs(new GifsDataSource.LoadGifsCallBack() {
            @Override
            public void onGifsLoaded(List<Gif> gifs) {
                mGifsView.showGifs(gifs);
            }

            @Override
            public void onDataNotAvailable() {
                mGifsView.setOnErrorLoading();
            }
        });
    }

    @Override
    public void openGif(Gif gif) {
        mGifsView.showGif(gif);
    }
}
