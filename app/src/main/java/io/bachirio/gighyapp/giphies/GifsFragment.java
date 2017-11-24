package io.bachirio.gighyapp.giphies;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.bachirio.gighyapp.R;
import io.bachirio.gighyapp.data.Gif;
import io.bachirio.gighyapp.giphydetail.GifActivity;
import timber.log.Timber;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by bachiri on 9/24/17.
 */

public class GifsFragment extends Fragment
        implements GifsContract.View, GifsHolder.GifItemListener {

    @BindView(R.id.gifs_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.gifs_progress_bar)
    ProgressBar progressBar;

    private static final String TAG = GifsFragment.class.getName();
    private GifsContract.Presenter presenter;
    private GifsAdapter gifsAdapter;

    public GifsFragment() {

    }

    public static GifsFragment getInstance() {
        return new GifsFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gifs, container, false);


        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gifsAdapter = new GifsAdapter(getActivity(), new ArrayList<Gif>());
        gifsAdapter.setItemListener(this);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(gifsAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
        Timber.d("onResume");

    }

    @Override
    public void setPresenter(@NonNull GifsContract.Presenter presenter) {
        this.presenter = checkNotNull(presenter);
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (active) progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void setOnErrorLoading() {
        Toast.makeText(getActivity(), "Connection or API problem ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showGifs(List<Gif> tasks) {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        gifsAdapter.setAdapter(tasks);
    }

    @Override
    public void showGif(Gif gif) {
        Intent intent = new Intent(getContext(), GifActivity.class);

        Gson gson = new Gson();
        String target = gson.toJson(gif);

        intent.putExtra(GifActivity.GIF_OBJECT, target);
        startActivity(intent);
    }

    @Override
    public void onItemClick(Gif gif) {
        presenter.openGif(gif);
    }
}
