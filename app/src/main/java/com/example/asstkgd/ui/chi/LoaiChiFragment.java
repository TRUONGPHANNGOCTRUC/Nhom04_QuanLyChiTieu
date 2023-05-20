package com.example.asstkgd.ui.chi;

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

import com.example.asstkgd.Adapter.LoaiChiAdapter;
import com.example.asstkgd.DAO.LoaiChiDatebase;
import com.example.asstkgd.Entity.LoaiChi;
import com.example.asstkgd.R;

import java.util.ArrayList;
import java.util.List;

public class LoaiChiFragment extends Fragment {

    private LoaiChiViewModel mViewModel;
    private ImageView btn_add;
    private RecyclerView recyclerView;
    private List<LoaiChi> mList;
    private LoaiChiAdapter adapter;
    public static LoaiChiFragment newInstance() {
        return new LoaiChiFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_loai_chi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn_add = view.findViewById(R.id.btn_diolag_add_chi);
        recyclerView = view.findViewById(R.id.rcv_loai_chi);
        mList = new ArrayList<>();
        adapter = new LoaiChiAdapter(new LoaiChiAdapter.IOnClick() {
            @Override
            public void update(LoaiChi loaiChi) {
                        updateLoaiChi(loaiChi);
            }
            @Override
            public void delete(LoaiChi loaiChi) {
                deleteLoaiChi(loaiChi);
            }
        });

        adapter.setDate(mList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        loadData();

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.dialog_add_chi);
                dialog.getWindow().setBackgroundDrawableResource(R.drawable.bo_goc_item);

                EditText ed_name= dialog.findViewById(R.id.ed_name);

                Button btn_add = dialog.findViewById(R.id.btn_add);
                btn_add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String strName = ed_name.getText().toString();
                        LoaiChi loaiChi = new LoaiChi(strName);

                        if(ed_name.length() < 1){
                                ed_name.setError("Tên đăng nhập không được để trống");
                                return;
                        }
                        ed_name.setError("");
                        LoaiChiDatebase.getInstance(getContext()).loaiChiDAO().insertLoaiChi(loaiChi);
                        loadData();
                        recyclerView.setAdapter(adapter);
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
        mViewModel = new ViewModelProvider(this).get(LoaiChiViewModel.class);
        // TODO: Use the ViewModel
    }
    void loadData(){
        mList = LoaiChiDatebase.getInstance(getContext()).loaiChiDAO().getAllLoaiChi();
        adapter.setDate(mList);
    }

    public void deleteLoaiChi(LoaiChi loaiThu){
        new AlertDialog.Builder(getContext())
                .setTitle("Xóa loại chi ?")
                .setMessage("Bạn có chắc chắn muốn xóa không ?")
                .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LoaiChiDatebase.getInstance(getContext()).loaiChiDAO().deleteLoaiChi(loaiThu);
                        Toast.makeText(getContext(), "Xoá thành công", Toast.LENGTH_SHORT).show();
                        recyclerView.setAdapter(adapter);
                        loadData();
                    }
                }).show();
    }
    public void updateLoaiChi(LoaiChi loaiThu){
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.diolag_update_loai_chi);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.bo_goc_item);
        EditText ed_name = dialog.findViewById(R.id.ed_name);
        ed_name.setText(loaiThu.getTenLoai());

        Button btn_add = dialog.findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strName = ed_name.getText().toString().trim();

                if(ed_name.length() < 1){
                    ed_name.setError("Tên đăng nhập không được để trống");
                    return;
                }
                ed_name.setError("");
                loaiThu.setTenLoai(strName);
                LoaiChiDatebase.getInstance(getContext()).loaiChiDAO().updateLoaiChi(loaiThu);
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