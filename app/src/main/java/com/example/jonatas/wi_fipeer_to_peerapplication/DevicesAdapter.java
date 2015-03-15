package com.example.jonatas.wi_fipeer_to_peerapplication;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.net.wifi.p2p.WifiP2pDevice;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jonatas on 14/03/15.
 */
public class DevicesAdapter extends ArrayAdapter<WifiP2pDevice> {

    private Activity mContext;
    private List<WifiP2pDevice> mDevices;

    public DevicesAdapter(Activity context, Collection<WifiP2pDevice> devices) {
        super(context, R.layout.row_layout, new LinkedList<WifiP2pDevice>(devices));

        mDevices = new LinkedList<WifiP2pDevice>(devices);
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = mContext.getLayoutInflater();
            rowView = inflater.inflate(R.layout.row_layout, null);
        }

        if (mDevices.get(position) != null) {
            WifiP2pDevice device = mDevices.get(position);
            TextView text = (TextView) rowView.findViewById(R.id.deviceTextView);
            text.setText(device.deviceName +  " - "  + device.deviceAddress );
        }

        return rowView;
    }
}
