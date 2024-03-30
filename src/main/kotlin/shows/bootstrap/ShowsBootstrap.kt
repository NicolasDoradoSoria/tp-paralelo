package shows.bootstrap

import org.springframework.beans.factory.InitializingBean
import org.springframework.stereotype.Service
import shows.domain.*
import shows.repository.Repository
import java.time.LocalDate

@Service
class ShowsBootstrap(
    val showsRepository: Repository<Show>,
    val bandaRepository: Repository<Banda>
) : InitializingBean {

    override fun afterPropertiesSet() {
        crearBandas()
        crearShows()
    }
    val banda1 = Banda().apply {
        nombre = "Banda 1"
        costo_contratacion = 50000 // Ejemplo de costo de contratación
    }
    val banda2 = Banda().apply {
        nombre = "Banda 2"
        costo_contratacion = 60000 // Ejemplo de costo de contratación
    }

    val palco = TipoDeAsiento("Palco", 300.0, 200)
    val platea = TipoDeAsiento("Platea", 500.0, 190)

    val fechaShow1 = LocalDate.of(2024, 3, 28)
    val fechaShow2 = LocalDate.of(2024, 5, 11)

    fun crearBandas() {
        bandaRepository.clearInit()
        // Crear instancias de bandas

        // Agregar las bandas creadas al repositorio de bandas
        bandaRepository.create(banda1)
        bandaRepository.create(banda2)
    }

    fun crearShows(){
        showsRepository.clearInit()

        // Crear instancias de instalaciones (estadios o teatros)
        val estadio1 = Estadio().apply {
            nombre = "Estadio 1"
            latitud = 12345
            longitud = 54321
            costoFIjo = 100000 // Ejemplo de costo fijo de un estadio
            agregarTipoDeAsiento(palco)
            agregarTipoDeAsiento(platea)
        }

        val teatro1 = Teatro().apply {
            nombre = "Teatro 1"
            latitud = 54321
            longitud = 12345
            agregarTipoDeAsiento(palco)
            agregarTipoDeAsiento(platea)
            // Puedes configurar otros atributos según sea necesario
        }
        // Crear instancias de shows y asociar bandas e instalaciones
        val show1 = Show().apply {
            nombreRecital = "Recital 1"
            banda = banda1
            img = "https://s3.abcstatics.com/abc/www/multimedia/cultura/2023/04/13/Metallica-R-ReoHPlfXn08hieR7JXNNOLK-1200x840@abc.jpeg"
            instalacion = estadio1
            fechaShow1

        }

        val show2 = Show().apply {
            nombreRecital = "Recital 2"
            banda = banda2
            img = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ1SL8DMmC4Ni4mphwuS584DNutHefvAj36KazfC3uCPw&s"
            instalacion = teatro1
            fechaShow2

        }
// Agregar los shows creados al repositorio
        showsRepository.create(show1)
        showsRepository.create(show2)

    }

}