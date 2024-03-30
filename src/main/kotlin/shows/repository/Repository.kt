package shows.repository

import org.springframework.stereotype.Component
import shows.domain.Entity

@Component
class Repository<T : Entity> {

    val items = mutableSetOf<T>()
    companion object {
        private var ultimoId = ID_INICIAL_REPOSITORY }
    fun allInstances(): Set<T> {
        return items
    }

    fun create(item: T) : T {
        item.id = ultimoId++;
        items.add(item)
        return item
    }

    fun clear() {
        items.clear()
    }

    fun clearInit() {
        clear()
        ultimoId = ID_INICIAL_REPOSITORY
    }

}