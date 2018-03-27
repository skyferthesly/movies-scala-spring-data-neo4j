package movies

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan

@SpringBootApplication
class MoviesApplication

@EntityScan(Array("mapper"))
object MoviesApplication {
    def main(args: Array[String]): Unit = SpringApplication.run(classOf[MoviesApplication])
}