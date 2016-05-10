package com.example.kdotz.contactmgr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ContactAdapter extends ArrayAdapter<Contact> {

    public ContactAdapter(Context context) {
        this(context, 0);
    }

    public ContactAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate( android.R.layout.simple_list_item_1, parent, false );
            holder.name = (TextView) convertView.findViewById( android.R.id.text1 );
            convertView.setTag( holder );
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText( getItem( position ).getContactName() );

        return convertView;
    }

    class ViewHolder {
        TextView name;
    }
}
