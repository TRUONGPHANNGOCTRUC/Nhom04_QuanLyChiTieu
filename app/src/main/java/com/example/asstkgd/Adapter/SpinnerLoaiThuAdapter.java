package com.example.asstkgd.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.asstkgd.Entity.LoaiThu;
import com.example.asstkgd.R;

import java.util.List;

public class SpinnerLoaiThuAdapter extends BaseAdapter {
    List<LoaiThu> list;

    public SpinnerLoaiThuAdapter(List<LoaiThu> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        LoaiThu loaiThu = list.get(position);
        return loaiThu;
    }

    @Override
    public long getItemId(int position) {
        LoaiThu loaiThu = list.get(position);
        return loaiThu.getMaLoai();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null){
            view =View.inflate(parent.getContext(), R.layout.item_spinner,null);
        } else
            view = convertView;

        final LoaiThu loaiThu = list.get(position);

        TextView  tv_name = view.findViewById(R.id.tv_sp_name);

        tv_name.setText(loaiThu.getTenLoai());


        return view;
    }
}
