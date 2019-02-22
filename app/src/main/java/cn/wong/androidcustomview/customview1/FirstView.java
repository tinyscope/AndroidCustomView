package cn.wong.androidcustomview.customview1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by wsj on 19-2-21.
 */

public class FirstView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();

    private int width;
    private int height;

    public FirstView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        // 设置Path的填充规则
        // Path.FillType.WINDING: 任意一点向外的射线经过和图形交叉: 顺时针-1, 逆时针+1. 如果最后的和=0, 外部, !=0内部.
        mPath.setFillType(Path.FillType.WINDING);
        // Path.FillType.EVEN_ODD: 指定“内部”由奇数个边缘交叉点计算.奇数内部偶数外部.
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        // CCW: 逆时针
        // CW: 顺指针.
        mPath.addRect(width / 2 - 300, height / 2 - 300, width / 2 + 300, height / 2 + 300, Path.Direction.CW);
        mPath.addCircle(w / 2, h / 2 + 300, 300, Path.Direction.CCW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath, mPaint);






    }
}
