package com.example.asstkgd.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.asstkgd.ui.thongke.ChiThongKe;
import com.example.asstkgd.ui.thongke.ThuThongke;


public class ThongKeAdapter extends FragmentStateAdapter {

    public ThongKeAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;
        if (position == 0){
            fragment = ThuThongke.newInstance();
        } else
            fragment = ChiThongKe.newInstance();

        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
