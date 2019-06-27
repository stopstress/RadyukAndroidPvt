package by.stress.radyukandroidpvt.dz4

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import android.util.AttributeSet
import android.view.View
import by.stress.radyukandroidpvt.R


class ClockView : View {

    private val circlePaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val rectPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val rectF = RectF()

    private var cx = 0f
    private var cy = 0f

    private var radius = 0f

    private var text: String? = null
        set(value) {
            field = value
            invalidate()
        }

    // один универсальный конструктор: https://antonioleiva.com/custom-views-android-kotlin/
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @JvmOverloads
    constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0,
        defStyleRes: Int = 0
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    init {

        circlePaint.color = ContextCompat.getColor(context, R.color.colorPrimary)
        //circlePaint.style = Paint.Style.FILL
        circlePaint.style = Paint.Style.STROKE
        //circlePaint.style = Paint.Style.

        rectPaint.color = ContextCompat.getColor(context, R.color.colorAccent)
        rectPaint.style = Paint.Style.FILL

        textPaint.color = ContextCompat.getColor(context, R.color.colorPrimaryDark)
        textPaint.style = Paint.Style.FILL
    }

    override fun onSizeChanged(width: Int, height: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(width, height, oldw, oldh)

        val paddingLeftRight = Math.min(width, height) * 0.20f
        val paddingTopBottom = Math.max(width, height) * 0.30f

        rectF.left = paddingLeftRight
        rectF.top = paddingTopBottom
        rectF.right = width - paddingLeftRight
        rectF.bottom = width - paddingTopBottom

        cx = width / 2f
        cy = height / 2f
        radius = Math.min(width, height) / 2f

    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas ?: return

        canvas.drawCircle(cx, cy, radius, circlePaint)
//
//        canvas.drawRect(rectF, rectPaint)
//
//        text = "text123"
//        textPaint.textSize = 130f
//        text?.run {
//            canvas.drawText(this, cx, cy, textPaint)
//        }

    }

}



