package gonzalez.carlos.myapplication.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kizitonwose.calendar.compose.HorizontalCalendar
import com.kizitonwose.calendar.compose.rememberCalendarState
import com.kizitonwose.calendar.core.daysOfWeek
import gonzalez.carlos.myapplication.ui.theme.DarkBrown
import gonzalez.carlos.myapplication.ui.theme.TextPlaceholder
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth
import java.util.Locale

@Composable
fun CalendarComponent(modifier: Modifier= Modifier, onChangeMonth: (YearMonth) -> Unit={},
                      onDayClick:(LocalDate) -> Unit={}){
    // Estado del calendario
    val currentMonth= remember{YearMonth.now()}
    val startMonth= remember{currentMonth.minusMonths(100)}
    val endMonth= remember{currentMonth.plusMonths(100)}
    val daysWeek= remember {daysOfWeek(firstDayOfWeek = DayOfWeek.MONDAY)}
    val daySelect by remember {mutableStateOf(LocalDate.now())}
    // El estado del calendario
    val calendarState= rememberCalendarState(
        startMonth=startMonth,
        endMonth=endMonth,
        firstVisibleMonth=currentMonth,
        daysWeek.first()
    )
    val monthV= calendarState.firstVisibleMonth.yearMonth
    LaunchedEffect(monthV) {onChangeMonth(monthV) }
    //HorizontalCalendar(state = ca)
    Card(modifier=Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors= CardDefaults.cardColors(containerColor = DarkBrown)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text= monthV.month.getDisplayName(java.time.format.TextStyle.FULL,
                    Locale("es","ES")).replaceFirstChar{it.uppercase()},
                    // lo de arriba es para traducirlo en español
                    color= Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier= Modifier.width(8.dp))
                Text(text= monthV.year.toString(),
                    color=TextPlaceholder,
                    fontSize = 16.sp
                )
                //Los botones para cambiar el mes
                IconButton(onClick = {}) {
                    //Icon o la imagen del boton
                }
                IconButton(onClick = {}) {
                    //Icon o la imagen del boton
                }
            }
        }
        Spacer(modifier= Modifier.width(16.dp))
        Row(modifier=Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround) {
            daysWeek.forEach { day ->
                val formatDay= day.getDisplayName(
                    java.time.format.TextStyle.SHORT,
                    Locale("es","ES"))
                Text(
                    text = formatDay,
                    color= TextPlaceholder,
                    fontSize = 12.sp,
                    modifier = Modifier.weight(1f),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            }
        }
        HorizontalCalendar(
            state = calendarState,
            calendarScrollPaged = true,
            dayContent = { day ->
                val hasOutfit = day.date.dayOfMonth==19
                DayCell(
                    dia =day,
                    isSelected = day.date==daySelect,
                    hasOutfit = hasOutfit
                ) { }// el onclick de los dias en el calendario
            }
        )
        Spacer(modifier= Modifier.width(16.dp))
    }
}

@Preview
@Composable
fun PreviewCalendarComponent(){
    CalendarComponent(modifier = Modifier, onChangeMonth = {}, onDayClick = {})
}
