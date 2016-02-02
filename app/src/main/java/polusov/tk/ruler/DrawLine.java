package polusov.tk.ruler;

import android.graphics.Canvas;
import android.graphics.Paint;


// want to make the code DRY
public interface DrawLine {
    void drawLine(Canvas canvas, Paint paint, float x1, float y1, float x2, float y2);
}