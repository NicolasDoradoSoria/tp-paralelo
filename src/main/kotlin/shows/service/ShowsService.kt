package shows.service

import org.springframework.stereotype.Service
import shows.domain.Show
import shows.repository.Repository
import shows.repository.ShowRepository

@Service
class ShowsService(val showsRepository: ShowRepository) {


    fun shows() = showsRepository.allInstances()

    fun searchShowsByBanda(show: Show)= showsRepository.search(show)

}