package polusov.tk.ruler.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import polusov.tk.ruler.MyApplication;
import polusov.tk.ruler.utils.MyUtils;

/**
 * Created by alexeypolusov on 23/12/15.
 */
public class Scale extends View {

    private static final String TAG = Scale.class.getSimpleName();

    private Point size;
    int scaleLengthHor;
    int scaleLengthVer;
    float pxInMm;
    private Paint paint;
    public static final int ZERO = 0;
    private static int longLine = 10;
    private static int shortLine = 5;
    private static int middleLine = 8;
    private static float stroke = 0.1f;
    private static int textSize = 2;
    private static int margin = 2;
    private static int twoDigitsMargin = 3;



    public Scale(Context context) {
        super(context, null);
        //not callable

    }

    public Scale(Context context, AttributeSet attrs) {
        super(context, attrs);
        final MyApplication app = (MyApplication) context.getApplicationContext();
        size = app.getPoint();
        scaleLengthHor = Math.round(MyUtils.pxToMm(size.x, context));
        scaleLengthVer = Math.round(MyUtils.pxToMm(size.y, context));
        pxInMm = MyUtils.pxInMm(context);

        longLine*=pxInMm;
        shortLine*=pxInMm;
        middleLine*=pxInMm;
        stroke*=pxInMm;
        textSize*=pxInMm;
        margin*=pxInMm;
        twoDigitsMargin*=pxInMm;

        paint=new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(stroke);
        paint.setTextSize(textSize);



    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawScaleHor(scaleLengthHor, canvas);
        drawScaleVer(scaleLengthVer, canvas);
    }



    //hard to make this code DRY
    private void drawScaleHor(int scaleLength, Canvas canvas){
        for (int i =0; i <= scaleLength; i++){
            if (i % 10 == 0 && i != 0) {
                canvas.drawLine(i * pxInMm, ZERO, i * pxInMm, longLine, paint);
                int scaleNumber = i/10;
                if (scaleNumber<10){
                    canvas.drawText(scaleNumber + "", i * pxInMm - margin, longLine - 5, paint);
                } else {
                    canvas.drawText(scaleNumber + "", i  * pxInMm - twoDigitsMargin, longLine - 5, paint);
                }

            } else if (i % 5 == 0 && i != 0) {
                canvas.drawLine(i * pxInMm, ZERO, i * pxInMm, middleLine, paint);
            } else {
                canvas.drawLine(i * pxInMm, ZERO, i * pxInMm, shortLine, paint);
            }
        }

    }

    private void drawScaleVer(int scaleLength, Canvas canvas){
        for (int i = 0; i <= scaleLength; i++){
            if (i % 10 == 0 && i != 0) {
                canvas.drawLine(ZERO, i*pxInMm, longLine, i * pxInMm, paint);
                int scaleNumber = i/10;
                if (scaleNumber<10){
                    canvas.drawText(scaleNumber + "", longLine - margin, i * pxInMm - 5, paint);
                }else {
                    canvas.drawText(scaleNumber + "", longLine - twoDigitsMargin, i * pxInMm - 5, paint);
                }

            } else if (i % 5 == 0 && i != 0) {
                canvas.drawLine(ZERO, i*pxInMm, middleLine , i * pxInMm, paint);
            } else {
                canvas.drawLine(ZERO, i * pxInMm, shortLine, i * pxInMm, paint);
            }
        }

    }
}



//interface DrawLine {
//    void drawLine(Canvas canvas, int x1, int y1, int x2, int y2);
//}
//
//class DrawLineVertical implements DrawLine {
//    public void drawLine(Canvas canvas, int x1, int y1, int x2, int y2) {
//        canvas.drawLine(x1, y1, x2, y2);
//    }
//}
//
//class DrawLineVertical implements DrawLine {
//    public void drawLine(Canvas canvas, int x1, int y1, int x2, int y2) {
//        canvas.drawLine(y1, x1, y2, x2);
//    }
//}
//
//    private void drawScale(int scaleLength, Canvas canvas, DrawLine artist) {
//        for (int i = 0; i <= scaleLength; i++) {
//            if (i % 10 == 0 && i != 0) {
//                artist.drawLine(x1, y1, x2, y2);
//            }
//        }
//    }
//
//    private void drawScale(int scaleLength, Canvas canvas) {
//        drawScale(scaleLength, canvas, new DrawLineHorizontal());
//    }
//
//    private void drawScaleHor(int scaleLength, Canvas canvas) {
//        drawScale(scaleLength, canvas, new DrawLineHorizontal());
//    }
//
//    private void drawScaleVer(int scaleLength, Canvas canvas) {
//        drawScale(scaleLength, canvas, new DrawLineVertical());
//    }
