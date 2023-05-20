package com.example.asstkgd.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asstkgd.Entity.LoaiChi;
import com.example.asstkgd.R;

import java.util.List;

public class LoaiChiAdapter extends RecyclerView.Adapter<LoaiChiAdapter.ChiViewHolder> {
    private List<LoaiChi> mList;
    private  IOnClick iOnClick;

    public LoaiChiAdapter(IOnClick iOnClick) {
        this.iOnClick = iOnClick;
    }

    public LoaiChiAdapter() {
    }

    public interface IOnClick{
        void update(LoaiChi loaiChi);
        void delete(LoaiChi loaiChi);
    }
    public void setData(List<LoaiChi> list){
        this.mList = list;
    }
    @NonNull
    @Override
    public ChiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loai_thu, parent, false);
        return new ChiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChiViewHolder holder, int position) {
        LoaiChi loaiChi = mList.get(position);
        if (loaiChi == null){
            return;
        }
        holder.initData(loaiChi,position);
    }

    @Override
    public int getItemCount() {
        if (mList != null){
            return mList.size();
        }
        return 0;
    }

     class ChiViewHolder extends RecyclerView.ViewHolder{
        private TextView ed_name;
        private ImageView btn_delete;
        private ImageView btn_update;
        public ChiViewHolder(@NonNull View itemView) {
            super(itemView);
            ed_name = itemView.findViewById(R.id.tv_name);
            btn_update = itemView.findViewById(R.id.btn_edit_loai_thu);
            btn_delete = itemView.findViewById(R.id.btn_delete_loai_thu);

        }
        private void initData(LoaiChi loaiChi, int i){
            ed_name.setText(loaiChi.getTenLoai());
            btn_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iOnClick.delete(loaiChi);
                }
            });
            btn_update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iOnClick.update(loaiChi);
                }
            });

        }
    }

}
