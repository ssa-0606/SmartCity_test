package com.example.smartcity_0715.ui.myself.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.LayoutOrderPayListBinding;
import com.example.smartcity_0715.pojo.OrderBus;
import com.example.smartcity_0715.tools.MyNetManger;
import com.example.smartcity_0715.ui.myself.UserOrderActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class OrderPayAdapter extends RecyclerView.Adapter<OrderPayAdapter.ViewHolder> {

    private int resourceId;
    private List<OrderBus> orderBuses;

    public OrderPayAdapter(int resourceId, List<OrderBus> orderBuses) {
        this.resourceId = resourceId;
        this.orderBuses = orderBuses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(resourceId, null);
        LayoutOrderPayListBinding binding = LayoutOrderPayListBinding.bind(inflate);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OrderBus orderBus = orderBuses.get(position);
        holder.binding.orderLine.setText("线路："+orderBus.getPath());
        holder.binding.orderNum.setText("订单："+orderBus.getOrderNum());
        holder.binding.orderPay.setText("¥"+orderBus.getPrice());
        holder.binding.busInfoEnd.setText(orderBus.getEnd());
        holder.binding.busInfoFirst.setText(orderBus.getStart());
        holder.binding.orderTime.setText("乘车日期"+orderBus.getCreateTime());
        if((Integer.valueOf(orderBus.getStatus()))==1){
            holder.binding.payBtn.setVisibility(View.GONE);
        }
        holder.binding.payBtn.setOnClickListener(view -> {
            UserOrderActivity activity = (UserOrderActivity) holder.itemView.getContext();
            doPay(orderBus.getOrderNum(),activity,position);
        });
    }

    private void doPay(String id, UserOrderActivity context,int i) {
        new Thread(()->{
            try {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("orderNum",id);
                jsonObject.put("paymentType","电子支付");
                String result = MyNetManger.POST_T(MyNetManger.SERVER_IP + "/prod-api/api/bus/pay", jsonObject.toString(), context.getSharedPreferences("data",0).getString("token",""));
                int code = new JSONObject(result).getInt("code");
                if(code == 200){
                    context.runOnUiThread(()->{
                        orderBuses.remove(i);
                        notifyItemRemoved(i);
                        if(orderBuses.size()<=0){
                            context.findViewById(R.id.no_data).setVisibility(View.VISIBLE);
                            context.findViewById(R.id.order_list).setVisibility(View.GONE);
                        }
                    });
                }
            } catch (JSONException | IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public int getItemCount() {
        return orderBuses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LayoutOrderPayListBinding binding;
        public ViewHolder(@NonNull LayoutOrderPayListBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
