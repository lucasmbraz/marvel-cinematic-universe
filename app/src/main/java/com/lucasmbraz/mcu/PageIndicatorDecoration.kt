package com.lucasmbraz.mcu

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lucasmbraz.mcu.movies.MoviesAdapter

class PageIndicatorDecoration : RecyclerView.ItemDecoration() {

    private val itemStrokeWidth = 2.dp
    private val strokeColor = Color.WHITE
    private val imageWidth = 72.dp
    private val imageHeight = 96.dp
    private val padding = 16.dp
    private val itemWidth by lazy { imageWidth + padding * 2 }
    private val itemHeight by lazy { imageHeight + padding }
    private val paint = Paint()

    init {
        paint.apply {
            strokeWidth = itemStrokeWidth
            color = strokeColor
            style = Paint.Style.STROKE
            isAntiAlias = true
        }
    }

    override fun onDrawOver(canvas: Canvas, recyclerView: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(canvas, recyclerView, state)

        Log.d("Decoration", "itemWidth=$itemWidth, itemHeight=$itemHeight, imageWidth=$imageWidth, imageHeight=$imageHeight")

        val top = recyclerView.height - itemHeight - 72.dp

        val itemCount = recyclerView.adapter!!.itemCount

        if (itemCount == 0) {
            return
        }

        // Find active page
        val layoutManager = recyclerView.layoutManager as LinearLayoutManager
        val firstVisiblePosition = layoutManager.findFirstVisibleItemPosition()
        if (firstVisiblePosition == RecyclerView.NO_POSITION) {
            return
        }

        // find offset of active page (if the user is scrolling)
        val firstChild = layoutManager.findViewByPosition(firstVisiblePosition)!!
        val offset = firstChild.left.toFloat() / firstChild.width
        var left = recyclerView.left + (itemWidth * offset)
        Log.d("Animation", "firstChild.left=${firstChild.left}, firstChild.width=${firstChild.width} offset=$offset, left=$left")

        val movies = (recyclerView.adapter as MoviesAdapter).movies

        for (i in layoutManager.findFirstVisibleItemPosition() until itemCount) {
            val isFirst = i == layoutManager.findFirstVisibleItemPosition()
            val isLast = i == itemCount - 1
            val drawable = recyclerView.context.resources.getDrawable(movies[i].poster, null)
            drawItem(canvas, left, top, drawable, isFirst, isLast)
            left += itemWidth
        }
    }

    private fun drawItem(canvas: Canvas, itemLeft: Float, itemTop: Float, drawable: Drawable, isFirst: Boolean =false, isLast: Boolean =false) {
        val itemRight = itemLeft + itemWidth
        val itemBottom = itemTop + itemHeight

        Log.d("Decoration", "DrawItem at left=$itemLeft, right=$itemRight, top=$itemTop, bottom=$itemBottom")

        drawImage(canvas, itemLeft, itemTop, drawable)

        // draw bottom line
        drawLine(canvas, itemLeft, itemBottom, itemRight, isFirst, isLast)
    }

    private fun drawImage(canvas: Canvas, itemLeft: Float, itemTop: Float, drawable: Drawable) {
        val imageLeft = itemLeft + (itemWidth - imageWidth) / 2
        val imageRight = imageLeft + imageWidth
        val imageBottom = itemTop + imageHeight

        drawable.setBounds(imageLeft.toInt(), itemTop.toInt(), imageRight.toInt(), imageBottom.toInt())
        drawable.draw(canvas)

        Log.d("Decoration", "DrawImage at left=$imageLeft, right=$imageRight, top=$itemTop, bottom=$imageBottom")
    }

    private fun drawLine(canvas: Canvas, itemLeft: Float, itemBottom: Float, itemRight: Float, isFirst: Boolean = false, isLast: Boolean = false) {
        val center = itemLeft + itemWidth / 2
        val radius = 5.dp
        canvas.drawCircle(center, itemBottom, radius, paint)

        if (isFirst) {
            val fillPaint = Paint(paint)
            fillPaint.style = Paint.Style.FILL
            canvas.drawCircle(center, itemBottom, 3.dp, fillPaint)
        }

        val circleStart = center - radius
        val circleEnd = center + radius

        canvas.drawLine(itemLeft, itemBottom, circleStart, itemBottom, paint)
        if (!isLast) {
            canvas.drawLine(circleEnd, itemBottom, itemRight, itemBottom, paint)
        }
    }

}