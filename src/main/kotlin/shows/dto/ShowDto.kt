package shows.dto

import shows.domain.Banda
import shows.domain.Instalacion
import shows.domain.Show

data class ShowDTO(
    var id: Int?,
    var nombreRecital: String,
    var img : String ,
    var banda: Banda,
    var instalacion: Instalacion,
    var fecha: String,
    var precioMinimo: Double,
    var precioMaximo: Double
)

fun Show.toDTO() = ShowDTO (
    this.id,
    this.nombreRecital,
    this.img,
    this.banda,
    this.instalacion,
    this.obtenerFechaFormateada(),
    this.precioMinimo(),
    this.precioMaximo()
)