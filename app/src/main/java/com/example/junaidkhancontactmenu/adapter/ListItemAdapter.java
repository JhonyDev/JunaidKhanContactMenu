package com.example.junaidkhancontactmenu.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.junaidkhancontactmenu.R;
import com.example.junaidkhancontactmenu.pojo.ListItemPojo;
import com.example.junaidkhancontactmenu.utils.Utils;

import java.util.List;

public class ListItemAdapter extends ArrayAdapter<ListItemPojo> {

    private final Context context;

    public ListItemAdapter(Context context, List<ListItemPojo> items) {
        super(context, R.layout.list_item_layout, items);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_layout, null);

        if (getItem(position) == null)
            return convertView;

        ((TextView) convertView.findViewById(R.id.tv_name)).setText(getItem(position).contactName);
        ((ImageView) convertView.findViewById(R.id.iv_user_profile)).setBackgroundResource(getItem(position).contactImage);
        View finalConvertView = convertView;
        convertView.findViewById(R.id.ib_call).setOnClickListener(v1 -> {
            finalConvertView.findViewById(R.id.ib_call).animate().rotationBy(360).setDuration(500);
            new Handler().postDelayed(() -> {
                if (Utils.isStoragePermissionGranted(context))
                    Utils.makeCall(context, getItem(position));
                else
                    Toast.makeText(context, "Please Grant Permission", Toast.LENGTH_SHORT).show();
            }, 500);
        });
        convertView.findViewById(R.id.ib_sms).setOnClickListener(v1 -> {
            finalConvertView.findViewById(R.id.ib_sms).animate().rotationBy(360).setDuration(500);
            new Handler().postDelayed(() -> Utils.sendSMS(context, getItem(position)), 500);
        });

        return convertView;
    }


}
