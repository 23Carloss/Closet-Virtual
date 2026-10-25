package gonzalez.carlos.myapplication.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.Image
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gonzalez.carlos.myapplication.R
import gonzalez.carlos.myapplication.ui.theme.MyApplicationTheme
import gonzalez.carlos.myapplication.ui.theme.PlusJakartaSansFontFamily

@Composable
fun BarraAccesoRapido(
    selectedTab: Int = 0,
    onTabSelected: (Int) -> Unit = {}
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = colorResource(id = R.color.modoClaroBackground),
        shadowElevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val items = listOf(
                "Armario" to R.drawable.camiseta,
                "Outfits" to R.drawable.brillar,
                "Calendario" to R.drawable.calendar_days,
                "Ajustes" to R.drawable.engranaje
            )

            items.forEachIndexed { index, (label, imageResource) ->
                val isSelected = selectedTab == index
                val itemColor = colorResource(id = R.color.fontColor).let {
                    if (isSelected) it else it.copy(alpha = 0.72f)
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .clickable { onTabSelected(index) }
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                ) {
                    Image(
                        painter = painterResource(id = imageResource),
                        contentDescription = label,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = label,
                        fontFamily = PlusJakartaSansFontFamily,
                        fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                        fontSize = 11.sp,
                        color = itemColor
                    )
                }
            }
        }
    }
}
@Preview
@Composable
fun PreviewBarraAccesoRapido() {
    MyApplicationTheme {
        BarraAccesoRapido(selectedTab = 0)
    }
}
