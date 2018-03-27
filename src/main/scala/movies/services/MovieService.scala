package movies

import java.lang.Iterable
import org.springframework.stereotype.Service

@Service
class MovieService(val movieRepository: MovieRepository) {
    def listMovies(): Iterable[Movie] = movieRepository.findAll
    def getMovie(id: Long): java.util.Optional[Movie] =  movieRepository.findById(id)
}