package com.example.realsoloeat;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.soloeat.R;

public class DriveHolder {
    public ImageView typeImageView;
    public TextView rest_nameView;
    public Button clusterButton;
    public Button joinButton;

    public DriveHolder(View root){
        typeImageView = root.findViewById(R.id.custom_item_type_image);
        rest_nameView = root.findViewById(R.id.custom_item_title);
        clusterButton = root.findViewById(R.id.custom_item_cluster);
        joinButton = root.findViewById(R.id.custom_item_join);
    }
}
