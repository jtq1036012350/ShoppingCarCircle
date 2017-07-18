package com.marsjiang.shoppingcarcircle;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 自定义购物车
 * Created by Jiang on 2017-07-18.
 */

public class ShoppingCarLayout extends FrameLayout {
    private Context mContext;
    private TextView textView;
    private ImageView image;

    //处理主线程刷新UI操作的Handler
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    textView.clearAnimation();
                    textView.setText(msg.obj.toString());
                    break;
            }
        }
    };

    public ShoppingCarLayout(@NonNull Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public ShoppingCarLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    public ShoppingCarLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
//        super.onLayout(changed, left, top, right, bottom);
        layoutWidgets();
    }

    public void setNumber(int number) {
        Message msg = Message.obtain();
        msg.what = 0;
        msg.obj = number;
        handler.sendMessage(msg);
    }

    /**
     * 放置控件
     */
    private void layoutWidgets() {
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        image.layout(0, 0, width, height);
        textView.layout(width - 20, 0, width, 20);
    }

    //设定布局
    private void initView() {
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        image = new ImageView(mContext);
        image.setMaxWidth(width);
        image.setMaxWidth(height);
        image.setImageResource(R.mipmap.shopping_car);
        this.addView(image);

        textView = new TextView(mContext);
        textView.setWidth(20);
        textView.setHeight(20);
        textView.setTextSize(10);
        textView.getPaint().setAntiAlias(true);
        textView.setBackgroundDrawable(getResources().getDrawable(R.drawable.red_circle_shape));
        this.addView(textView);
    }
}
