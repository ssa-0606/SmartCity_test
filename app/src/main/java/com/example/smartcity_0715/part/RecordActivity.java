package com.example.smartcity_0715.part;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.ActivityRecordBinding;
import com.example.smartcity_0715.part.adapter.RecordListAdapter;
import com.example.smartcity_0715.part.pojo.ParkRecord;
import com.example.smartcity_0715.tools.MyNetManger;
import com.example.smartcity_0715.tools.MyTaskManger;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RecordActivity extends AppCompatActivity {

    private ActivityRecordBinding binding;
    private String entry_data;
    private String out_data;
    private int i = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("停车记录");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.dilogEntry.setOnClickListener(view -> {
            Calendar calendar = Calendar.getInstance();
            DatePickerDialog datePickerDialog = new DatePickerDialog(RecordActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    entry_data = i+"-"+(i1+1)+"-"+i2;
                    binding.dilogEntry.setText(entry_data);
                }
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();
        });

        binding.dialogOut.setOnClickListener(view -> {
            Calendar calendar = Calendar.getInstance();
            DatePickerDialog datePickerDialog = new DatePickerDialog(RecordActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    out_data = i+"-"+(i1+1)+"-"+i2;
                    binding.dialogOut.setText(out_data);
                }
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();
        });

        binding.recordSearch.setOnClickListener(view -> {
            if(TextUtils.isEmpty(entry_data)||TextUtils.isEmpty(out_data)){
                Toast.makeText(this, "请输入完整的时间段", Toast.LENGTH_SHORT).show();
            }else{

                MyTaskManger.getListData(MyNetManger.SERVER_IP+"/prod-api/api/park/lot/record/list?entryTime="+ entry_data+"&outTime="+out_data,"rows",ParkRecord.class).thenAccept(parkRecords -> {
                    runOnUiThread(()->{
                        if(parkRecords.size()>0){
                            binding.recordList.setVisibility(View.VISIBLE);
                            binding.recordNull.setVisibility(View.GONE);
                            binding.recordList.setLayoutManager(new GridLayoutManager(RecordActivity.this,1));
                            binding.recordList.setAdapter(new RecordListAdapter(R.layout.layout_record_card,parkRecords));
                            Toast.makeText(this, "成功查询这段时间的全部停车记录", Toast.LENGTH_SHORT).show();
                        }else{
                            binding.recordList.setVisibility(View.GONE);
                            binding.recordNull.setVisibility(View.VISIBLE);
                        }

                        binding.button.setVisibility(View.GONE);
                    });
                });
            }
        });

        getData(i);

        binding.button.setOnClickListener(view -> {
            i = i+3;
            getData(i);
        });





    }

    private void getData(int i) {

        MyTaskManger.getListData(MyNetManger.SERVER_IP+"/prod-api/api/park/lot/record/list","rows", ParkRecord.class).thenAccept(parkRecords -> {
            List<ParkRecord> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                list.add(parkRecords.get(j));
            }
            runOnUiThread(()->{
                binding.recordList.setLayoutManager(new GridLayoutManager(RecordActivity.this,1));
                binding.recordList.setAdapter(new RecordListAdapter(R.layout.layout_record_card,list));
            });
        });

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}