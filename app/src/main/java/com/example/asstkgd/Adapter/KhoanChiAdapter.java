package com.example.asstkgd.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asstkgd.Entity.KhoanChi;
import com.example.asstkgd.R;

import java.util.List;

public class KhoanChiAdapter extends RecyclerView.Adapter<KhoanChiAdapter.KhoanChiViewHolder> {
    List<KhoanChi> list;
    private IClickOnItem iClickOnItem;

    public KhoanChiAdapter(IClickOnItem iClickOnItem) {
        this.iClickOnItem = iClickOnItem;
    }

    public void setData(List<KhoanChi> list1){
        this.list= list1;
    }
    public interface IClickOnItem{
        void update(KhoanChi khoanChi);
        void delete(KhoanChi khoanChi);
    }
    @NonNull
    @Override
    public KhoanChiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_khoan_chi,parent,false);
        return new KhoanChiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KhoanChiViewHolder holder, int position) {
        KhoanChi khoanChi = list.get(position);
        if (khoanChi == null){
            return;
        } else
            holder.initData(khoanChi,position);
    }

    @Override
    public int getItemCount() {
        if (list != null){
            return list.size();
        }
        return 0;
    }

    class KhoanChiViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name, tv_nguoi_thu, tv_note, tv_money,tv_date,tv_ten_loai;
        private ImageView btn_delete, btn_update;
        public KhoanChiViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name_khoan);
            tv_nguoi_thu = itemView.findViewById(R.id.tv_name_thu);
            tv_note = itemView.findViewById(R.id.tv_note);
            tv_money = itemView.findViewById(R.id.tv_moneny);
            tv_date = itemView.findViewById(R.id.tv_date_hien);
            tv_ten_loai = itemView.findViewById(R.id.tv_ten_loai);

            btn_update = itemView.findViewById(R.id.btn_edit_loai_thu);
            btn_delete = itemView.findViewById(R.id.btn_delete_loai_thu);
        }
        void initData(KhoanChi khoanThu, int i){
            tv_name.setText(khoanThu.getTenKhoanChi());
            tv_nguoi_thu.setText(khoanThu.getTenNguoiChi());
            tv_date.setText(khoanThu.getNgayThu());
            tv_money.setText(khoanThu.getSoTien());
            tv_note.setText(khoanThu.getNote());
            tv_ten_loai.setText(khoanThu.getTenLoai());
            btn_update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iClickOnItem.update(khoanThu);
                }
            });
            btn_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iClickOnItem.delete(khoanThu);
                }
            });

        }
    }
}
