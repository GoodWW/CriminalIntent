package com.example.zhang.criminalintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * 作者： Administrator
 * 时间： 2018/2/1 . 10:54
 * 作用： 显示一组list Crime 对象的 Fragment
 */
public class CrimeListFragment extends Fragment {
    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);
        mCrimeRecyclerView = view.findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        upDateUI();
        return view;
    }

    /**
     * 用户界面的更新方法
     */
    private void upDateUI() {
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getCrimes();
        if (mAdapter == null) {
            mAdapter = new CrimeAdapter(crimes);
            mCrimeRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 定义内部类实例化 并使用list_item_crime  自己处理点击事件
     */
    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTitleTextView, mDateTextView;
        private ImageView mSolvedImageView;
        private Crime mCrime;

        public CrimeHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_crime, parent, false));
            itemView.setOnClickListener(this);
            mDateTextView = itemView.findViewById(R.id.crime_date);
            mTitleTextView = itemView.findViewById(R.id.crime_title);
            mSolvedImageView = itemView.findViewById(R.id.crime_solved);
        }

        /**
         * 绑定每条item数据
         */
        public void bind(Crime crime) {
            mCrime = crime;
            mTitleTextView.setText(mCrime.getmTitle());
            mDateTextView.setText(mCrime.getmDate().toString());
            mSolvedImageView.setVisibility(crime.ismSolved() ? View.VISIBLE : View.GONE);
        }

        /**自己实现点击事件的监听*/
        @Override
        public void onClick(View view) {
            Intent intent = CrimeActivity.newIntent(getActivity(),mCrime.getmId());
            startActivity(intent);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        upDateUI();
    }

    /**
     * 创建Adapter的内部类
     */
    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {
        private List<Crime> mCrimes;

        public CrimeAdapter(List<Crime> crimes) {
            this.mCrimes = crimes;
        }

        /**
         * 创建ViewHolder
         */
        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new CrimeHolder(layoutInflater, parent);
        }

        /**
         * 绑定数据  调用holder的 bind 方法
         */
        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {
            Crime crime = mCrimes.get(position);
            holder.bind(crime);
        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }
}
