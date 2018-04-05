package movies

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import javax.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.rest.core.config.RepositoryRestConfiguration

@SpringBootApplication
class MoviesApplication(var configuration: RepositoryRestConfiguration) {
   @PostConstruct
   def config: Unit = configuration.exposeIdsFor(classOf[Movie])
}

@EntityScan(Array("movies"))
object MoviesApplication {
   def main(args: Array[String]): Unit = SpringApplication.run(classOf[MoviesApplication])
 }