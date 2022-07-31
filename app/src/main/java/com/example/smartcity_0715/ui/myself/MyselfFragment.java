package com.example.smartcity_0715.ui.myself;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.RoundedCorner;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.FragmentMyselfBinding;
import com.example.smartcity_0715.pojo.UserInfo;
import com.example.smartcity_0715.tools.MyNetManger;
import com.example.smartcity_0715.tools.MyTaskManger;

public class MyselfFragment extends Fragment {

    private MyselfViewModel mViewModel;
    FragmentMyselfBinding binding;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public static MyselfFragment newInstance() {
        return new MyselfFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMyselfBinding.inflate(inflater);
        sharedPreferences = getActivity().getSharedPreferences("data",0);
        editor = sharedPreferences.edit();

        getData();

        binding.myselfLogin.setOnClickListener(view -> {
            if(TextUtils.equals("点击登录",binding.myselfNick.getText())){
                Intent intent = new Intent(getActivity(),LogInActivity.class);
                startActivity(intent);
            }
        });

        binding.logOut.setOnClickListener(view -> {
            if(TextUtils.equals("点击登录",binding.myselfNick.getText())){
                Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
            }else{
                editor.clear();
                editor.commit();
                getActivity().runOnUiThread(()->{
                    Toast.makeText(getActivity(), "您已经成功退出登录", Toast.LENGTH_SHORT).show();
                });
                getData();
            }
        });

        binding.userInfo.setOnClickListener(view -> {
            if(TextUtils.equals("点击登录",binding.myselfNick.getText())){
                Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent(getActivity(),UserInfoActivity.class);
                getActivity().startActivity(intent);
            }
        });

        binding.changePwd.setOnClickListener(view -> {
            if(TextUtils.equals("点击登录",binding.myselfNick.getText())){
                Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent(getActivity(),ChagePwdActivity.class);
                getActivity().startActivity(intent);
            }
        });

        binding.feedBack.setOnClickListener(view -> {
            if(TextUtils.equals("点击登录",binding.myselfNick.getText())){
                Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent(getActivity(),FeedActivity.class);
                getActivity().startActivity(intent);
            }
        });

        binding.orderList.setOnClickListener(view -> {
            if(TextUtils.equals("点击登录",binding.myselfNick.getText())){
                Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent(getActivity(),UserOrderActivity.class);
                getActivity().startActivity(intent);
            }
        });

        return binding.getRoot() ;
    }

    private void getData() {
        MyTaskManger.getDataByToken(MyNetManger.SERVER_IP+"/prod-api/api/common/user/getInfo","user", UserInfo.class,sharedPreferences.getString("token","k")).thenAccept(userInfo -> {
           if(userInfo!=null){
               getActivity().runOnUiThread(()->{
                   RoundedCorners roundedCorner = new RoundedCorners(20);
                   RequestOptions options = RequestOptions.bitmapTransform(roundedCorner);
                   binding.myselfAvatar.setScaleType(ImageView.ScaleType.CENTER_CROP);
                   Glide.with(getActivity()).load(MyNetManger.SERVER_IP+userInfo.getAvatar()).apply(options).into(binding.myselfAvatar);
                   binding.myselfNick.setText(userInfo.getNickName());
               });
           }else{
               getActivity().runOnUiThread(()->{
                   binding.myselfAvatar.setImageResource(R.drawable.avatartemp);
                   binding.myselfNick.setText("点击登录");
               });
           }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        getData();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MyselfViewModel.class);
        // TODO: Use the ViewModel
    }

}