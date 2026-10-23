package gonzalez.carlos.myapplication.component

import android.R.attr.onClick
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import gonzalez.carlos.myapplication.model.domain.Day
import gonzalez.carlos.myapplication.ui.theme.BackgroundCream
import gonzalez.carlos.myapplication.ui.theme.DarkBrown
import gonzalez.carlos.myapplication.ui.theme.LightBrownBorder
import gonzalez.carlos.myapplication.ui.theme.MediumBrown
import gonzalez.carlos.myapplication.ui.theme.TextLight
import gonzalez.carlos.myapplication.ui.theme.TextPlaceholder
import java.time.LocalDate

@Composable
fun DayCell(dia: Day, isSelected: Boolean, hasOutfit: Boolean, onClick:()-> Unit){
    // El primer parametro es CalendarDay pero no se como importarlo :c

    // Colores que se van a usar en el
    val textColorDays=Color.White
    val textColorSelected= DarkBrown
    val backgroundColorSelected= TextLight
    val backgroundCalendar=DarkBrown
    val ColorEvent= MediumBrown

    //dia.position
    // O podria ser una entidad de tipo dia
    val isCurrentMonth=dia.month == LocalDate.now().month
    val othersMonths= if(isCurrentMonth){} else 0.3f
    Column(modifier = Modifier.fillMaxWidth().aspectRatio(1f).
    padding(2.dp).clickable{}, //onClick(dia)
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Box(modifier =
        Modifier.size(32.dp).clip(CircleShape).background(
            if(isSelected) backgroundColorSelected else DarkBrown),
            contentAlignment = Alignment.Center){
            Text(
                text = ""+dia.dayOfMonth,
                color = if(isSelected) textColorSelected else textColorDays,
                fontSize = 14.sp
            )
        }
        if(hasOutfit && isCurrentMonth){
            Box(modifier = Modifier.padding(top=5.dp).size(4.dp).clip(CircleShape).background(ColorEvent))
        }else{
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Preview
@Composable
fun PreviewDayCell(){
    val dia= Day(1, LocalDate.now().month,true)
    DayCell(dia,true,true,{})
}
