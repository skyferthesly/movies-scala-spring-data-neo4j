package movies

import java.util.Optional
import org.springframework.web.bind.annotation.{RequestMapping, RequestParam, RestController, RequestMethod, PathVariable}
import org.springframework.http.{ResponseEntity, HttpHeaders, HttpStatus}
import scala.collection.JavaConverters._

@RestController
@RequestMapping(Array("/movies"))
class MovieController(val movieRepository: MovieRepository) {
    @RequestMapping(value = Array("/{id}"), method = Array(RequestMethod.GET))
    def get(@PathVariable id: java.lang.Long) = {
        movieRepository.findById(id).get
    }
}
