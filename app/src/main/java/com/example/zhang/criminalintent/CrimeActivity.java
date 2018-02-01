package com.example.zhang.criminalintent;

import android.support.v4.app.Fragment;
/**
*  作者 : Administrator
*  时间 : 2018/2/1
*  描述 : 显示一个Crime对象的Activity
*/
public class CrimeActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }
}
