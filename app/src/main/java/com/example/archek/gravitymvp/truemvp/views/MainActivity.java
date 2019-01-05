package com.example.archek.gravitymvp.truemvp.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.archek.gravitymvp.R;
import com.example.archek.gravitymvp.truemvp.contracts.MainContract;
import com.example.archek.gravitymvp.truemvp.di.BaseApp;
import com.example.archek.gravitymvp.truemvp.utils.net.Mock;
import com.example.archek.gravitymvp.truemvp.presenters.MainPresenter;
import com.example.archek.gravitymvp.truemvp.utils.GravityAdapter;
import com.example.archek.gravitymvp.truemvp.views.mockmap.PointMapActivity;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.view,GravityAdapter.Callback{


    RecyclerView rvList;
    GravityAdapter adapter;
    @Inject MainContract.presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravity);
        rvList = findViewById(R.id.rvList);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GravityAdapter(this);
        rvList.setAdapter(adapter);
        BaseApp.get(this).getInjector().inject(this);
        presenter.attachView(this);

    }

    @Override
    public void onMockClick(Mock mock) {
        Intent intent = PointMapActivity.makeIntent(this, mock);
        startActivity( intent );
    }

    @Override
    public void setMocks(List<Mock> mocks) {
        adapter.replaceAll(mocks);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
