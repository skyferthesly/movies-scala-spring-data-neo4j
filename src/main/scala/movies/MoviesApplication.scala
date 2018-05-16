package movies

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import javax.annotation.PostConstruct
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories

@SpringBootApplication
@EnableNeo4jRepositories(Array("movies"))
class MoviesApplication

object MoviesApplication {
   def main(args: Array[String]): Unit = SpringApplication.run(classOf[MoviesApplication])
 }