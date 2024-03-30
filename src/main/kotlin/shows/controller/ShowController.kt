package shows.controller

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import shows.domain.Banda
import shows.domain.Show
import shows.dto.ShowDTO
import shows.dto.toDTO
import shows.service.ShowsService

@RestController
@CrossOrigin("*")
class ShowController(val showsService: ShowsService) {

    @GetMapping("/shows")
    @Operation(summary = "devuelve todlas las tareas")
    fun shows(): List<ShowDTO> = showsService.shows().map { it.toDTO() }

    @GetMapping("/shows/search")
    @Operation(summary = "Buscar shows por nombre de banda")
    fun searchShowsByBanda(@RequestParam(name = "bandaNombre") bandaNombre: String): List<ShowDTO> {
        val show = Show().apply { banda = Banda().apply { nombre = bandaNombre }}
     return   showsService.searchShowsByBanda(show).map { it.toDTO() }
    }
}