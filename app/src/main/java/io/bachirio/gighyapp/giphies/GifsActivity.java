package io.bachirio.gighyapp.giphies;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.bachirio.gighyapp.R;
import io.bachirio.gighyapp.data.source.GifsRemoteDataSource;


public class GifsActivity extends AppCompatActivity {

    private GifsPresenter gifsPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GifsFragment gifsFragment = (GifsFragment) getFragmentManager().findFragmentById(R.id.gifs_container);

        if (gifsFragment == null) {
            gifsFragment = GifsFragment.getInstance();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.gifs_container, gifsFragment);
            ft.commit();
        }

        gifsPresenter = new GifsPresenter(gifsFragment, new GifsRemoteDataSource());


    }

}
