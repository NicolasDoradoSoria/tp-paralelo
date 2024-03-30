package shows.domain

class Entrada(val tipoDeAsiento: TipoDeAsiento, val cantidad: Int, val show: Show): Entity() {
    fun costoDiferencial () = tipoDeAsiento.costo() * cantidad

    fun precio() = show.costoTotal(this) * show.rentabilidad.rentabilidad

}