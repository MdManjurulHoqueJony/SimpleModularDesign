package com.wordpress.jonyonandroidcraftsmanship.simplemodulardesign;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TitleFragment extends Fragment implements AdapterView.OnItemClickListener{

    private Communicator communicator = null;
    private ListView lvTitles = null;
    private ArrayAdapter<CharSequence> titleArrayAdapter = null;
    private int position=0;
    private static final int DEFAULT_VALUE=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_title, container, false);
        if (savedInstanceState != null) {
            position=savedInstanceState.getInt(getActivity().getString(R.string.position),DEFAULT_VALUE);
        }
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        communicator= (Communicator) getActivity();
        lvTitles = (ListView) getActivity().findViewById(R.id.lvTitle);
        titleArrayAdapter=ArrayAdapter.createFromResource(getActivity(),R.array.titles,android.R.layout.simple_list_item_1);
        lvTitles.setAdapter(titleArrayAdapter);
        lvTitles.setAdapter(titleArrayAdapter);
        lvTitles.setOnItemClickListener(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(getActivity().getString(R.string.position),position);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        this.position=position;
        communicator.respond(position);
    }

    protected interface Communicator {
        public void respond(int postion);
    }

}
