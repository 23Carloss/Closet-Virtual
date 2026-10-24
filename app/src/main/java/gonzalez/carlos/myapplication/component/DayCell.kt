package gonzalez.carlos.myapplication.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kizitonwose.calendar.core.CalendarDay
import com.kizitonwose.calendar.core.DayPosition
import gonzalez.carlos.myapplication.ui.theme.DarkBrown
import gonzalez.carlos.myapplication.ui.theme.MediumBrown
import gonzalez.carlos.myapplication.ui.theme.TextLight
import java.time.LocalDate

@Composable
fun DayCell(dia: CalendarDay, isSelected: Boolean,
            hasOutfit: Boolean, onClick:()-> Unit){
    val isCurrentMonth=dia.position == DayPosition.MonthDate
    val othersMonths= if(isCurrentMonth)1f else 0.3f
    Column(modifier = Modifier.fillMaxWidth().aspectRatio(1f).
    padding(2.dp).clickable{}, //onClick(dia)
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Box(modifier =
        Modifier.size(32.dp).clip(CircleShape).background(
            if(isSelected) TextLight else Color.Transparent),
            contentAlignment = Alignment.Center){
            Text(
                text = dia.date.dayOfMonth.toString(),
                color = if(isSelected) DarkBrown else Color.White.copy(alpha = othersMonths),
                fontSize = 14.sp
            )
        }
        if(hasOutfit && isCurrentMonth){
            Box(modifier = Modifier.padding(top=5.dp).
            size(4.dp).clip(CircleShape).background(MediumBrown))
        }else{
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Preview
@Composable
fun PreviewDayCell(){
    val dia= CalendarDay(LocalDate.now(), DayPosition.MonthDate)
    DayCell(dia,true,true,{})
}
