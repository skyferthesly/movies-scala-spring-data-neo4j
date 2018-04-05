package movies

import org.springframework.web.bind.annotation.{RequestMapping, RequestParam, RestController, RequestMethod, PathVariable}
import org.springframework.http.{ResponseEntity, HttpHeaders, HttpStatus}
import scala.collection.JavaConverters._

@RestController
@RequestMapping(Array("/movies/"))
class MovieController(val movieRepository: MovieRepository) {
    @RequestMapping(method = Array(RequestMethod.GET))
    def getAll = {
        var movies: Iterable[Movie] = movieRepository.findAll.asScala
        var all: Iterable[Map[String, Any]] = movies.map(m => m.toMap)
        new ResponseEntity[String](JsonConverter.toJson(all), new HttpHeaders, HttpStatus.OK)
    }

    @RequestMapping(value = Array("/{id}"), method = Array(RequestMethod.GET))
    def get(@PathVariable id: java.lang.Long) = {
        var movie: Movie = movieRepository.findById(id).get
        //ResponseEntity.ok(movie) // should work, but only returns an index, no object data
        new ResponseEntity[String](JsonConverter.toJson(movie.toMap), new HttpHeaders, HttpStatus.OK)
    }
}
