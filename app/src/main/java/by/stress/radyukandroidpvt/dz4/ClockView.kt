package by.stress.radyukandroidpvt.dz4

import android.content.Context
import android.graphics.Canvas
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View


// один универсальный конструктор: https://antonioleiva.com/custom-views-android-kotlin/
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class ClockView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0) : View(context, attrs, defStyleAttr, defStyleRes) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

    }
}
