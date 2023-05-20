package com.example.asstkgd.ui.thu;

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

import com.example.asstkgd.Adapter.KhoanThuAdapter;
import com.example.asstkgd.Adapter.SpinnerLoaiThuAdapter;
import com.example.asstkgd.DAO.KhoanThuDatabase;
import com.example.asstkgd.DAO.LoaiThuDatabase;
import com.example.asstkgd.Entity.KhoanThu;
import com.example.asstkgd.Entity.LoaiThu;
import com.example.asstkgd.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class KhoanThuFragment extends Fragment {

    private KhoanThuViewModel mViewModel;
    private ImageView btn_add;
    private TextView tv_date;
    private RecyclerView rcv_list;
    List<LoaiThu> list ;
    List<KhoanThu> listKhoanThu;
    private KhoanThuAdapter khoanThuAdapter;

    public static KhoanThuFragment newInstance() {
        return new KhoanThuFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_khoan_thu, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(KhoanThuViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rcv_list = view.findViewById(R.id.rcv_khoan_thu);
        listKhoanThu = new ArrayList<>();
        khoanThuAdapter = new KhoanThuAdapter(new KhoanThuAdapter.IClickOnActivity() {
            @Override
            public void update(KhoanThu khoanThu) {
                updateKhoanThu(khoanThu);
            }

            @Override
            public void delete(KhoanThu khoanThu) {
                deleteKhoanThu(khoanThu);
            }
        });


        khoanThuAdapter.setData(listKhoanThu);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1);
        rcv_list.setLayoutManager(gridLayoutManager);
        rcv_list.setAdapter(khoanThuAdapter);
        loadData();

        btn_add = view.findViewById(R.id.btn_add_khoan_thu);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(getContext(), androidx.transition.R.style.Theme_AppCompat_DayNight_Dialog_Alert);
                dialog.setContentView(R.layout.dialog_khoan_thu);
                dialog.getWindow().setBackgroundDrawableResource(R.drawable.bo_goc_item);
                list = new ArrayList<>();

                Spinner spinner = dialog.findViewById(R.id.sp_loai);
                list = LoaiThuDatabase.getInstance(getContext()).loaiThuDAO().getAllLoaiThu();

                EditText ed_name = dialog.findViewById(R.id.ed_name);
                EditText ed_nguoi= dialog.findViewById(R.id.ed_hm_name);
                EditText ed_money = dialog.findViewById(R.id.ed_money);
                tv_date = dialog.findViewById(R.id.tv_date);
                EditText ed_note = dialog.findViewById(R.id.ed_note);

                SpinnerLoaiThuAdapter adapter = new SpinnerLoaiThuAdapter(list);
                spinner.setAdapter(adapter);


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
                        LoaiThu khoanThu = (LoaiThu) spinner.getSelectedItem();
                        String ten_loai = khoanThu.getTenLoai();

                        KhoanThu thu = new KhoanThu(ten_loai,ten_khoan_thu,date,tien,note,ten_nguoi);
                        KhoanThuDatabase.getInstance(getContext()).khoanThuDAA().insertKhoanThu(thu);
                        loadData();
                        listKhoanThu = KhoanThuDatabase.getInstance(getContext()).khoanThuDAA().getAll();
                        khoanThuAdapter.setData(listKhoanThu);
                        rcv_list.setAdapter(khoanThuAdapter);

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
        });

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
                        tv_date.setText(name+"-"+thang+"-"+ngay);
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONDAY),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }
    void loadData(){
        listKhoanThu = KhoanThuDatabase.getInstance(getContext()).khoanThuDAA().getAll();
        khoanThuAdapter.setData(listKhoanThu);
    }

    void deleteKhoanThu(KhoanThu khoanThu){
        new AlertDialog.Builder(getContext())
                .setTitle("Xóa khoản thu")
                .setMessage("Bạn có chắc chắn muốn xóa không?")
                .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        KhoanThuDatabase.getInstance(getContext()).khoanThuDAA().delete(khoanThu);
                        Toast.makeText(getContext(), "Xoá thành công", Toast.LENGTH_SHORT).show();
                        rcv_list.setAdapter(khoanThuAdapter);
                        loadData();
                    }
                }).show();
    }
    void updateKhoanThu(KhoanThu khoanThu){
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_update_khoan_thu);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.bo_goc_item);
        Spinner spinner = dialog.findViewById(R.id.sp_loai);
        list = new ArrayList<>();
        list = LoaiThuDatabase.getInstance(getContext()).loaiThuDAO().getAllLoaiThu();

        EditText ed_name = dialog.findViewById(R.id.ed_name);
        EditText ed_nguoi= dialog.findViewById(R.id.ed_hm_name);
        EditText ed_money = dialog.findViewById(R.id.ed_money);
        tv_date = dialog.findViewById(R.id.tv_date);
        EditText ed_note = dialog.findViewById(R.id.ed_note);

        SpinnerLoaiThuAdapter adapter = new SpinnerLoaiThuAdapter(list);
        spinner.setAdapter(adapter);

        ed_nguoi.setText(khoanThu.getTenNguoiThu());
        ed_money.setText(khoanThu.getSoTien());
        ed_note.setText(khoanThu.getNote());
        ed_name.setText(khoanThu.getTenKhoanThu());
        tv_date.setText(khoanThu.getNgayThu());

        for (int j = 0 ; j <list.size(); j++){
            LoaiThu loaiThu = list.get(j);
            if (loaiThu.getTenLoai().equals(khoanThu.getTenLoai())){
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
                LoaiThu loai = (LoaiThu) spinner.getSelectedItem();
                String ten_loai = loai.getTenLoai();

                khoanThu.setTenKhoanThu(ten_khoan_thu);
                khoanThu.setTenLoai(ten_loai);
                khoanThu.setNgayThu(date);
                khoanThu.setTenNguoiThu(ten_nguoi);
                khoanThu.setSoTien(tien);
                khoanThu.setNote(note);
                KhoanThuDatabase.getInstance(getContext()).khoanThuDAA().updateKhoanThu(khoanThu);
                loadData();
                rcv_list.setAdapter(khoanThuAdapter);
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

}