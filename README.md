## Spring Data Neo4j Movies in Scala
This is a recreation of the [SDN Movies example](https://github.com/neo4j-examples/movies-java-spring-data-neo4j), Scala style.

Run via `sbt run`

#### Problems
Starting the Spring App and hitting `/movies/` gives the following stacktrace:
```
    018-03-27 15:33:23 WARN  DefaultHandlerExceptionResolver:442 - Failed to write HTTP message: org.springframework.http.converter.HttpMessageNotWritableException: Could not write JSON: Inval
    id Object Id definition for movies.Movie: cannot find property with name 'id'; nested exception is com.fasterxml.jackson.databind.JsonMappingException: Invalid Object Id definition for movi
    es.Movie: cannot find property with name 'id' (through reference chain: org.springframework.hateoas.PagedResources["_embedded"]->java.util.Collections$UnmodifiableMap["movies"]->java.util.ArrayList[0])
```
This is after exposing the Ids for `Movie` in the configuration.