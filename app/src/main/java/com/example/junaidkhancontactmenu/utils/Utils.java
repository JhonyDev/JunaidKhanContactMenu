package com.example.junaidkhancontactmenu.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import androidx.core.app.ActivityCompat;

import com.example.junaidkhancontactmenu.pojo.ListItemPojo;

public class Utils {

    public static boolean isStoragePermissionGranted(Context context) {
        if (context.checkSelfPermission(Manifest.permission.CALL_PHONE)
                == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CALL_PHONE}, 1);
            return false;
        }
    }

    public static void sendSMS(Context context, ListItemPojo listItem) {
        Uri sms_uri = Uri.parse("smsto:" + listItem.phoneNumber);
        Intent sms_intent = new Intent(Intent.ACTION_SENDTO, sms_uri);
        sms_intent.putExtra("sms_body", "");
        context.startActivity(sms_intent);
    }

    public static void makeCall(Context context, ListItemPojo listItem) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + listItem.phoneNumber));
        context.startActivity(intent);
    }

}
