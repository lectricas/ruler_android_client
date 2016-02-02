package polusov.tk.ruler.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * Created by alexeypolusov on 23/12/15.
 */
public abstract class MyUtils {

    public static final float inchInMm = 0.0393701f;

    public static float pxToMm(final float px, final Context context)
    {
        final DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return px / TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_MM, 1, dm);
    }


    public static float mmToInch(final float mm){
        return mm * inchInMm;
    }

    public static float pxInMm(final Context context)
    {
        final DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_MM, 1, dm);
    }



}
