package com.example.asstkgd.ui.chi;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asstkgd.Adapter.KhoanChiAdapter;
import com.example.asstkgd.Adapter.SpinnerLoaiChiAdapter;
import com.example.asstkgd.DAO.KhoanChiDatabase;
import com.example.asstkgd.DAO.KhoannThuDatabase;
import com.example.asstkgd.DAO.LoaiChiDatebase;
import com.example.asstkgd.Entity.KhoanChi;
import com.example.asstkgd.Entity.LoaiChi;
import com.example.asstkgd.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class KhoanChiFragment extends Fragment {

    private KhoanChiViewModel mViewModel;
    private ImageView btn_add;
    private TextView tv_date;
    private RecyclerView rcv_list;
    List<LoaiChi> list ;
    List<KhoanChi> khoanChiList;
    KhoanChiAdapter khoanChiAdapter;
    public static KhoanChiFragment newInstance() {
        return new KhoanChiFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_khoan_chi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rcv_list = view.findViewById(R.id.rcv_khoan_chi);
        khoanChiList = new ArrayList<>();
        khoanChiAdapter = new KhoanChiAdapter(new KhoanChiAdapter.IClickOnItem() {
            @Override
            public void update(KhoanChi khoanChi) {
                updateKhoanChi(khoanChi);
            }

            @Override
            public void delete(KhoanChi khoanChi) {
                    deleteKhoanChi(khoanChi);
            }
        });
        khoanChiAdapter.setData(khoanChiList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1);
        rcv_list.setLayoutManager(gridLayoutManager);
        rcv_list.setAdapter(khoanChiAdapter);
        loadData();


        btn_add = view.findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.dialog_khoan_chi);
                dialog.getWindow().setBackgroundDrawableResource(R.drawable.bo_goc_item);
                Spinner spinner = dialog.findViewById(R.id.sp_loai);
                list = new ArrayList<>();

                Spinner spinner1 = dialog.findViewById(R.id.sp_loai);
                list = LoaiChiDatebase.getInstance(getContext()).loaiChiDAO().getAllLoaiChi();

                EditText ed_name = dialog.findViewById(R.id.ed_name);
                EditText ed_nguoi= dialog.findViewById(R.id.ed_hm_name);
                EditText ed_money = dialog.findViewById(R.id.ed_money);
                tv_date = dialog.findViewById(R.id.tv_date);
                EditText ed_note = dialog.findViewById(R.id.ed_note);

                SpinnerLoaiChiAdapter adapter = new SpinnerLoaiChiAdapter(list);
                spinner1.setAdapter(adapter);


                ImageView dialogDatePicker = dialog.findViewById(R.id.datePicker);
                dialogDatePicker.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showPickDialogDate();
                    }
                });

                Button btn_add_new_chi = dialog.findViewById(R.id.btn_add);
                btn_add_new_chi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String ten_khoan_thu = ed_name.getText().toString().trim();
                        String ten_nguoi = ed_nguoi.getText().toString().trim();
                        String tien = ed_money.getText().toString().trim();
                        String date = tv_date.getText().toString();
                        String note = ed_note.getText().toString().trim();

                        if(ed_name.length() < 1){
                            ed_name.setError("Tên đăng nhập không được để trống");
                            return;
                        }
                        ed_name.setError("");

                        if(ed_nguoi.length() < 1){
                            ed_nguoi.setError("Tên đăng nhập không được để trống");
                            return;
                        }
                        ed_nguoi.setError("");

                        if(ed_money.length() < 1){
                            ed_money.setError("Tên đăng nhập không được để trống");
                            return;
                        }
                        ed_money.setError("");

                        if(ed_note.length() < 1){
                            ed_note.setError("Tên đăng nhập không được để trống");
                            return;
                        }
                        ed_note.setError("");

                        LoaiChi loaiChi = (LoaiChi) spinner1.getSelectedItem();
                        String ten_loai = loaiChi.getTenLoai();

                        KhoanChi khoanChi = new KhoanChi(ten_loai,ten_khoan_thu,date,tien,note,ten_nguoi);
                        khoanChiList = KhoanChiDatabase.getInstance(getContext()).khoanChiDAO().getAll();
                        khoanChiAdapter.setData(khoanChiList);
                        rcv_list.setAdapter(khoanChiAdapter);

                        KhoanChiDatabase.getInstance(getContext()).khoanChiDAO().insert(khoanChi);
                        loadData();


                        Toast.makeText(getContext(),"Thêm thành công",Toast.LENGTH_SHORT).show();

                        dialog.dismiss();
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

    private void deleteKhoanChi(KhoanChi khoanChi) {
        new AlertDialog.Builder(getContext())
                .setTitle("Xóa Khoản Chi")
                .setIcon(android.R.drawable.ic_delete)
                .setMessage("Bạn có chắc chắn xoá không ?")
                .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        KhoanChiDatabase.getInstance(getContext()).khoanChiDAO().delete(khoanChi);
                        rcv_list.setAdapter(khoanChiAdapter);
                        loadData();
                        Toast.makeText(getContext(),"Xoá thành công",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    private void updateKhoanChi(KhoanChi khoanChi) {
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_update_khoan_chi);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.bo_goc_item);
        Spinner spinner = dialog.findViewById(R.id.sp_loai);
        list = new ArrayList<>();
        list = LoaiChiDatebase.getInstance(getContext()).loaiChiDAO().getAllLoaiChi();

        EditText ed_name = dialog.findViewById(R.id.ed_name);
        EditText ed_nguoi= dialog.findViewById(R.id.ed_hm_name);
        EditText ed_money = dialog.findViewById(R.id.ed_money);
        tv_date = dialog.findViewById(R.id.tv_date);
        EditText ed_note = dialog.findViewById(R.id.ed_note);

        SpinnerLoaiChiAdapter adapter = new SpinnerLoaiChiAdapter(list);
        spinner.setAdapter(adapter);

        ed_nguoi.setText(khoanChi.getTenNguoiChi());
        ed_money.setText(khoanChi.getSoTien());
        ed_note.setText(khoanChi.getNote());
        ed_name.setText(khoanChi.getTenKhoanChi());
        tv_date.setText(khoanChi.getNgayThu());

        for (int j = 0 ; j <list.size(); j++){
            LoaiChi loaiThu = list.get(j);
            if (loaiThu.getTenLoai().equals(khoanChi.getTenLoai())){
                spinner.setSelection(j);
                spinner.setSelected(true);
            }
        }

        ImageView dialogDatePicker = dialog.findViewById(R.id.datePicker);
        dialogDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPickDialogDate();
            }
        });
        Button btn_add = dialog.findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten_khoan_thu = ed_name.getText().toString().trim();
                String ten_nguoi = ed_nguoi.getText().toString().trim();
                String tien = ed_money.getText().toString().trim();
                String date = tv_date.getText().toString();
                String note = ed_note.getText().toString().trim();
                LoaiChi loaiChi =(LoaiChi) spinner.getSelectedItem();
                String loaiChi1 = loaiChi.getTenLoai();

                if(ed_name.length() < 1){
                    ed_name.setError("Tên đăng nhập không được để trống");
                    return;
                }
                ed_name.setError("");

                if(ed_nguoi.length() < 1){
                    ed_nguoi.setError("Tên đăng nhập không được để trống");
                    return;
                }
                ed_nguoi.setError("");

                if(ed_money.length() < 1){
                    ed_money.setError("Tên đăng nhập không được để trống");
                    return;
                }
                ed_money.setError("");

                if(ed_note.length() < 1){
                    ed_note.setError("Tên đăng nhập không được để trống");
                    return;
                }
                ed_note.setError("");

                khoanChi.setTenKhoanChi(ten_khoan_thu);
                khoanChi.setTenLoai(loaiChi1);
                khoanChi.setNgayThu(date);
                khoanChi.setTenNguoiChi(ten_nguoi);
                khoanChi.setSoTien(tien);
                khoanChi.setNote(note);

                KhoanChiDatabase.getInstance(getContext()).khoanChiDAO().update(khoanChi);
                Toast.makeText(getContext(),"Cập nhật thành công", Toast.LENGTH_SHORT).show();
                loadData();

                rcv_list.setAdapter(khoanChiAdapter);
                dialog.dismiss();
            }
        });
        Button btn_exit  = dialog.findViewById(R.id.btn_exit);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(KhoanChiViewModel.class);
        // TODO: Use the ViewModel
    }
    void showPickDialogDate(){
        // lệnh hiển thị dialog chon ngày
        Calendar calendar= Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        DatePickerDialog datePickerDialog = new DatePickerDialog (getContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        int ngay = dayOfMonth;
                        int thang = month + 1;
                        int name = year;
                        tv_date.setText(name+"/"+thang+"/"+ngay);
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONDAY),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }
    void loadData(){
        khoanChiList = KhoanChiDatabase.getInstance(getContext()).khoanChiDAO().getAll();
        khoanChiAdapter.setData(khoanChiList);
    }

}