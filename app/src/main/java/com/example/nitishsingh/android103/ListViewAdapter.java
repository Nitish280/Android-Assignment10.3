package com.example.nitishsingh.android103;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static com.example.nitishsingh.android103.R.id.parent;

/**
 * Created by Nitish Singh on 05-08-2017.
 */

public class ListViewAdapter extends ArrayAdapter {

    Context context;

    public ListViewAdapter(Context context,List<ListViewItem> items) {
        super(context, R.layout.listrow_item, items);

        this.context = context;
    }

    private static class ViewHolder {
        ImageView imgIcon;
        TextView txtTitle;
        TextView txtDescription;
    }
    @Override
    public View getView(int position,  View convertView, ViewGroup parent){

        ViewHolder viewHolder;

        if(convertView == null) {
        //here we are inflate the GridView item layout
        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.listrow_item, parent, false);

        //here we are initializing the view holder
        viewHolder = new ViewHolder();
        viewHolder.imgIcon = (ImageView) convertView.findViewById(R.id.imgIcon);
        viewHolder.txtTitle = (TextView) convertView.findViewById(R.id.txtTitle);
        viewHolder.txtDescription = (TextView) convertView.findViewById(R.id.txtDescription);
        convertView.setTag(viewHolder);
    } else {
        //here we are recycling the already inflated view
        viewHolder = (ViewHolder) convertView.getTag();
    }
    //here we are updating the item view
        ListViewItem listItem= (ListViewItem) getItem(position);
        viewHolder.imgIcon.setImageDrawable(listItem.icon);
        viewHolder.txtTitle.setText(listItem.title);
        viewHolder.txtDescription.setText(listItem.description);

        return convertView;
}

}

