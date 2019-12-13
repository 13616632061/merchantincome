package yzx.com.merchantincome.ui.activity.welcome.view;

import java.util.ArrayList;

import yzx.com.merchantincome.ui.adapter.ViewPagerAdapter;

/**
 * Created by Administrator on 2019/12/4.
 */

public interface IWelcomeActivityImp {

    //初始化
    void initViewPager(ArrayList<Integer> list);

    //跳转到主页
    void goToMain();

    //跳转登录
    void goToLogin();
}
