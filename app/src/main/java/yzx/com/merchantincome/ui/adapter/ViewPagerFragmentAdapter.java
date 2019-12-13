package yzx.com.merchantincome.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.library.base.mvp.BaseFragment;

import java.util.List;

import yzx.com.merchantincome.entity.TagsInfo;

/**
 * Created by Administrator on 2019/12/6.
 */

public class ViewPagerFragmentAdapter<T> extends FragmentPagerAdapter {

    private List<BaseFragment> mFragments;
    private List<T> mTitles;

    public ViewPagerFragmentAdapter(FragmentManager fm, List<BaseFragment> mFragments, List<T> mTitles) {
        super(fm);
        this.mFragments = mFragments;
        this.mTitles = mTitles;
    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return ((TagsInfo) mTitles.get(position)).getTagsName();
    }
}
