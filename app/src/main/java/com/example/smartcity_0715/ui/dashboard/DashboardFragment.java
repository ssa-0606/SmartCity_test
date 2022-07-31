package com.example.smartcity_0715.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.FragmentDashboardBinding;
import com.example.smartcity_0715.ui.dashboard.adapter.LeftAdapter;
import com.example.smartcity_0715.ui.home.adapter.ServiceAdapter;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        String[] types = new String[]{"车主服务","生活服务","便民服务"};
        LeftAdapter leftAdapter = new LeftAdapter(getContext(), R.layout.layout_left, types);
        binding.leftCate.setAdapter(leftAdapter);

        binding.leftCate.setOnItemClickListener((adapterView, view, i, l) -> {
            dashboardViewModel.setCityService(types[i]);
            leftAdapter.setSelect(i);
            leftAdapter.notifyDataSetChanged();
        });

        dashboardViewModel.getText().observe(requireActivity(),cityServices -> {
            binding.rightCate.setLayoutManager(new GridLayoutManager(getContext(),3));
            binding.rightCate.setAdapter(new ServiceAdapter(R.layout.layout_service,cityServices));
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}