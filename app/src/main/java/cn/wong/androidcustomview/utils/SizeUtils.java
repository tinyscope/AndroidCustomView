package cn.wong.androidcustomview.utils;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by wsj on 19-2-21.
 */

public class SizeUtils {

    /**
     * dp2px
     */
    public static float dp2px(int dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, Resources.getSystem().getDisplayMetrics());
    }
}
