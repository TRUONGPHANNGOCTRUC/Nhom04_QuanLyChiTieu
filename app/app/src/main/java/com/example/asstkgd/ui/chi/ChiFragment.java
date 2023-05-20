package com.example.asstkgd.ui.chi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.asstkgd.Adapter.ChiViewPagerAdapter;
import com.example.asstkgd.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ChiFragment extends Fragment {
    private ViewPager2 viewPager2;
    private TabLayout tableLayout;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChiFragment() {
        // Required empty public constructor
    }

    public static ChiFragment newInstance(String param1, String param2) {
        ChiFragment fragment = new ChiFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager2 = view.findViewById(R.id.view_page2);
        tableLayout = view.findViewById(R.id.tal_layout);

        ChiViewPagerAdapter adapter = new ChiViewPagerAdapter(getActivity());
        viewPager2.setAdapter(adapter);

        new TabLayoutMediator(tableLayout , viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0){
                    tab.setText("Khoản Chi");
                    tab.setIcon(R.drawable.ic_baseline_add_shopping_cart_24);
                } else
                    tab.setText("Loại Chi");
                tab.setIcon(R.drawable.ic_baseline_add_shopping_cart_24);
            }
        }).attach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chi, container, false);
    }
}