package com.example.smartcity_0715.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.bumptech.glide.Glide;
import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.FragmentHomeBinding;
import com.example.smartcity_0715.pojo.CityService;
import com.example.smartcity_0715.pojo.LunBo;
import com.example.smartcity_0715.pojo.PressCate;
import com.example.smartcity_0715.tools.MyNetManger;
import com.example.smartcity_0715.ui.home.adapter.HotAdapter;
import com.example.smartcity_0715.ui.home.adapter.PressAdapter;
import com.example.smartcity_0715.ui.home.adapter.ServiceAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        homeViewModel.getLunbos().observe(requireActivity(),lunBos -> {
            for (LunBo lunBo : lunBos) {
                ImageView imageView = new ImageView(getContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                Glide.with(getContext()).load(MyNetManger.SERVER_IP+lunBo.getAdvImg()).into(imageView);
                binding.homeVf.addView(imageView);
            }
        });

        homeViewModel.getServiceList().observe(requireActivity(),cityServices -> {
            cityServices.sort((t1,t2)->t2.getSort()-t1.getSort());
            List<CityService> list = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                list.add(cityServices.get(i));
            }
            CityService cityService = new CityService();
            cityService.setServiceName("全部服务");
            list.add(cityService);
            binding.homeService.setLayoutManager(new GridLayoutManager(getContext(),5));
            binding.homeService.setAdapter(new ServiceAdapter(R.layout.layout_service,list));
        });

        homeViewModel.getHotList().observe(requireActivity(),presses -> {
            binding.hotPress.setLayoutManager(new GridLayoutManager(getContext(),2));
            binding.hotPress.setAdapter(new HotAdapter(R.layout.layout_hot,presses));
        });

        homeViewModel.getCateList().observe(requireActivity(),pressCates -> {
            for (PressCate pressCate : pressCates) {
                binding.homeTab.addTab(binding.homeTab.newTab().setText(pressCate.getName()).setTag(pressCate.getId()));
            }
        });

        homeViewModel.getPressList().observe(requireActivity(),presses -> {
            binding.homePress.setLayoutManager(new GridLayoutManager(getContext(),1));
            binding.homePress.setAdapter(new PressAdapter(R.layout.layout_press,presses));
        });

        binding.homeTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                homeViewModel.setPressList((Integer) tab.getTag());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}