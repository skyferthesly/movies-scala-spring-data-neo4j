package movies

import org.neo4j.ogm.annotation.{NodeEntity, Id, GeneratedValue}
import com.fasterxml.jackson.annotation.{JsonIdentityInfo, ObjectIdGenerators}
import org.neo4j.ogm.id.UuidStrategy

@JsonIdentityInfo(generator=classOf[ObjectIdGenerators.PropertyGenerator], property="id")
@NodeEntity
class Movie {
    // @Id
    // @GeneratedValue
    // var id: java.lang.Long = _

    @Id
    @GeneratedValue(strategy = classOf[UuidStrategy])
    var id: String = _

    var title: String = _
}