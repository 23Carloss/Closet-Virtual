package gonzalez.carlos.myapplication.screens

import android.graphics.fonts.Font
import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gonzalez.carlos.myapplication.component.CalendarComponent
import gonzalez.carlos.myapplication.ui.theme.BackgroundCream
import gonzalez.carlos.myapplication.ui.theme.DarkBrown
import gonzalez.carlos.myapplication.ui.theme.MediumBrown
import gonzalez.carlos.myapplication.ui.theme.TextDark
import gonzalez.carlos.myapplication.ui.theme.TextLight
import gonzalez.carlos.myapplication.ui.theme.TextPlaceholder
import gonzalez.carlos.myapplication.ui.theme.buttonCalendar
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter

@Composable
fun CalendarScreen(){
    var selectedDate by remember{ mutableStateOf(LocalDate.now())}
    var currentMonth by remember { mutableStateOf(YearMonth.now())}
    val textColorMoth=Color.White
    val textColor= TextPlaceholder
    val backgroundColor= BackgroundCream
    val backgroundCalendar=DarkBrown

    Scaffold(bottomBar = {},
        containerColor =backgroundColor ) {
        paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)
            .fillMaxSize().padding(horizontal = 24.dp)
            .verticalScroll(rememberScrollState())){
            Row(modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically){
                //Boton de regreso
                // button
                Text("Calendario", fontSize=20.sp, fontWeight = FontWeight.SemiBold,
                    color = MediumBrown
                )
                Surface(shape = RoundedCornerShape(50),
                    border = BorderStroke(1.dp, Color.LightGray),
                    color= buttonCalendar,
                    onClick = {}
                ) {
                    Text("Hoy", modifier = Modifier.padding(horizontal = 12.dp,
                        vertical = 6.dp), fontSize = 12.sp)
                }
            }
            CalendarComponent(
                onChangeMonth = {month -> currentMonth = month},
                onDayClick = {date -> selectedDate = date}
            )
            Spacer(modifier= Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                val formatDate= DateTimeFormatter.ofPattern("EEEE, d 'de' MMMM",
                    java.util.Locale("es","ES"))
                Text(text= selectedDate.format(formatDate),
                    color = TextDark,
                    fontSize = 12.sp)
                // Para dar un ejemplo que tiene un outfit
                Text("1 Outfit", fontSize = 12.sp, color = MediumBrown)
            }
            Text("Outfit del Día", fontSize = 22.sp, fontWeight = FontWeight.Bold,
                color = MediumBrown, modifier = Modifier.padding(vertical = 16.dp))

            // Aqui vendria un componente de el outfit del dia
            Spacer(modifier= Modifier.height(32.dp))
        }
    }
}

@Preview
@Composable
fun PreviewCalendarScreen(){
    CalendarScreen()
}