package com.example.nitishsingh.android103;

import android.app.ListFragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nitish Singh on 05-08-2017.
 */

public class Fragment extends ListFragment {
    private List<ListViewItem> items;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //here we are creating the arraylist fore item
        items = new ArrayList<ListViewItem>();
        Resources resources= getResources();
        //here we are adding item
        items.add(new ListViewItem(ContextCompat.getDrawable(getActivity().getApplicationContext()
                ,R.drawable.youtube), "YouTube","YouTube Description"));

        items.add(new ListViewItem(ContextCompat.getDrawable(getActivity().getApplicationContext()
        ,R.drawable.blogger),"Blogger", "Blogger Description" ));

        //here we are initializing and set the list adapter
        setListAdapter(new ListViewAdapter(getActivity(),items));
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // remove the dividers from the ListView of the ListFragment
        getListView().setDivider(null);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        // retrieve theListView item
        ListViewItem item = items.get(position);
        // do something
        Toast.makeText(getActivity(), item.title, Toast.LENGTH_SHORT).show();

    }
}
