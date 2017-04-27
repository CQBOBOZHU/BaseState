package com.basestate;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Main1Activity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
    }


    @Override
    protected int getToobarId() {
        return R.layout.toobar_cu;
    }

    public void loadError(View view) {
        showloadErrorView();
    }

    public void loading(View view) {
        showLoadView();
    }

    public void netError(View view) {
        showNetErrorView();
    }

    public void loadingEmpty(View view) {
        showEmptyView();
    }

    public void onExit(View view) {
        onBackPressed();
    }

    public void showContentView(View view){
        showContextView();
    }

}
