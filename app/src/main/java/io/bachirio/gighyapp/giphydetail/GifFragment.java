package io.bachirio.gighyapp.giphydetail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.bachirio.gighyapp.R;
import io.bachirio.gighyapp.data.Gif;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by bachiri on 11/23/17.
 */

public class GifFragment extends Fragment implements GifContract.View {
    private GifContract.Presenter gifPresenter;
    @BindView(R.id.gif_image_view)
    ImageView gifImageView;

    public GifFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_gif, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onResume() {
        gifPresenter.start();
        super.onResume();
    }

    public static GifFragment getInstance() {
        return new GifFragment();
    }

    @Override
    public void setPresenter(@NonNull GifContract.Presenter presenter) {
        this.gifPresenter = checkNotNull(presenter);
    }

    @Override
    public void showGif(Gif gif) {
        Glide.with(getActivity())
                .asGif()
                .load(gif.getGifImages().getDownsizedGif().getUrl())
                .into(gifImageView);


    }
}
