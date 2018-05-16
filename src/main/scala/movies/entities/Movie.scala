package movies

import java.util.ArrayList
import scala.beans.BeanProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.neo4j.ogm.annotation.{NodeEntity, Id, GeneratedValue, Property, Relationship}
import com.voodoodyne.jackson.jsog.JSOGGenerator


@NodeEntity
class Movie {
    @Id
    @GeneratedValue
    @BeanProperty
    var id: java.lang.Long = _

    @BeanProperty
    var title: String = _

    @BeanProperty
    var released: Int = _

    @BeanProperty
    var tagline: String = _

    @JsonIgnoreProperties(Array("movie"))
	@Relationship(`type` = "ACTED_IN", direction = Relationship.INCOMING)
    @BeanProperty
	var roles: ArrayList[Role] = _
    
    def this(title: String, released: Int, tagline: String) {
        this()
        this.title = title
        this.released = released
        this.tagline = tagline
    }

    def addRole(role: Role) = {
		if (this.roles == null) {
			this.roles = new ArrayList[Role]()
		}
		this.roles.add(role)
	}

    // def toMap: Map[String, Any] = { 
    //     (Map[String, Any]() /: this.getClass.getDeclaredFields) {(a, f) =>
    //         f.setAccessible(true)
    //         a + (f.getName -> f.get(this))
    //     }
    // }
}