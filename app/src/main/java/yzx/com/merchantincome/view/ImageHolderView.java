package yzx.com.merchantincome.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import yzx.com.merchantincome.R;
import yzx.com.merchantincome.entity.BannerResponse;
/**
 * Created by Administrator on 2019/12/5.
 */

public class ImageHolderView extends Holder<BannerResponse.ResultBean.ListBean> {

    private ImageView photo;
    private Context context;

    public ImageHolderView(Context context, View itemView) {
        super(itemView);
        this.context = context;
    }

    @Override
    protected void initView(View itemView) {
        photo = itemView.findViewById(R.id.iv_photo);
    }

    @Override
    public void updateUI(BannerResponse.ResultBean.ListBean data) {
        Glide.with(context).load(data.getImg_url()).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(photo);
    }
}
