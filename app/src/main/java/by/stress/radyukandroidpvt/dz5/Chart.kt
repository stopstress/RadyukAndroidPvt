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
import java.util.*

class Chart // один универсальный конструктор: https://antonioleiva.com/custom-views-android-kotlin/
@RequiresApi(Build.VERSION_CODES.LOLLIPOP) @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    var numbersList: MutableList<Int> = mutableListOf()

    private var textBoundRect: Rect = Rect()
    private var pieChartRectF: RectF = RectF()

    private var cx = 0f
    private var cy = 0f

    private var startAngle = 0f
    private var sweepAngle = 0f
    private val rnd = Random()

    private var textWidth = 0f
    private var textHeight = 0

    private var radiusExternal = 0f
    private var radiusPieChart = 0f
    private var radiusLineStart = 0f
    private var radiusLineEnd = 0f
    private var radiusText = 0f

    private val paintStroke = Paint(Paint.ANTI_ALIAS_FLAG)
    private val paintFill = Paint(Paint.ANTI_ALIAS_FLAG)
    private val paintLine = Paint(Paint.ANTI_ALIAS_FLAG)
    private val paintDigits = Paint(Paint.ANTI_ALIAS_FLAG)

    private var colorBorders: Int = ContextCompat.getColor(context, android.R.color.black)
    private var colorBright: Int = ContextCompat.getColor(context, android.R.color.holo_orange_dark)
    private var colorBackground: Int = ContextCompat.getColor(context, android.R.color.white)

    private var currentPointsText: String = ""

    init {
        paintStroke.color = colorBackground
        paintStroke.style = Paint.Style.STROKE
        paintStroke.strokeWidth = 10f

        paintFill.color = colorBright
        paintFill.style = Paint.Style.FILL

        paintLine.color = colorBorders
        paintLine.style = Paint.Style.FILL_AND_STROKE
        paintLine.strokeWidth = 6f

        paintDigits.color = colorBorders
        paintDigits.style = Paint.Style.FILL
        paintDigits.strokeWidth = 22.0f
        paintDigits.textSize = 72.0f
    }

    override fun onSizeChanged(width: Int, height: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(width, height, oldw, oldh)

        val limit = Math.min(width, height)

        cx = width / 2f
        cy = height / 2f

        // максимальный радиус (из границ view)
        radiusExternal = limit / 2f

        // радиус диаграммы (без подписей)
        radiusPieChart = (radiusExternal / 4f) * 2f

        // границы прямоугольника для сегментов диаграммы
        pieChartRectF.set(
            cx - radiusPieChart, cy - radiusPieChart,
            cx + radiusPieChart, cy + radiusPieChart
        )

        // радиус начала линии-выноски
        radiusLineStart = (radiusPieChart / 10f) * 5

        // радиус завершения линии-выноски
        radiusLineEnd = (radiusPieChart / 10f) * 12

        // радиус размещения текстовой подписи
        radiusText = (radiusPieChart / 10f) * 15
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas ?: return

        // сумма баллов
        var totalPoints = 0f
        numbersList.forEach { totalPoints += it }

        // градусов на 1 балл (Infinity при делении на 0 до подсчёта)
        val degreesPerPoint: Float = 360 / totalPoints

        // рисуем сегменты диаграммы
        numbersList.forEach { currentPoints ->
            sweepAngle = currentPoints * degreesPerPoint
            paintFill.setARGB(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            canvas.drawArc(pieChartRectF, startAngle, sweepAngle, true, paintFill)
            canvas.drawArc(pieChartRectF, startAngle, sweepAngle, true, paintStroke)
            startAngle += sweepAngle
        }

        // рисуем линии-выноски c числами
        sweepAngle = 0f
        startAngle = 0f

        canvas.save()
        canvas.rotate(90f, cx, cy)

        numbersList.forEach { currentPoints ->
            sweepAngle = currentPoints * degreesPerPoint
            canvas.rotate(sweepAngle / 2, cx, cy)
            canvas.drawLine(cx, cy - radiusLineStart, cx, cy - radiusLineEnd, paintLine)

            // рисуем подписи
            canvas.rotate(-(sweepAngle / 2 + startAngle + 90), cx, cy - radiusText)
            currentPointsText = currentPoints.toString()
            paintDigits.getTextBounds(currentPointsText, 0, currentPointsText.length, textBoundRect)
            textWidth = paintDigits.measureText(currentPointsText)
            textHeight = textBoundRect.height()
            canvas.drawText(
                currentPointsText,
                cx - (textWidth / 2f),
                cy + (textHeight / 2f) - radiusText,
                paintDigits
            )
            canvas.rotate((sweepAngle / 2 + startAngle + 90), cx, cy - radiusText)
            canvas.rotate(sweepAngle / 2, cx, cy)
            startAngle += sweepAngle
        }
        canvas.restore()
    }

    fun setData(numbers: MutableList<Int>) {
        numbersList = numbers
    }
}