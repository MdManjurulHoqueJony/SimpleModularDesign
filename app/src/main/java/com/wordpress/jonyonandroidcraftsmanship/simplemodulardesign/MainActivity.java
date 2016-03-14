package com.wordpress.jonyonandroidcraftsmanship.simplemodulardesign;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements TitleFragment.Communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void respond(int position) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        DescriptionFragment descriptionFragment= (DescriptionFragment) fragmentManager.findFragmentById(R.id.frgDescriptions);
        descriptionFragment.changeData(position);
    }
}
