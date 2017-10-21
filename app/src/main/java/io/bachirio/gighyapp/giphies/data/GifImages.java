package io.bachirio.gighyapp.giphies.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bachiri on 9/21/17.
 */

public class GifImages {
    @SerializedName("fixed_height_downsampled")
    private GifSize downsizedGif;

    @SerializedName("fixed_height_still")
    private GifSize downsizedImage;


    public GifSize getDownsizedGif() {
        return downsizedGif;
    }

    public void setDownsizedGif(GifSize downsizedGif) {
        this.downsizedGif = downsizedGif;
    }

    public GifSize getDownsizedImage() {
        return downsizedImage;
    }

    public void setDownsizedImage(GifSize downsizedImage) {
        this.downsizedImage = downsizedImage;
    }
}
