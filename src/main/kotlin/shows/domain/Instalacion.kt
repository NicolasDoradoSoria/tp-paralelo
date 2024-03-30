package shows.domain

abstract class Instalacion {
    var latitud: Int = 0
    var longitud: Int = 0
    val asientos = mutableSetOf<TipoDeAsiento>()

    abstract fun costo() : Int

    fun agregarTipoDeAsiento(asiento: TipoDeAsiento) { asientos.add(asiento)
    }

    fun capacidadTotal() : Int =
        if (!asientos.isEmpty()) {
            asientos.sumOf { it.capacidad() }
        }
    else{
        throw IllegalStateException("No hay asientos disponibles en la instalación")
        }



    fun costoAsientoMinimo() =
        if(asientos.isNotEmpty()) {
            asientos.minByOrNull { it.costo() }!!.costo() }
    else {
            throw IllegalStateException("No hay asientos disponibles en la instalación")
    }
    fun costoAsientoMaximo() =
        if(asientos.isNotEmpty()) {
            asientos.maxByOrNull { it.costo() }!!.costo() }
        else {
            throw IllegalStateException("No hay asientos disponibles en la instalación")
        }

}

class Estadio : Instalacion() {
    var nombre: String = ""
    var costoFIjo : Int = 0

    override fun costo() = costoFIjo


}

class Teatro: Instalacion() {
    var nombre: String = ""
    private val costoFIjo : Int = 100
    var tieneAcustica : Boolean = false

    override fun costo() = costoExtra() + costoFIjo

    fun costoExtra() =
        if(tieneAcustica){ 50 }
    else {0}
}