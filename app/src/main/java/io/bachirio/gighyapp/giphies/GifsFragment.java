package io.bachirio.gighyapp.giphies;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.bachirio.gighyapp.R;
import io.bachirio.gighyapp.data.Gif;

import static com.google.common.base.Preconditions.checkNotNull;


/**
 * Created by bachiri on 9/24/17.
 */

public class GifsFragment extends Fragment implements GifsContart.View {


    @BindView(R.id.gifs_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.gifs_progress_bar)
    ProgressBar progressBar;

    private GifsContart.Presenter presenter;
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
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.gifs_fragment, container, false);

        ButterKnife.bind(this, root);
        return root;
    }


    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
        gifsAdapter = new GifsAdapter(getActivity(), new ArrayList<Gif>());
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(gifsAdapter);
    }

    @Override
    public void setPresenter(@NonNull GifsContart.Presenter presenter) {
        this.presenter = checkNotNull(presenter);
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (active)
            progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void setOnErrorLoading() {
        Toast.makeText(getActivity(), "Connection or API problem ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showTasks(List<Gif> tasks) {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        gifsAdapter.setAdapter(tasks);


    }

    private static class GifsAdapter extends RecyclerView.Adapter<GifsHolder> {
        private final RequestOptions requestOptions = new RequestOptions().centerCrop();
        private Context context;
        private List<Gif> gifList;


        public GifsAdapter(Context context, List<Gif> gifList) {
            this.context = context;
            this.gifList = gifList;
        }

        @Override
        public GifsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            return new GifsHolder(layoutInflater.inflate(R.layout.item_gif, parent, false));
        }

        @Override
        public void onBindViewHolder(GifsHolder holder, int position) {
            Gif gif = gifList.get(position);
            Glide.with(holder.gifImageView.getContext())
                    .load(gif.getGifImages().getDownsizedImage().getUrl())
                    .apply(requestOptions)
                    .into(holder.gifImageView);
        }

        @Override
        public int getItemCount() {
            return gifList.size();
        }

        public void setAdapter(List<Gif> gifList) {
            this.gifList.clear();
            this.gifList.addAll(gifList);
            notifyDataSetChanged();
        }

    }

    static class GifsHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.gif_item)
        ImageView gifImageView;

        public GifsHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
