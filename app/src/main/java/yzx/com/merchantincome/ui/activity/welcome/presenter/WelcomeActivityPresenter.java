package yzx.com.merchantincome.ui.activity.welcome.presenter;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.library.utils.SPUtils;

import java.util.ArrayList;

import yzx.com.merchantincome.R;
import yzx.com.merchantincome.entity.UserInfo;
import yzx.com.merchantincome.ui.activity.welcome.view.WelcomeActivity;
import yzx.com.merchantincome.ui.adapter.ViewPagerAdapter;
import yzx.com.merchantincome.util.LoginUserUtil;

/**
 * Created by Administrator on 2019/12/4.
 */

public class WelcomeActivityPresenter implements IWelcomeActivityPresenterImp {

    private WelcomeActivity mView;


    private ViewPagerAdapter adapter;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    mView.goToMain();
                    break;
                case 2:
                    mView.goToLogin();
                    break;
            }
        }
    };

    public WelcomeActivityPresenter(WelcomeActivity mView) {
        this.mView = mView;
    }

    @Override
    public void initPageData() {
        ArrayList<Integer> pic = new ArrayList<>();
        pic.add(R.mipmap.welcome02);
        mView.initViewPager(pic);
    }


    /**
     * 延迟跳转到主页
     */
    @Override
    public void postGoToMain() {
        String userInfoSrc = SPUtils.getInstance().getString("userInfo");
        UserInfo userInfo = new Gson().fromJson(userInfoSrc, UserInfo.class);
        LoginUserUtil.getInstance().setLoginUser(userInfo);
        if (userInfo == null) {
            handler.sendEmptyMessageDelayed(2, 3000);
        } else {
            handler.sendEmptyMessage(1);
        }
    }

}
