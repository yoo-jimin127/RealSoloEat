package com.example.realsoloeat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

import com.example.soloeat.R;

import java.util.ArrayList;

public class DriveAdapter extends ArrayAdapter<DriveVO>  {
//implements View.OnClickListener
    //private ListBtnClickListener listBtnClickListener = null;

    //public interface ListBtnClickListener {
    //    void onListBtnClick(int position, int resourceid);
    //}

    Context context;
    int resId;
    ArrayList<DriveVO> data;
    /*
        public DriveAdapter(Context context, int resId, ArrayList<DriveVO> data, ListBtnClickListener listBtnClickListener){
            super(context, resId);
            this.context = context;
            this.resId = resId;
            this.data = data;
            this.listBtnClickListener = listBtnClickListener;
        }
    */
    public DriveAdapter(Context context, int resId, ArrayList<DriveVO> data){
        super(context, resId);
        this.context = context;
        this.resId = resId;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resId, null);
            DriveHolder holder = new DriveHolder(convertView);
            convertView.setTag(holder);
        }

        DriveHolder holder = (DriveHolder)convertView.getTag();

        ImageView typeImageView = holder.typeImageView;
        TextView rest_nameView = holder.rest_nameView;
        //Button clusterButton = holder.clusterButton;
        //Button joinButton = holder.joinButton;

        final DriveVO vo = data.get(position);

        rest_nameView.setText(vo.rest_name);
        //안될경우 xml에서 이미지 빼보자
        typeImageView.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), R.drawable.restaurant, null));

        //여기부터 다시 시도
        Button clusterButton = (Button) convertView.findViewById(R.id.custom_item_cluster);
        clusterButton.setOnClickListener((View.OnClickListener)context);
        clusterButton.setTag(vo.toString());

        Button joinButton = (Button) convertView.findViewById(R.id.custom_item_join);
        joinButton.setOnClickListener((View.OnClickListener)context);
        joinButton.setTag(vo.toString());

        //clusterButton.setTag(position);
        //clusterButton.setOnClickListener(this);

        //joinButton.setTag(position);
        //joinButton.setOnClickListener(this);



        return convertView;

    }
/*
    @Override
    public void onClick(View view){
        if(this.listBtnClickListener != null){
            this.listBtnClickListener.onListBtnClick((int)view.getTag(), view.getId());
        }
    }
*/
}
