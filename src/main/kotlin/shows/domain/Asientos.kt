package shows.domain

class TipoDeAsiento(val nombre: String,private val costo: Double,private  val capacidad: Int){
    fun costo() = costo
    fun capacidad() = capacidad
}

