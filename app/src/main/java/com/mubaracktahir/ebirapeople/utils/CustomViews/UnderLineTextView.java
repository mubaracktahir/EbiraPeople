package com.mubaracktahir.ebirapeople.utils.CustomViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.mubaracktahir.ebirapeople.R;

/**
 * Created by Mubarak Tahir on 7/31/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */

public class UnderLineTextView extends View {

    // Label text
    private String viewText;
    // Underline Thickness
    private float underlineThickness;

    // Paint for drawing custom view
    private Paint viewPaint;

    public UnderLineTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        viewPaint = new Paint();
        // Get the attributes specified in attrs.xml using the name we included
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.CustomView, 0, 0);

        try {
            // Get the text and colors specified using the names in attrs.xml
            viewText = typedArray.getString(R.styleable.CustomView_viewText);
            underlineThickness = typedArray.getDimension(R.styleable.CustomView_underlineThickness, 1f);
        } finally {
            typedArray.recycle();
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        // Draw the View

        // Drawing the text on the view
        viewPaint.setColor(Color.BLACK); // Set Text color to whatever you want
        viewPaint.setTextSize(50); // Set Text Size to whatever you want
        canvas.drawText(viewText, getX() + 5, getMeasuredHeight() / 2 + 20, viewPaint); // 5 and 20 are the left and top padding, you can customize that too.

        viewPaint.setColor(Color.BLACK); // Set Underline color to whatever you want
        canvas.drawRect(getX(), getMeasuredHeight() - underlineThickness, getX() + getMeasuredWidth(), getMeasuredHeight(),
                viewPaint); // Set the start and end points of the Underline

    }

    public String getViewText() {
        return viewText;
    }

    public void setViewText(String viewText) {
        this.viewText = viewText;
        invalidate();
        requestLayout();
    }

    public float getUnderlineThickness() {
        return underlineThickness;
    }

    public void setUnderlineThickness(float underlineThickness) {
        this.underlineThickness = underlineThickness;
        invalidate();
        requestLayout();
    }
}