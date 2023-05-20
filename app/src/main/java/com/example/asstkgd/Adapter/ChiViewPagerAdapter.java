package com.example.asstkgd.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.asstkgd.ui.chi.KhoanChiFragment;
import com.example.asstkgd.ui.chi.LoaiChiFragment;
import com.google.android.material.tabs.TabLayout;

public class ChiViewPagerAdapter extends FragmentStateAdapter {
    private ViewPager2 viewPager2;
    private TabLayout tableLayout;

    public ChiViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;
        if (position == 0){
            fragment = KhoanChiFragment.newInstance();
        } else
            fragment = LoaiChiFragment.newInstance();

        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
