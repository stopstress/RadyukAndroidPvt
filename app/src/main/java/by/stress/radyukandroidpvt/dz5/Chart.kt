package by.stress.radyukandroidpvt.dz5

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import android.util.AttributeSet
import android.view.View
import by.stress.radyukandroidpvt.R
import java.util.*


class Chart// один универсальный конструктор: https://antonioleiva.com/custom-views-android-kotlin/
@RequiresApi(Build.VERSION_CODES.LOLLIPOP) @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    var numbersList: MutableList<Int> = mutableListOf()

    private var textBoundRect: Rect = Rect()

    private var cx = 0f
    private var cy = 0f

    private var timeMinutes = 0f
    private var timeHours = 0f
    private var timeSeconds = 0

    private var textWidth = 0f
    private var textHeight = 0

    private var radiusExternal = 0f
    private var radiusClockFace = 0f
    private var radiusClockDigits = 0f
    private var radiusHourHand = 0f
    private var radiusMinuteHand = 0f
    private var radiusSecondHand = 0f

    private var yStartClockDivider = 0f
    private var yFinishClockDivider = 0f

    private val paintClockFace = Paint(Paint.ANTI_ALIAS_FLAG)
    private val paintClockDivider = Paint(Paint.ANTI_ALIAS_FLAG)
    private val paintClockDividerBold = Paint(Paint.ANTI_ALIAS_FLAG)
    private val paintClockDigits = Paint(Paint.ANTI_ALIAS_FLAG)
    private val paintMinuteHand = Paint(Paint.ANTI_ALIAS_FLAG)
    private val paintHourHand = Paint(Paint.ANTI_ALIAS_FLAG)
    private val paintSecondHand = Paint(Paint.ANTI_ALIAS_FLAG)

    private var clockColorMain: Int = ContextCompat.getColor(context, android.R.color.black)
    private var clockColorBright: Int = ContextCompat.getColor(context, android.R.color.holo_orange_dark)

    private var clockDigitsText: String = ""

    init {
        paintClockFace.color = clockColorMain
        paintClockFace.style = Paint.Style.STROKE
        paintClockFace.strokeWidth = 24f

        paintClockDivider.color = clockColorMain
        paintClockDivider.style = Paint.Style.STROKE
        paintClockDivider.strokeWidth = 9f

        paintClockDividerBold.color = clockColorMain
        paintClockDividerBold.style = Paint.Style.STROKE
        paintClockDividerBold.strokeWidth = 24f

        paintClockDigits.color = clockColorMain
        paintClockDigits.style = Paint.Style.FILL
        paintClockDigits.strokeWidth = 22.0f
        paintClockDigits.textSize = 72.0f

        paintHourHand.color = clockColorMain
        paintHourHand.style = Paint.Style.FILL_AND_STROKE
        paintHourHand.strokeWidth = 20f

        paintMinuteHand.color = clockColorMain
        paintMinuteHand.style = Paint.Style.FILL_AND_STROKE
        paintMinuteHand.strokeWidth = 15f

        paintSecondHand.color = clockColorBright
        paintSecondHand.style = Paint.Style.FILL_AND_STROKE
        paintSecondHand.strokeWidth = 10f
    }


    override fun onSizeChanged(width: Int, height: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(width, height, oldw, oldh)

        val limit = Math.min(width, height)

        cx = width / 2f
        cy = height / 2f

        // максимальный радиус (из границ view)
        radiusExternal = limit / 2f

        // радиус циферблата (без цифр)
        radiusClockFace = (radiusExternal / 3f) * 2f

        // радиус размещения цифр
        radiusClockDigits = (radiusExternal / 6f) * 5f

        // радиус часовой стрелки
        radiusHourHand = radiusClockFace * 0.60f

        // радиус минутной стрелки
        radiusMinuteHand = radiusClockFace * 0.70f

        // радиус секундной стрелки
        radiusSecondHand = radiusClockFace * 0.80f

        // y-координаты разделителей
        yStartClockDivider = cy - radiusClockFace - radiusClockFace * 0.10f
        yFinishClockDivider = cy - radiusClockFace + radiusClockFace * 0.10f
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas ?: return

        // рисуем циферблат
        canvas.drawCircle(cx, cy, radiusClockFace, paintClockFace)

        // рисуем центр циферблата
        canvas.drawCircle(cx, cy, 20f, paintClockFace)

        // рисуем деления на циферблате
        canvas.save()
        for (i in 0..11) {
            canvas.drawLine(cx, yStartClockDivider, cx, yFinishClockDivider, paintClockDivider)
            canvas.rotate(30f, cx, cy)
        }
        canvas.restore()

        // рисуем главные деления на циферблате
        canvas.save()
        for (i in 0..3) {
            canvas.drawLine(cx, yStartClockDivider, cx, yFinishClockDivider, paintClockDividerBold)
            canvas.rotate(90f, cx, cy)
        }
        canvas.restore()

        // рисуем цифры
        clockDigitsText = "12"
        paintClockDigits.getTextBounds(clockDigitsText, 0, clockDigitsText.length, textBoundRect)
        textWidth = paintClockDigits.measureText(clockDigitsText)
        textHeight = textBoundRect.height()
        canvas.drawText(
            clockDigitsText,
            cx - (textWidth / 2f),
            cy + (textHeight / 2f) - radiusClockDigits,
            paintClockDigits
        )

        clockDigitsText = "6"
        paintClockDigits.getTextBounds(clockDigitsText, 0, clockDigitsText.length, textBoundRect)
        textWidth = paintClockDigits.measureText(clockDigitsText)
        textHeight = textBoundRect.height()
        canvas.drawText(
            clockDigitsText,
            cx - (textWidth / 2f),
            cy + (textHeight / 2f) + radiusClockDigits,
            paintClockDigits
        )

        clockDigitsText = "3"
        paintClockDigits.getTextBounds(clockDigitsText, 0, clockDigitsText.length, textBoundRect)
        textWidth = paintClockDigits.measureText(clockDigitsText)
        textHeight = textBoundRect.height()
        canvas.drawText(
            clockDigitsText,
            cx - (textWidth / 2f) + radiusClockDigits,
            cy + (textHeight / 2f),
            paintClockDigits
        )

        clockDigitsText = "9"
        paintClockDigits.getTextBounds(clockDigitsText, 0, clockDigitsText.length, textBoundRect)
        textWidth = paintClockDigits.measureText(clockDigitsText)
        textHeight = textBoundRect.height()
        canvas.drawText(
            clockDigitsText,
            cx - (textWidth / 2f) - radiusClockDigits,
            cy + (textHeight / 2f),
            paintClockDigits
        )

        val calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+3:00"))
        var hh = calendar.get(Calendar.HOUR)
        val mm = calendar.get(Calendar.MINUTE)
        val ss = calendar.get(Calendar.SECOND)

        if (hh > 11) {
            hh -= 12
        }

        timeMinutes = mm + ss / 60.0f
        timeHours = hh + mm / 60.0f
        timeSeconds = ss

        // рисуем стрелки
        canvas.save()
        canvas.rotate(((timeHours / 12.0f) * 360.0f), cx, cy)
        canvas.drawLine(cx, cy, cx, cy - radiusHourHand, paintHourHand)
        canvas.restore()

        canvas.save()
        canvas.rotate(((timeMinutes / 60.0f) * 360.0f), cx, cy)
        canvas.drawLine(cx, cy, cx, cy - radiusMinuteHand, paintMinuteHand)
        canvas.restore()

        canvas.save()
        canvas.rotate(((timeSeconds / 60.0f) * 360.0f), cx, cy)
        canvas.drawLine(cx, cy, cx, cy - radiusSecondHand, paintSecondHand)
        canvas.restore()

        // рисуем начало секундной стрелки
        canvas.drawCircle(cx, cy, 5f, paintSecondHand)
    }

    fun setData(numbers : MutableList<Int>) {
        numbersList = numbers
    }
}