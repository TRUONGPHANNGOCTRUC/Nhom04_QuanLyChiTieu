package com.example.asstkgd.ui.thu;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asstkgd.Adapter.LoaiThuAdapter;
import com.example.asstkgd.DAO.LoaiThuDatabase;
import com.example.asstkgd.Entity.LoaiThu;
import com.example.asstkgd.R;

import java.util.ArrayList;
import java.util.List;

public class LoaiThuFragment extends Fragment {

    private LoaiThuViewModel mViewModel;
    private ImageView btn_add;
    private RecyclerView recyclerView;
    private List<LoaiThu> mList;
    LoaiThuAdapter adapter;


    public static LoaiThuFragment newInstance() {
        return new LoaiThuFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_loai_thu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_add = view.findViewById(R.id.btn_diolag_add);
        recyclerView = view.findViewById(R.id.rcv_loai_thu);
        mList = new ArrayList<>();
        adapter = new LoaiThuAdapter(new LoaiThuAdapter.IOnClick() {
            @Override
            public void delete(LoaiThu loaiThu) {
                deleteLoaiThu(loaiThu);
            }

            @Override
            public void update(LoaiThu loaiThu) {
                updateLoaiThu(loaiThu);
            }
        });


        adapter.setData(mList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        loadData();
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.dialog_add_thu);
                dialog.getWindow().setBackgroundDrawableResource(R.drawable.bo_goc_item);
                EditText ed_name= dialog.findViewById(R.id.ed_name);

                mList = new ArrayList<>();
                mList = LoaiThuDatabase.getInstance(getContext()).loaiThuDAO().getAllLoaiThu();

                Button btn_add = dialog.findViewById(R.id.btn_add);
                btn_add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String strName = ed_name.getText().toString().trim();
                        LoaiThu thu = new LoaiThu(strName);

                        if(ed_name.length() < 1){
                            ed_name.setError("Tên đăng nhập không được để trống");
                            return;
                        }
                        LoaiThuDatabase.getInstance(v.getContext()).loaiThuDAO().insertLoaiThu(thu);
                        loadData();
                        dialog.dismiss();
                        Toast.makeText(v.getContext(), "Thêm mới thành công", Toast.LENGTH_SHORT).show();
                    }
                });
                Button btn_exit = dialog.findViewById(R.id.btn_exit);
                btn_exit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LoaiThuViewModel.class);
        // TODO: Use the ViewModel
    }

    void loadData(){
        mList = LoaiThuDatabase.getInstance(getContext()).loaiThuDAO().getAllLoaiThu();
        adapter.setData(mList);
    }

    public void deleteLoaiThu(LoaiThu loaiThu){
        new AlertDialog.Builder(getContext())
                .setTitle("Xóa loại thu?")
                .setMessage("Bạn có chắc chắn xóa không?")
                .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LoaiThuDatabase.getInstance(getContext()).loaiThuDAO().deleteLoaiThu(loaiThu);
                        Toast.makeText(getContext(), "Xoá thành công", Toast.LENGTH_SHORT).show();
                        recyclerView.setAdapter(adapter);
                        loadData();
                    }
                }).show();
    }
    public void updateLoaiThu(LoaiThu loaiThu){
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.diolag_update_loai_thu);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.bo_goc_item);
        EditText ed_name = dialog.findViewById(R.id.ed_name);
        ed_name.setText(loaiThu.getTenLoai());

        Button btn_add = dialog.findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strName = ed_name.getText().toString().trim();
                loaiThu.setTenLoai(strName);
                if(ed_name.length() < 1){
                    ed_name.setError("Tên đăng nhập không được để trống");
                    return;
                }
                LoaiThuDatabase.getInstance(v.getContext()).loaiThuDAO().updateLoaiThu(loaiThu);
                recyclerView.setAdapter(adapter);
                loadData();
                dialog.dismiss();
                Toast.makeText(v.getContext(), "Cập nhật thành công", Toast.LENGTH_SHORT).show();
            }
        });
        Button btn_exit = dialog.findViewById(R.id.btn_exit);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });



        dialog.show();

    }

}