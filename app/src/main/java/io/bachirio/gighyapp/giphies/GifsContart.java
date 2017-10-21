package io.bachirio.gighyapp.giphies;

import java.util.List;

import io.bachirio.gighyapp.BasePresenter;
import io.bachirio.gighyapp.BaseView;
import io.bachirio.gighyapp.data.Gif;

/**
 * Created by bachiri on 9/15/17.
 */

public interface GifsContart {

    interface Presenter extends BasePresenter {
        public void getGifs();

    }

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);
        void setOnErrorLoading();
        void showTasks(List<Gif> tasks);

    }
}
