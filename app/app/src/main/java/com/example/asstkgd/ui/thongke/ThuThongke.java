package com.example.asstkgd.ui.thongke;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.asstkgd.DAO.KhoannThuDatabase;
import com.example.asstkgd.Entity.KhoanThu;
import com.example.asstkgd.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ThuThongke extends Fragment {
        private ImageView im_end, im_start;
        private TextView tv_end,tv_start,tv_size;
        private Button btn_search;
    private ThuThongkeViewModel mViewModel;

    public static ThuThongke newInstance() {
        return new ThuThongke();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_thu_thongke, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        im_end = view.findViewById(R.id.date_pick_end);
        im_start = view.findViewById(R.id.date_pick_start);

        tv_end = view.findViewById(R.id.tv_end);
        tv_start = view.findViewById(R.id.tv_start);
        tv_size = view.findViewById(R.id.tv_size);

        im_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPickDialogDate();
            }
        });
        im_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPickDialogDate1();
            }
        });

        btn_search = view.findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String start_day = tv_start.getText().toString();
                String end_day = tv_end.getText().toString();
                List<KhoanThu> khoanChiList = new ArrayList<>();
                khoanChiList = KhoannThuDatabase.getInstance(getContext()).khoanThuDAA().getThongKe(start_day,end_day);
                tv_size.setText(khoanChiList.size()+"");
            }
        });
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ThuThongkeViewModel.class);
        // TODO: Use the ViewModel
    }
    void showPickDialogDate(){
        Calendar calendar= Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        DatePickerDialog datePickerDialog = new DatePickerDialog (getContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        int ngay = dayOfMonth;
                        int thang = month + 1;
                        int name = year;
                        tv_start.setText(name+"-"+thang+"-"+ngay);
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONDAY),
                calendar.get(Calendar.DAY_OF_MONTH)
        );

        datePickerDialog.show();
    }
    void showPickDialogDate1(){
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
                        tv_end.setText(name+"-"+thang+"-"+ngay);
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONDAY),
                calendar.get(Calendar.DAY_OF_MONTH)
        );

        datePickerDialog.show();
    }

}