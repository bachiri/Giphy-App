package io.bachirio.gighyapp.giphydetail;

import io.bachirio.gighyapp.BasePresenter;
import io.bachirio.gighyapp.BaseView;
import io.bachirio.gighyapp.data.Gif;

/**
 * Created by bachiri on 10/26/17.
 */

public class GifContract {

  interface Presenter extends BasePresenter {

  }

  interface View extends BaseView<Presenter> {
    void showGif(Gif gif);
  }
}
