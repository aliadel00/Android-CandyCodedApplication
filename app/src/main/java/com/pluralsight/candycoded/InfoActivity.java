package com.pluralsight.candycoded;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class InfoActivity extends AppCompatActivity {
    private static final String MapUri = "geo:0,0?q=618 E South St Orlando, FL 32801";
    private static final String packageName = "com.google.android.apps.maps";
    private static final String PhoneUri = "tel:0123456789";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);


    }

    // ***
    // TODO - Task 2 - Launch the Google Maps Activity
    public void createMapIntent(View view){
        Uri mapUri;
        mapUri = Uri.parse(MapUri);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW,mapUri);
        mapIntent.setPackage(packageName);
        if(  mapIntent.resolveActivity(getPackageManager())!=null)
        startActivity(mapIntent);
    }
    // ***

    // ***
    // TODO - Task 3 - Launch the Phone Activity
    public void createPhoneIntent(View view){
        Uri phoneUri;
        phoneUri = Uri.parse(PhoneUri);
        Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
        phoneIntent.setData(phoneUri);
        startActivity(phoneIntent);
    }
    // ***
}
