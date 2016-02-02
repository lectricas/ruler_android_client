package polusov.tk.ruler.acitivties;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import polusov.tk.ruler.MyApplication;
import polusov.tk.ruler.R;
import polusov.tk.ruler.utils.MyUtils;
import polusov.tk.ruler.views.Rulers;

public class MainActivity extends AppCompatActivity {

    private Rulers rulers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MyApplication) this.getApplication()).setPoint(getScreenResolution());
        setContentView(R.layout.activity_main);
        rulers = (Rulers)findViewById(R.id.rulers_view);
        final RelativeLayout parent = (RelativeLayout) findViewById(R.id.parent);
        final TextView centerMm = (TextView) findViewById(R.id.centerMm);
        final TextView rightMm = (TextView) findViewById(R.id.rightMm);
        final TextView rightInch = (TextView) findViewById(R.id.rightInch);

        parent.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent ev) {
                float xPx = ev.getX();
                float yPx = ev.getY();
                float xMm = MyUtils.pxToMm(xPx, getApplicationContext());
                float yMm = MyUtils.pxToMm(yPx, getApplicationContext());
                float xInch = MyUtils.mmToInch(xMm);
                float yInch = MyUtils.mmToInch(yMm);
                centerMm.setText(getString(R.string.touch_at_mm, xMm, yMm));
                rightMm.setText(getString(R.string.touch_at_mm, xMm, yMm));
                rightInch.setText(getString(R.string.touch_at_inch, xInch, yInch));
                rulers.updateLines(xPx, yPx);
                return true;
            }
        });
    }

    private Point getScreenResolution()
    {
        WindowManager wm = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size;
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
