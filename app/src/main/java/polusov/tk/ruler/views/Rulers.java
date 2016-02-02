package polusov.tk.ruler.views;

/**
 * Created by patrickchan on 16/12/14.
 */


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;


import polusov.tk.ruler.MyApplication;
import polusov.tk.ruler.utils.MyUtils;

public class Rulers extends View {

    private static final String TAG = Rulers.class.getSimpleName();
    private Paint paint;
    private float hor;
    private float ver;
    private Point size;
    private static final float THIN_STROKE = 0.12f;


    public void updateLines(float vertical, float horizontal){
        this.hor = horizontal;
        this.ver = vertical;
        invalidate();
    }

    public Rulers(Context context){
        this(context, null);
    }

    public Rulers(Context context, AttributeSet attrs) {
        super(context, attrs);
        final MyApplication app = (MyApplication) context.getApplicationContext();
        size = app.getPoint();
        ver = size.x/2;
        hor = size.y/2;
        paint=new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(THIN_STROKE * MyUtils.pxInMm(context));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(Scale.ZERO, hor, size.x, hor, paint);
        canvas.drawLine(ver, Scale.ZERO, ver, size.y, paint);

    }
}