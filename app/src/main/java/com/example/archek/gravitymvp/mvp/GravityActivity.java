package com.example.archek.gravitymvp.mvp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.archek.gravitymvp.R;
import com.example.archek.gravitymvp.mvp.mockmap.PointMapActivity;
import com.example.archek.gravitymvp.net.Mock;

import java.util.List;


public class GravityActivity extends AppCompatActivity implements GravityPresenter.View, GravityAdapter.Callback{

    private GravityAdapter gravityAdapter;


    private ProgressDialog progressDialog;

    private ConstraintLayout clMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravity);


        /*view launch*/
        init();
    }

    private void init() {
        clMain = findViewById(R.id.clMain);
        /*instal colored back, if you rich enough*/
        if(Build.VERSION.SDK_INT >= 24) {
            clMain.setBackground(getResources().getDrawable(R.drawable.back, getTheme()));
        }
        /*recycler view stuff*/
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        gravityAdapter = new GravityAdapter(this);

        RecyclerView rvList = findViewById(R.id.rvList);
        rvList.setLayoutManager(layoutManager);
        rvList.setAdapter(gravityAdapter);
        /*lounch presenter*/
        GravityPresenter presenter = new GravityPresenter(this);
        presenter.loadMocks();
    }

    @Override
    public void showMocks(List<Mock> mocks) {
        gravityAdapter.replaceAll(mocks);
    }
    @Override
    public void showProgress() {
        progressDialog = ProgressDialog.show(this, "", getString(R.string.please_wait));
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, R.string.error,Toast.LENGTH_SHORT ).show();
    }
    @Override
    public void hideProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void onMockClick(Mock mock) {
        Intent intent = PointMapActivity.makeIntent(this, mock);
        startActivity( intent );
    }
}
