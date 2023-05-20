package com.example.asstkgd.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.asstkgd.Entity.LoaiThu;
import com.example.asstkgd.R;

import java.util.List;

public class LoaiThuAdapter extends RecyclerView.Adapter<LoaiThuAdapter.LoaiThuViewHolder> {
    public  List<LoaiThu> mList;
    private IOnClick iOnClick;

    public LoaiThuAdapter(IOnClick iOnClick) {
        this.iOnClick = iOnClick;
    }

    public LoaiThuAdapter() {
    }

    public interface IOnClick {
        void delete(LoaiThu loaiThu);
        void update(LoaiThu loaiThu);
    }

    public void  setData(List<LoaiThu> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public LoaiThuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loai_thu, parent, false);
        return new LoaiThuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoaiThuViewHolder holder, int position) {
        LoaiThu loaiThu = mList.get(position);
        if (loaiThu == null){
            return;
        } else
            holder.initData(loaiThu, position);

    }

    @Override
    public int getItemCount() {
        if (mList != null){
            return mList.size();
        }

        return 0;
    }

    class LoaiThuViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private ImageView btn_delete;
        private ImageView btn_update;
        public LoaiThuViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            btn_delete = itemView.findViewById(R.id.btn_delete_loai_thu);
            btn_update = itemView.findViewById(R.id.btn_edit_loai_thu);
        }
        public void initData(LoaiThu loaiThu, int i){
            name.setText(loaiThu.getTenLoai());
            btn_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iOnClick.delete(loaiThu);
                }
            });
            btn_update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iOnClick.update(loaiThu);
                }
            });

        }

    }




}
