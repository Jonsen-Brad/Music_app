package com.example.music_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.music_app.fragment.FindFragment;
import com.example.music_app.fragment.MainFragment;
import com.example.music_app.fragment.MeFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected LinearLayout mMenuMain;
    protected LinearLayout mMenuFind;
    protected LinearLayout mMenuMe;
    protected MainFragment mMainFragment= new MainFragment();   //首页
    protected FindFragment mFindFragment= new FindFragment();   //发现
    protected MeFragment mMeFragment= new MeFragment();         //我的


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        //获取管理类
        initFragment(mMainFragment,mFindFragment,mMeFragment);
    }

    private void initFragment(MainFragment mMainFragment,FindFragment mFindFragment,MeFragment mMeFragment) {
        this.getSupportFragmentManager()
                //事物添加 默认首页
                .beginTransaction()

                .add(R.id.container_content,mMainFragment)
                .add(R.id.container_content,mMeFragment)
                .add(R.id.container_content,mFindFragment)

                .hide(mMeFragment)
                .hide(mFindFragment)
                .show(mMainFragment)

                // 提交
                .commit();
    }

    public void initView(){
        mMenuMain = this.findViewById(R.id.main);
        mMenuFind = this.findViewById(R.id.find);
        mMenuMe = this.findViewById(R.id.me);

        mMenuMain.setOnClickListener(this);
        mMenuFind.setOnClickListener(this);
        mMenuMe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main:
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .hide(mFindFragment)
                        .hide(mMeFragment)
                        .show(mMainFragment)
                        .commit();
                break;
            case R.id.find:
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .hide(mMainFragment)
                        .hide(mMeFragment)
                        .show(mFindFragment)
                        .commit();
                break;
            case R.id.me:
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .hide(mMainFragment)
                        .hide(mFindFragment)
                        .show(mMeFragment)
                        .commit();
                break;

        }
    }


}
