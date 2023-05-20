package com.example.asstkgd.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asstkgd.Entity.KhoanThu;
import com.example.asstkgd.R;

import java.util.List;

public class KhoanThuAdapter extends RecyclerView.Adapter<KhoanThuAdapter.KhoanThuViewHodler> {
    private List<KhoanThu> list;
    private IClickOnActivity iClickOnActivity;

    public KhoanThuAdapter(IClickOnActivity iClickOnActivity) {
        this.iClickOnActivity = iClickOnActivity;
    }

    public interface IClickOnActivity{
        void update(KhoanThu khoanThu);
        void delete(KhoanThu khoanThu);
    }

    public   void setData(List<KhoanThu> list){
        this.list = list;
    }
    @NonNull
    @Override
    public KhoanThuViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_khoan_thu,parent,false);
        return new KhoanThuViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KhoanThuViewHodler holder, int position) {
        KhoanThu khoanThu = list.get(position);
        if (khoanThu == null){
            return;
        }else
            holder.initData(khoanThu,position);


    }

    @Override
    public int getItemCount() {
        if (list != null){
            return list.size();
        }
        return 0;
    }

    class KhoanThuViewHodler extends RecyclerView.ViewHolder{
        private TextView tv_name, tv_nguoi_thu, tv_note, tv_money,tv_date,tv_ten_loai;
        private ImageView btn_delete, btn_update;

        public KhoanThuViewHodler(@NonNull View itemView) {
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
        void initData(KhoanThu khoanThu, int i){
            tv_name.setText(khoanThu.getTenKhoanThu());
            tv_nguoi_thu.setText(khoanThu.getTenNguoiThu());
            tv_date.setText(khoanThu.getNgayThu());
            tv_money.setText(khoanThu.getSoTien());
            tv_note.setText(khoanThu.getNote());
            tv_ten_loai.setText(khoanThu.getTenLoai());
            btn_update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iClickOnActivity.update(khoanThu);
                }
            });
            btn_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iClickOnActivity.delete(khoanThu);
                }
            });

        }

    }


}
