import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun MainPage(model: VehicleViewModel) {
    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            shape = RoundedCornerShape(12.dp),
            backgroundColor = MaterialTheme.colors.background.copy(1f),
            border = BorderStroke(1.dp, MaterialTheme.colors.onSurface.copy(0.2f))
        ) {
            val vehicle by remember { model.selectedVehicle }
            vehicle?.let { VehicleInfo(it) }
        }
    }
}

@Composable
fun VehicleInfo(vehicle: VehicleViewModel.Vehicle) {

    val lineHeight = 12.dp
    Row(
        modifier = Modifier.padding(24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.widthIn(200.dp)
        ) {
            Text(
                text = vehicle.designation,
                fontWeight = FontWeight.Bold
            )
            S(lineHeight)
            Text(
                text = vehicle.model,
                fontWeight = FontWeight.Normal
            )
        }
        S(12.dp)
        Column(
        ) {
            with(vehicle) {
                Text(text = section)
                S(lineHeight)
                Text(text = fuelType.toString())
                S(lineHeight)
                Text(text = status.toString())
            }
        }
    }
}
