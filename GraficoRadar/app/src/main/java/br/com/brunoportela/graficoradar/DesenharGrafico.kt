package br.com.brunoportela.graficoradar

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import java.lang.Math.PI
import java.util.*
import java.util.concurrent.ScheduledExecutorService
import kotlin.concurrent.fixedRateTimer
import kotlin.math.absoluteValue
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin
import kotlin.concurrent.schedule

class DesenharGrafico: View {
    constructor(context: Context?) : super(context,null)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs,0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {

    }

    private var cursorAngle: Float = 0f

    public var angle: Float
        set(newAngle: Float) {
            cursorAngle = newAngle
            invalidate()
        }
        get() {
            return cursorAngle
        }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val radius = minOf(this.width/2,this.height).toFloat()
        val center = PointF(this.width.toFloat()/2,this.height.toFloat())

        drawCursor(center,radius,cursorAngle,canvas)
    }



    private fun drawCursor(center: PointF, radius: Float, angle: Float, canvas: Canvas, harm: Int = 8) {
        if (harm == 0) {return}

        var paint = Paint()
        paint.strokeWidth = 10f
        paint.color = Color.GREEN
        paint.alpha = 32 * harm - 1
        paint.style = Paint.Style.STROKE

        val angleCursor = PI + angle - ((8 - harm) * PI / 120).toFloat()
        val arcPoint = PointF(center.x + radius * cos(angleCursor).toFloat(), center.y - radius * sin(angleCursor).absoluteValue.toFloat())
        canvas.drawLine(center.x, center.y, arcPoint.x, arcPoint.y, paint)
        drawCursor(center, radius, angle, canvas, harm - 1)
    }

}