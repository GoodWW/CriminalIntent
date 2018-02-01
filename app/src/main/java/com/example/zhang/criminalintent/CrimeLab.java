package com.example.zhang.criminalintent;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 作者： Administrator
 * 时间： 2018/2/1 . 10:01
 * 作用： 存储一组list的Crime对象
 */
public class CrimeLab {
    /**
     * s级的前缀表示一个静态的变量
     */
    private static CrimeLab sCrimeLab;
    /**
     * List 用于保存Crime对象
     */
    private List<Crime> mCrimes;

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
        //先批量存入100个没有个性的Crime对象
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setmTitle("Crime # "+i);
            crime.setmSolved(i%2==0);//得到要么是true  要么是false
            mCrimes.add(crime);
        }
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    /**
     * 根据UUID获取Crime对象
     */
    public Crime getCrime(UUID id) {
        for (Crime crime : mCrimes) {
            if (id.equals(crime.getmId())) {
                return crime;
            }
        }
        return null;
    }
}
