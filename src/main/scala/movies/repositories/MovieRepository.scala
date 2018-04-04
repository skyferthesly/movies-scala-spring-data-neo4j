package movies

import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel="movies", path="movies")
trait MovieRepository extends Neo4jRepository[Movie, java.lang.Long]