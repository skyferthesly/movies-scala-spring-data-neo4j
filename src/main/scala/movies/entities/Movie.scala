package movies

import java.lang.{Long, String}
import org.neo4j.ogm.annotation.{NodeEntity, Id, GeneratedValue, Property}
import com.voodoodyne.jackson.jsog.JSOGGenerator
import com.fasterxml.jackson.annotation.{JsonIdentityInfo, ObjectIdGenerators}
import org.neo4j.ogm.id.UuidStrategy

//@JsonIdentityInfo(generator=classOf[ObjectIdGenerators.PropertyGenerator], property="id")
@JsonIdentityInfo(generator = classOf[JSOGGenerator])
@NodeEntity
class Movie {
    var id: Long = _
    var title: String = _
    var released: Int = _
    var tagline: String = _

    def this(id: Long, title: String, released: Int, tagline: String) {
        this()
        this.id = id
        this.title = title
        this.released = released
        this.tagline = tagline
    }

    def toMap: Map[String, Any] = { 
        (Map[String, Any]() /: this.getClass.getDeclaredFields) {(a, f) =>
            f.setAccessible(true)
            a + (f.getName -> f.get(this))
        }
    }
}