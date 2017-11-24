package io.bachirio.gighyapp.giphydetail;

import io.bachirio.gighyapp.data.Gif;

/**
 * Created by bachiri on 11/23/17.
 */

class GifPresenter implements GifContract.Presenter {

    private GifContract.View gifView;
    private Gif gif;

    public GifPresenter(GifContract.View gifView, Gif gif) {
        this.gifView = gifView;
        this.gif = gif;
        gifView.setPresenter(this);
    }

    @Override
    public void start() {
        showGif();
    }

    private void showGif() {
        gifView.showGif(gif);
    }
}
