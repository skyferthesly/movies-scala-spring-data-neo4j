package movies

import org.springframework.web.bind.annotation.{RequestMapping, RequestParam, RestController, GetMapping}

@RestController
class MovieController(val movieService: MovieService) 