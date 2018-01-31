package com.example.zhang.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * 作者 : Administrator
 * 时间 : 2018/1/31
 * 描述 : 模型层
 */
public class Crome {
    /**
     * 产生唯一的ID值
     */
    private UUID mId;
    /**
     * 时间
     */
    private Date mDate;
    private String mTitle;
    private boolean mSolved;

    public Crome() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getmId() {
        return mId;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public boolean ismSolved() {
        return mSolved;
    }

    public void setmSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }
}
