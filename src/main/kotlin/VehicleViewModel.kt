import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

class VehicleViewModel() {

    data class Vehicle(
        val model: String,
        val designation: String,
        val fuelType: VehicleFuelType,
        val status: VehicleStatus,
        val section: String,
    )

    @Suppress("unused")
    enum class VehicleStatus { Geleast, Gekauft }

    @Suppress("unused")
    enum class VehicleFuelType { Benzin, Diesel, Elektrisch, Gas, Kohle }

    val selectedVehicle: MutableState<Vehicle?> =  mutableStateOf(null)

    fun getDummyVehicles(): List<Vehicle> = listOf(
        Vehicle(
            model = "VW T6 Transporter",
            designation = "Lieferwagen 1",
            fuelType = VehicleFuelType.Diesel,
            status = VehicleStatus.Geleast,
            section = "Lieferung",
        ),
        Vehicle(
            model = "VW T6 Transporter",
            designation = "Lieferwagen 2",
            fuelType = VehicleFuelType.Diesel,
            status = VehicleStatus.Geleast,
            section = "Lieferung",
        ),
    )
}