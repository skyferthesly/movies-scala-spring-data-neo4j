package movies

import org.neo4j.ogm.annotation.{NodeEntity, Id, GeneratedValue}
import com.fasterxml.jackson.annotation.{JsonIdentityInfo, ObjectIdGenerators}
import org.neo4j.ogm.id.UuidStrategy

@JsonIdentityInfo(generator=classOf[ObjectIdGenerators.PropertyGenerator], property="id")
@NodeEntity
class Movie {
    @Id
    @GeneratedValue
    var id: java.lang.Long = _

    var title: String = _
    var released: Int = _
    var tagline: String = _

    def this(title: String, released: Int, tagline: String) {
        this()
        this.title = title
        this.released = released
        this.tagline = tagline
    }
}