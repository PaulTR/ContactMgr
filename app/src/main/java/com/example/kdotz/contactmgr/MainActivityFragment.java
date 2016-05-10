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

    private ListView contactsListView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);


        contactsListView = (ListView) rootView.findViewById(R.id.list_of_contacts);

        ContactAdapter contactsAdapter = new ContactAdapter(getActivity());

        contactsAdapter.add(new Contact("Mom", "1234567890"));
        contactsAdapter.add(new Contact("Dad", "0987654321"));
        contactsAdapter.add(new Contact("That sexy beast, Paul", "1800omnomnom"));
        contactsListView.setAdapter(contactsAdapter);

       contactsListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Contact item = (Contact) contactsListView.getAdapter().getItem(position);

                Intent intent = new Intent(view.getContext(), ContactDetailActivity.class);

                intent.putExtra(ContactDetailActivity.EXTRA_NAME, item.getContactName());
                intent.putExtra(ContactDetailActivity.EXTRA_NUMBER, item.getPhoneNumber());

                startActivity(intent);

            }
        });

        return rootView;
    }
}
