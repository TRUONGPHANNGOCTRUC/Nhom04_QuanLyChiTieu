package com.example.asstkgd.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.asstkgd.Entity.LoaiChi;
import com.example.asstkgd.R;

import java.util.List;

public class SpinnerLoaiChiAdapter extends BaseAdapter {
    List<LoaiChi> list;

    public SpinnerLoaiChiAdapter(List<LoaiChi> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        LoaiChi loaiChi = list.get(position);
        return loaiChi;
    }

    @Override
    public long getItemId(int position) {
        LoaiChi loaiChi = list.get(position);
        return loaiChi.getMaLoai();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null){
            view = View.inflate(parent.getContext(), R.layout.item_spinner,null);
        } else
            view=convertView;

        final LoaiChi loaiChi = list.get(position);
        TextView tv_name = view.findViewById(R.id.tv_sp_name);

        tv_name.setText(loaiChi.getTenLoai());
        return view;
    }
}
