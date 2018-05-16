package movies


import java.util.ArrayList;
import java.util.List;
import scala.beans.BeanProperty

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
class Person {
    @Id
    @GeneratedValue
    @BeanProperty
    var id: java.lang.Long = _

    @BeanProperty
	var name: String = _

    @BeanProperty
    var born: Int = _

	@Relationship(`type` = "ACTED_IN")
    @BeanProperty
    var movies: ArrayList[Movie] = new ArrayList[Movie]()

	def this(name: String, born: Int) {
        this()
		this.name = name
		this.born = born
	}
}