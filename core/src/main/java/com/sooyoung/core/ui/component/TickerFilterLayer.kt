package com.sooyoung.core.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sooyoung.domain.ticker.policy.TickerFilterPolicy

@Composable
fun TickerFilterLayer(
    modifier: Modifier = Modifier,
    onClickFilter: (TickerFilterPolicy) -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth().padding(5.dp, end = 10.dp, top = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TickerFilterItem(modifier = Modifier.weight(1f), title = "가상자산명", filter = TickerFilterPolicy.CurrencyPair.Asc, onClickFilter = onClickFilter)
        TickerFilterItem(modifier = Modifier.weight(0.5f), title = "현재가", filter = TickerFilterPolicy.CurrencyPair.Desc, onClickFilter = onClickFilter)
        TickerFilterItem(modifier = Modifier.weight(0.5f), title = "24시간", filter = TickerFilterPolicy.CurrencyPair.Asc, onClickFilter = onClickFilter)
        TickerFilterItem(modifier = Modifier.weight(0.5f), title = "거래대금", filter = TickerFilterPolicy.CurrencyPair.Asc, onClickFilter = onClickFilter)
    }

}

@Composable
fun TickerFilterItem(
    modifier: Modifier = Modifier,
    title: String,
    filter: TickerFilterPolicy,
    onClickFilter: (TickerFilterPolicy) -> Unit,
) {
    Row(
        modifier.clickable { onClickFilter.invoke(filter) },
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title, fontSize = 12.sp)
        Diamond()
    }
}

@Composable
fun Diamond(
    modifier: Modifier = Modifier,
    size: Dp = 15.dp
) {
    Column(modifier = modifier.wrapContentSize()) {
        Triangle()
        Spacer(modifier = modifier.height(4.dp))
        InvertedTriangle()
    }

}

@Composable
fun Triangle(modifier: Modifier = Modifier, size: Dp = 10.dp, color: Color = Color.Black) {
    Canvas(modifier = modifier.size(size)) {
        val strokeWidth = 2.dp.toPx()

        val path = Path()
        path.moveTo(0f, size.toPx())
        path.lineTo(size.toPx() / 2, 0f)
        path.lineTo(size.toPx(), size.toPx())
        path.close()

        drawPath(
            path = path,
            color = color,
            style = Stroke(width = strokeWidth)
        )
    }
}

@Composable
fun InvertedTriangle(modifier: Modifier = Modifier, size: Dp = 10.dp, color: Color = Color.Black) {
    Canvas(modifier = modifier.size(size)) {
        val strokeWidth = 2.dp.toPx()

        val path = Path()
        path.moveTo(0f, 0f)
        path.lineTo(size.toPx() / 2, size.toPx())
        path.lineTo(size.toPx(), 0f)
        path.close()

        drawPath(
            path = path,
            color = color,
            style = Stroke(width = strokeWidth)
        )
    }
}