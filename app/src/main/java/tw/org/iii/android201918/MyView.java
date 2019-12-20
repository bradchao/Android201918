package tw.org.iii.android201918;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {
    private float viewW, viewH;
    private boolean isInit;
    private Paint linePaint;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.BLACK);
    }

    private void init(){
        viewW = getWidth(); viewH = getHeight();
        linePaint = new Paint();
        linePaint.setColor(Color.RED);
        linePaint.setStrokeWidth(2);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInit) init();

        canvas.drawLine(0, viewH/2, viewW, viewH/2,linePaint);
        canvas.drawLine(viewW/2, 0, viewW/2, viewH,linePaint);

    }
}
