package movies

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.{Id, GeneratedValue, StartNode, EndNode, RelationshipEntity}

@RelationshipEntity(`type` = "ACTED_IN")
class Role {

    @Id
    @GeneratedValue
    var id: java.lang.Long = _
    var roles: ArrayList[String] = _

	@StartNode
    var person: Person = _

	@EndNode
    var movie: Movie = _

	def this(movie: Movie, actor: Person) {
        this()
		this.movie = movie;
		this.person = actor;
	}

    def addRoleName(name: String) = {
		if (this.roles == null) {
			this.roles = new ArrayList[String]()
		}
		this.roles.add(name)
	}
}