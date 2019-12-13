package yzx.com.merchantincome.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.utils.ScreenUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import yzx.com.merchantincome.R;

/**
 * Created by Administrator on 2019/12/5.
 */

public class ImageHolderView<T> extends Holder<T> {

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
    public void updateUI(T data) {
        Glide.with(context).load(data).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(photo);
    }
}
