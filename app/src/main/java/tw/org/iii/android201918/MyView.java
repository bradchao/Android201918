package tw.org.iii.android201918;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {
    private float viewW, viewH, ballX, ballY, rad, z;
    private boolean isInit;
    private Paint linePaint, ballPaint;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.BLACK);
    }

    private void init(){
        viewW = getWidth(); viewH = getHeight();
        linePaint = new Paint();
        linePaint.setColor(Color.RED);
        linePaint.setStrokeWidth(2);

        ballPaint = new Paint();
        ballPaint.setColor(Color.YELLOW);
        ballPaint.setStrokeWidth(2);

        ballX = viewW / 2; ballY = viewH / 2;
        rad = 50;
        isInit = true;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInit) init();

        canvas.drawCircle(ballX, ballY, rad+z, ballPaint);
        canvas.drawLine(0, viewH/2, viewW, viewH/2,linePaint);
        canvas.drawLine(viewW/2, 0, viewW/2, viewH,linePaint);

    }

    public void setXY( float x, float y,float z){
        ballX = x; ballY = y; this.z = z;
        //rad = rad + z;
        invalidate();
    }

}
