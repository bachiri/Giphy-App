package io.bachirio.gighyapp.giphies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.bachirio.gighyapp.R;
import io.bachirio.gighyapp.data.Gif;
import io.bachirio.gighyapp.giphies.GifsHolder.GifItemListener;

/**
 * Created by bachiri on 10/24/17.
 */

public class GifsAdapter extends RecyclerView.Adapter<GifsHolder> {
    private final RequestOptions requestOptions = new RequestOptions().centerCrop();
    private Context context;
    private List<Gif> gifList;
    private GifItemListener itemListener;

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
        final Gif gif = gifList.get(position);
        Glide.with(holder.gifImageView.getContext())
                .load(gif.getGifImages().getDownsizedImage().getUrl())
                .apply(requestOptions)
                .into(holder.gifImageView);
        holder.gifImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemListener.onItemClick(gif);
            }
        });
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

    public void setItemListener(GifItemListener itemListener) {
        this.itemListener = itemListener;
    }
}

class GifsHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.gif_item)
    ImageView gifImageView;

    public GifsHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    interface GifItemListener {
        void onItemClick(Gif gif);
    }
}
