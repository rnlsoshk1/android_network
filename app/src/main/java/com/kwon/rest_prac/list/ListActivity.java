package com.kwon.rest_prac.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.kwon.rest_prac.R;
import com.kwon.rest_prac.application.ApplicationController;
import com.kwon.rest_prac.network.NetworkService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<ListData> mDatas;
    LinearLayoutManager mLayoutManager;
    Adapter adapter;

    NetworkService service;

    String category = "스포츠";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);

        mDatas = new ArrayList<>();
        service = ApplicationController.getInstance().getNetworkService();

        Call<ListResult> getListDatas = service.getCategory(category);
        getListDatas.enqueue(new Callback<ListResult>() {
            @Override
            public void onResponse(Call<ListResult> call, Response<ListResult> response) {
                if(response.isSuccessful()){
                    Log.i("kwon : ", String.valueOf(response.body().result.size()));
                    adapter.setAdapter(response.body().result);
                    mDatas = response.body().result;
                }
            }

            @Override
            public void onFailure(Call<ListResult> call, Throwable t) {
                Log.d("kwon : ", t.getMessage());
            }
        });

        adapter = new Adapter(mDatas, clickEvent);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Call<ListResult> requestListData = service.getCategory(category);
        requestListData.enqueue(new Callback<ListResult>() {
            @Override
            public void onResponse(Call<ListResult> call, Response<ListResult> response) {
                if(response.isSuccessful()){
                    Log.i("kwon : ", String.valueOf(response.body().result.size()));
                    adapter.setAdapter(response.body().result);
                    mDatas = response.body().result;
                }
            }

            @Override
            public void onFailure(Call<ListResult> call, Throwable t) {

            }
        });
    }

    public View.OnClickListener clickEvent = new View.OnClickListener() {
        public void onClick(View v) {
            int itemPosition = recyclerView.getChildPosition(v);
            //int tempId = mDatas.get(itemPosition).id;

            //Intent intent = new Intent(getApplicationContext(), PageActivity.class);
            //intent.putExtra("id", String.valueOf(tempId));
            //startActivity(intent);
        }
    };
}
