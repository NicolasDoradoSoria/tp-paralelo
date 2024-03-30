package shows.domain

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Show : Entity() {

    var nombreRecital: String = ""
    var img : String = ""
    lateinit var banda: Banda
    lateinit var instalacion: Instalacion
    var fecha: LocalDate = LocalDate.now()
    var rentabilidad : Estado = Estado("precio Base", 0.8)
    private val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    fun costoBanda() = banda.costo_contratacion

    fun costoInstalacion() = instalacion.costo()

    fun costoFijo () : Int = (costoBanda() + costoInstalacion())  / instalacion.capacidadTotal()

    fun costoTotal(entrada: Entrada) = costoFijo() + entrada.costoDiferencial()

    fun obtenerFechaFormateada()= fecha.format(formatter)

    fun precioMinimo() = instalacion.costoAsientoMinimo() + costoFijo()
    fun precioMaximo() = instalacion.costoAsientoMaximo() + costoFijo()

}