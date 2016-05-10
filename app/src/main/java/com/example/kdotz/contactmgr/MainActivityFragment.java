package com.example.kdotz.contactmgr;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.example.kdotz.contactmgr.NumbersAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    private List<String> contactsList = null;
    private ListView contactsListView = null;
    private List<String> numbersList = null;
    private ListView numbersListView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        contactsList = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.contacts_list)));

        contactsListView = (ListView) rootView.findViewById(R.id.list_of_contacts);

        ArrayAdapter<String> contactsArrayAdapter = new ArrayAdapter<String>(rootView.getContext(), android.R.layout.simple_list_item_1, contactsList);

        contactsListView.setAdapter(contactsArrayAdapter);

       contactsListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                String item = (String) contactsListView.getItemAtPosition(position);

                Intent intent = new Intent(view.getContext(), ContactDetailActivity.class);

                intent.putExtra("item", item);

                startActivity(intent);

            }
        });

        return rootView;
    }
}
