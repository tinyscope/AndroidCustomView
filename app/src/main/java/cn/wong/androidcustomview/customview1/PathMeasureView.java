package cn.wong.androidcustomview.customview1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Arrays;

/**
 * Created by wsj on 19-2-21.
 */

public class PathMeasureView extends View {
    private static final String TAG = "PathMeasureView";
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();

    int width;
    int height;

    public PathMeasureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    float pos[] = new float[2];
    float tan[] = new float[2];


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(width / 2, height / 2);
        path.reset();
//        path.addRect(-200, -200, 200, 200, Path.Direction.CW);
//        paint.setColor(Color.BLACK);
//        canvas.drawPath(path, paint);

        // 矩形默认起点再左上角.
        // 圆形默认起点是和X轴正方向的交点.
        Path dst = new Path();
//        PathMeasure pathMeasure = new PathMeasure(path, false);
//        pathMeasure.getSegment(0, 600, dst, true);
//        paint.setColor(Color.RED);
//        canvas.drawPath(dst, paint);



        path.addCircle(0, 0, 200, Path.Direction.CW);

        PathMeasure pathMeasure = new PathMeasure(path, false);
        pathMeasure.getPosTan(0, pos, tan);
        canvas.drawPoint(pos[0], pos[1], paint);
        Log.i(TAG, "Pos1: " + Arrays.toString(pos));
        Log.i(TAG, "Tan1: " + Arrays.toString(tan));

        pathMeasure.getPosTan(pathMeasure.getLength() / 2, pos, tan);
        canvas.drawPoint(pos[0], pos[1], paint);
        Log.i(TAG, "Pos2: " + Arrays.toString(pos));
        Log.i(TAG, "Tan2: " + Arrays.toString(tan));
//        pathMeasure.getSegment(0, pathMeasure.getLength() / 8, dst, true);
//        paint.setColor(Color.BLACK);
//        canvas.drawPath(path, paint);
//        paint.setColor(Color.RED);
//        canvas.drawPath(dst, paint);
//


    }
}
