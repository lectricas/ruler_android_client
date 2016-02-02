package polusov.tk.ruler;

import android.app.Application;
import android.graphics.Point;

public class MyApplication extends Application {

    private Point point;

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}