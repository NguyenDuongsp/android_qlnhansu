package com.btl.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.btl.model.ChamCong;
import com.btl.quanlynhanvien.R;

import java.util.ArrayList;

public class ChamcongAdapter extends ArrayAdapter<ChamCong> {
    private Context context;
    private ArrayList<ChamCong> arrayList;
    private int layoutResoure;

    public ChamcongAdapter(@NonNull Context context, int resource, ArrayList<ChamCong> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layoutResoure = resource;
        this.arrayList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(layoutResoure, parent, false);
            holder.txtStt = convertView.findViewById(R.id.txt_Stt);
            holder.txtDate = convertView.findViewById(R.id.txt_date);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ChamCong chamCong = getItem(position);
        holder.txtStt.setText(String.valueOf(position + 1));
        holder.txtDate.setText(chamCong.getDate());
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.left_to_right);
        convertView.startAnimation(animation);

        return convertView;
    }

    private static class ViewHolder {
        TextView txtStt;
        TextView txtDate;
    }
}