package com.example.zhang.criminalintent;

import android.support.v4.app.Fragment;

/**
 * 作者： Administrator
 * 时间： 2018/2/1 . 10:56
 * 作用： 显示一组Crime对象的 Activity  使用继承抽象类
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
