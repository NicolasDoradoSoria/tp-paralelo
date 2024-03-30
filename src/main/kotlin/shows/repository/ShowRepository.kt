package shows.repository

import org.springframework.stereotype.Component
import shows.domain.Show

@Component
class ShowRepository: Repository<Show>() {

    fun search(item: Show): List<Show> = items.filter { it.banda.nombre.startsWith(item.banda.nombre, ignoreCase = true) }
}