package movies

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import javax.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.rest.core.config.RepositoryRestConfiguration


@SpringBootApplication
class MoviesApplication {
    @Autowired
    var repo: MovieRepository = _
    var configuration: RepositoryRestConfiguration = _

    def this(config: RepositoryRestConfiguration) = {
        this()
        this.configuration = config
    }

    @PostConstruct
    def config: Unit = this.configuration.exposeIdsFor(classOf[Movie])
}

//@EntityScan(Array("movies"))
object MoviesApplication {
   def main(args: Array[String]): Unit = SpringApplication.run(classOf[MoviesApplication])
    
   

//     //@PostConstruct
//     //def thing: Unit = repo.save(new Movie("movie1", 1991, "lame af"))
    
 }