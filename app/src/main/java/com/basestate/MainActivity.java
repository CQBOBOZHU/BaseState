package com.basestate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends BaseActivity {

    Toolbar toolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        toolbar = getView(R.id.toobar);
        toolbar.setTitle("什么是title");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "你有本事退出，你有本事就卸载啊。", Toast.LENGTH_SHORT).show();
            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.toolbar_item1:
                        showContextView();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);//加载menu文件到布局
        return true;
    }

    @Override
    protected int getToobarId() {
        return R.layout.toobar_view;
    }

    @Override
    protected void loadMessage() {
        super.loadMessage();
        showLoadView();
        ranDomView();
    }

    public void loadError(View view) {
        showloadErrorView();
    }

    public void loading(View view) {
        showLoadView();
        ranDomView();
    }

    private void ranDomView() {
        baseView.postDelayed(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                switch (random.nextInt(3)) {
                    case 0:
                        showContextView();
                        break;
                    case 1:
                        showloadErrorView();
                        break;
                    case 2:
                        showEmptyView();
                        break;
                    case 3:
                        showNetErrorView();
                        break;
                }
            }
        }, 2000);
    }

    public void netError(View view) {
        showNetErrorView();
    }

    public void loadingEmpty(View view) {
        showEmptyView();
    }

    public void toMain1(View view) {
        startActivity(new Intent(this, Main1Activity.class));
    }
}
