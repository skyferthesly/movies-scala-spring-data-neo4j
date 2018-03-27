package movies

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel="movies", path="movies")
trait MovieRepository extends PagingAndSortingRepository[Movie, Long]