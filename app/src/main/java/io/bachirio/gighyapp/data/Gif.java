package io.bachirio.gighyapp.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.bachirio.gighyapp.giphies.data.GifImages;


/**
 * Created by bachiri on 9/19/17.
 */

public class Gif {

    @SerializedName("images")
    private GifImages gifImages;

    public GifImages getGifImages() {
        return gifImages;
    }

    public void setGifImages(GifImages gifImages) {
        this.gifImages = gifImages;
    }



}
