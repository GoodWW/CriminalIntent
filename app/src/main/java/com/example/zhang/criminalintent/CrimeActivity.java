package com.example.zhang.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * 作者 : Administrator
 * 时间 : 2018/2/1
 * 描述 : 显示一个Crime对象的Activity
 */
public class CrimeActivity extends SingleFragmentActivity {
    public static final String EXTRA_CREATE_ID = "crime_id";

    @Override
    protected Fragment createFragment() {
        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CREATE_ID);
        return CrimeFragment.newInstance(crimeId);
    }

    public static Intent newIntent(Context packageContext, UUID crimeId) {
        Intent intent = new Intent(packageContext, CrimeActivity.class);
        intent.putExtra(EXTRA_CREATE_ID, crimeId);
        return intent;
    }
}
