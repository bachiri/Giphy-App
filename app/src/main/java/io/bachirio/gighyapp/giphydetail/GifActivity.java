package io.bachirio.gighyapp.giphydetail;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;

import io.bachirio.gighyapp.R;
import io.bachirio.gighyapp.data.Gif;

public class GifActivity extends AppCompatActivity {

    public static String GIF_OBJECT = "gif_object";
    private GifPresenter gifPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);

        GifFragment gifFragment =
                (GifFragment) getSupportFragmentManager().findFragmentById(R.id.gif_container);

        if (gifFragment == null) {
            gifFragment = GifFragment.getInstance();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.gif_container, gifFragment);
            ft.commit();
        }

        Gson gson = new Gson();
        String gifString = getIntent().getStringExtra(GIF_OBJECT);
        Gif gif = gson.fromJson(gifString, Gif.class);

        gifPresenter = new GifPresenter(gifFragment, gif);
    }
}
