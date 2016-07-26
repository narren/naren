package com.samsung.android.email.labs.ui;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.samsung.android.email.labs.R;
import com.samsung.android.email.labs.model.SampleData;
import com.samsung.android.email.labs.utils.RuntimePermissionChecker;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nsbisht on 5/31/16.
 */
public class MainActivity extends Activity {
    @BindView(R.id.main_recycler_view) RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!RuntimePermissionChecker.hasPermissions(
                this, RuntimePermissionChecker.PERMISSION_STORAGE)) {
            RuntimePermissionChecker.requestPermission(RuntimePermissionChecker.PERM_REQUEST_TYPE_STORAGE, this);
        } else {
            initViews();
        }
    }

    private void initViews() {
        setContentView(R.layout.activity_main_recycler_list);
        ButterKnife.bind(this);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new EmailListAdapter(this, SampleData.getSampleData());
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == RuntimePermissionChecker.PERM_REQUEST_TYPE_STORAGE) {
            boolean granted = true;

            for (int res : grantResults) {
                if (res == PackageManager.PERMISSION_DENIED) {
                    granted = false;
                    finish();
                    break;
                } else {
                    initViews();
                    break;
                }
            }
        }
    }
}