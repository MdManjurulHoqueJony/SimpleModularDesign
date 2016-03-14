package com.wordpress.jonyonandroidcraftsmanship.simplemodulardesign;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DescriptionFragment extends Fragment {

    private TextView tvDescription = null;
    private int position = 0;
    private static final int DEFAULT_VALUE=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_description, container, false);
        if (savedInstanceState != null) {
            position=savedInstanceState.getInt(getActivity().getString(R.string.position2),DEFAULT_VALUE);
            TextView tvTempDescription = (TextView) view.findViewById(R.id.tvDescription);
            String[] tempDescriptions=getActivity().getResources().getStringArray(R.array.descriptions);
            tvTempDescription.setText(tempDescriptions[position]);
        }
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvDescription = (TextView) getActivity().findViewById(R.id.tvDescription);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(getActivity().getString(R.string.position2),position);
    }


    public void changeData(int position) {
        String[] descriptions=getActivity().getResources().getStringArray(R.array.descriptions);
        tvDescription.setText(descriptions[position]);
        this.position=position;
    }
}
