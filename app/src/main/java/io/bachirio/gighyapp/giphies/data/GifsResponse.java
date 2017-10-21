package io.bachirio.gighyapp.giphies.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.bachirio.gighyapp.data.Gif;

/**
 * Created by bachiri on 9/21/17.
 */

public class GifsResponse {

    @SerializedName("data")
    private List<Gif> gifList;


    public List<Gif> getGifList() {
        return gifList;
    }

    public void setGifList(List<Gif> gifList) {
        this.gifList = gifList;
    }
}
