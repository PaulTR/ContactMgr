package com.example.kdotz.contactmgr;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class NumbersAdapter extends Fragment {

    private List<String> numbersList = null;
    private ListView numbersListView = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        numbersList = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.numbers_list)));

        numbersListView = (ListView) rootView.findViewById(R.id.list_of_numbers);

        ArrayAdapter<String> contactsArrayAdapter = new ArrayAdapter<String>(rootView.getContext(), android.R.layout.simple_list_item_1, numbersList);

        numbersListView.setAdapter(contactsArrayAdapter);

        return rootView;
    }


}
