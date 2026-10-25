package gonzalez.carlos.myapplication.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gonzalez.carlos.myapplication.ui.theme.DarkBrown

@Composable
fun CardOutfitDay(){
    Card(modifier=Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors= CardDefaults.cardColors(containerColor = DarkBrown)
    ) { }
}