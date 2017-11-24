package io.bachirio.gighyapp.giphies;

import io.bachirio.gighyapp.BasePresenter;
import io.bachirio.gighyapp.BaseView;
import io.bachirio.gighyapp.data.Gif;
import java.util.List;

/**
 * Created by bachiri on 9/15/17.
 */

public interface GifsContract {

  interface Presenter extends BasePresenter {

    void getGifs(Boolean forceUpdate);

    void openGif(Gif gif);
  }

  interface View extends BaseView<Presenter> {

    void setLoadingIndicator(boolean active);

    void setOnErrorLoading();

    void showGifs(List<Gif> gifs);

    void showGif(Gif gif);
  }
}
