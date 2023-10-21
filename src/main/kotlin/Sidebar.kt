import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*

@Composable
fun Sidebar(width: Dp, model: VehicleViewModel) {
    Card(
        modifier = Modifier
            .fillMaxHeight()
            .width(width),
        shape = RoundedCornerShape(12.dp),
        backgroundColor = MaterialTheme.colors.background.copy(1f),
        border = BorderStroke(1.dp, MaterialTheme.colors.onSurface.copy(0.2f))
    ) {
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Fahrzeuge",
                modifier = Modifier.padding(12.dp),
                color = MaterialTheme.colors.onSurface.copy(0.6f)
            )
            ListItemAdd()

            var selectedItemIndex by remember { mutableStateOf(0) }
            val vehicleList by remember { mutableStateOf(model.getDummyVehicles()) }

            LaunchedEffect(this) {
                model.selectedVehicle.value = vehicleList[selectedItemIndex]
            }

            VehicleList(
                vehicleList = vehicleList,
                selectedIndex = selectedItemIndex,
                onItemSelect = { newItemIndex, vehicle ->
                    selectedItemIndex = newItemIndex
                    model.selectedVehicle.value = vehicle
                }
            )
        }
    }
}

@Composable
fun VehicleList(
    vehicleList: List<VehicleViewModel.Vehicle>,
    selectedIndex: Int,
    onItemSelect: (Int, VehicleViewModel.Vehicle) -> Unit
) {
    vehicleList.forEachIndexed { index, it ->
        ListItemVehicle(
            vehicle = it,
            isSelected = selectedIndex == index,
            onClick = {
                onItemSelect(index, it)
            }
        )
    }
}

@Composable
fun ListItemVehicle(
    vehicle: VehicleViewModel.Vehicle,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().padding(0.dp),
        colors = ButtonDefaults.textButtonColors(),
        border = BorderStroke(1.dp, MaterialTheme.colors.onSurface.copy(0f)),
        shape = RectangleShape
    ) {
        Text(
            text = "${vehicle.designation}\n${vehicle.model}",
            textAlign = TextAlign.Center,
            lineHeight = 1.5.em,
            color = if (isSelected) MaterialTheme.colors.onSurface.copy(0.9f) else MaterialTheme.colors.onSurface,
            modifier = Modifier.padding(vertical = 6.dp)
        )
    }

}

@Composable
private fun ListItemAdd() {
    OutlinedButton(
        onClick = {},
        modifier = Modifier.fillMaxWidth().padding(0.dp),
        colors = ButtonDefaults.textButtonColors(

        ),
        border = BorderStroke(1.dp, MaterialTheme.colors.onSurface.copy(0f)),
        shape = RectangleShape
    ) {
        Icon(Icons.Default.Add, "", tint = MaterialTheme.colors.onSurface)
        S(12.dp)
        Text(
            text = "Neues Fahrzeug...",
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.padding(vertical = 6.dp)
        )
    }
}