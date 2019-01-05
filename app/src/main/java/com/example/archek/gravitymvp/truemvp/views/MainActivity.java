package com.example.archek.gravitymvp.truemvp.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.archek.gravitymvp.R;
import com.example.archek.gravitymvp.truemvp.contracts.MainContract;
import com.example.archek.gravitymvp.truemvp.di.BaseApp;
import com.example.archek.gravitymvp.truemvp.utils.net.Mock;
import com.example.archek.gravitymvp.truemvp.utils.GravityAdapter;
import com.example.archek.gravitymvp.truemvp.views.mockmap.PointMapActivity;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.view,GravityAdapter.Callback{


    private GravityAdapter adapter;
    @Inject MainContract.presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        /*get recyclerview parts, presenter and data objects from it*/
        RecyclerView rvList = findViewById(R.id.rvList);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GravityAdapter(this);
        rvList.setAdapter(adapter);
        BaseApp.get(this).getInjector().inject(this);
        presenter.attachView(this);
    }



    @Override
    public void setMocks(List<Mock> mocks) {
        /*set data through the adapter into the recyclerview*/
        adapter.replaceAll(mocks);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        /*if destroy - detach view*/
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void onMockClick(Mock mock) {
        /*launch map activity onclick*/
        Intent intent = PointMapActivity.makeIntent(this, mock);
        startActivity(intent);
    }
}
