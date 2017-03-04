package com.bawei.yuanxingjindutiao2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作    者：云凯文
 * 时    间：2017/1/2
 * 描    述：
 * 修改时间：
 */

public class MyView extends View {

    //获得总宽度和总高度
    private int width;
    private int height;
    //获取宽度和高度的一般
    private int width_2;
    private int height_2;
    //设置圆的半径
    private int radio;
    //设置总进度和当前进度
    int count = 360;
    int mcount = 0;
    //设置字体大小
    int textSize=30;

    //
    public void addrest(int count, int mcount) {
        this.count = count;
        this.mcount = mcount;
        //刷新界面
        postInvalidate();
    }


    public MyView(Context context) {
        super(context, null);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //测量尺寸的方法
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //获得总宽度和总高度
        width = getWidth();
        height = getHeight();
        //获取宽度和高度的一般
        width_2 = width / 2;
        height_2 = height / 2;
        //设置圆的半径
        radio = (width - 20) / 2;
        //设置自定义视图的大小
        setMeasuredDimension(300, 300);
    }

    //画布
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画圆的画笔
        Paint paint_yuan = new Paint();
        paint_yuan.setColor(Color.BLACK);//设置笔的颜色
        paint_yuan.setStrokeWidth(5);//设置笔的宽度
        paint_yuan.setAntiAlias(true);//抗锯齿
        paint_yuan.setStyle(Paint.Style.STROKE);//设置为空心圆

        //画进度条的画笔
        Paint paint_jindutiao = new Paint();
        paint_jindutiao.setColor(Color.RED);//设置进度条的颜色
        paint_jindutiao.setStrokeWidth(5);//设置进度条的宽度
        paint_jindutiao.setAntiAlias(true);//抗锯齿
        paint_jindutiao.setStyle(Paint.Style.STROKE);//设置为空心圆形的进度条

        //显示数字的笔
        Paint paint_bi = new Paint();
        paint_bi.setTextSize(textSize);
        paint_bi.setColor(Color.BLACK);//设置笔的颜色
        paint_bi.setStrokeWidth(5);//设置笔的宽度
        paint_bi.setAntiAlias(true);//抗锯齿

        /**绘制圆*/
        canvas.drawCircle(width_2, height_2, radio, paint_yuan);

        /**绘制进度条*/
        //扇形区域
        RectF rectF = new RectF(width_2 - radio, height_2 - radio, width_2 + radio, height_2 + radio);
        //计算当前进度
        float position = (float) (mcount * 1.0 / count);
        canvas.drawArc(rectF, 0, position * count, false, paint_jindutiao);

        /**进度条百分比*/
        int perent = (int) ((mcount*1.0/count*1.0)*100);
        float textW = paint_yuan.measureText(perent + "%");
        canvas.drawText(perent+"%",width_2-textSize/2,width_2+textSize/2,paint_bi);
    }
}
