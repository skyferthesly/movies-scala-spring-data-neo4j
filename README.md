## Spring Data Neo4j Movies in Scala
This is a recreation of the [SDN Movies example](https://github.com/neo4j-examples/movies-java-spring-data-neo4j), Scala style.


#### Problems
When hitting `/movies/` you get the following stacktrace:
```
    018-03-27 15:33:23 WARN  DefaultHandlerExceptionResolver:442 - Failed to write HTTP message: org.springframework.http.converter.HttpMessageNotWritableException: Could not write JSON: Inval
    id Object Id definition for movies.Movie: cannot find property with name 'id'; nested exception is com.fasterxml.jackson.databind.JsonMappingException: Invalid Object Id definition for movi
    es.Movie: cannot find property with name 'id' (through reference chain: org.springframework.hateoas.PagedResources["_embedded"]->java.util.Collections$UnmodifiableMap["movies"]->java.util.ArrayList[0])
```

This is if the `id` field on `Movie.scala` is a `java.lang.Long`, as it should be. Some
interesting behavior happens when you change the `id` to a `String` and hitting `/movies/`:
```
    2018-03-27 15:48:48 ERROR RepositoryRestExceptionHandler:168 - Id must be assignable to Serializable!: null
    java.lang.IllegalArgumentException: Id must be assignable to Serializable!: null
            at org.springframework.util.Assert.instanceCheckFailed(Assert.java:637)
            at org.springframework.util.Assert.isInstanceOf(Assert.java:537)
            at org.springframework.data.rest.webmvc.support.RepositoryEntityLinks.linkToSingleResource(RepositoryEntityLinks.java:135)
            at org.springframework.data.rest.core.support.DefaultSelfLinkProvider.createSelfLinkFor(DefaultSelfLinkProvider.java:68)
            at org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler.getSelfLinkFor(PersistentEntityResourceAssembler.java:99)
            at org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler.wrap(PersistentEntityResourceAssembler.java:76)
            at org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler.toResource(PersistentEntityResourceAssembler.java:55)
            at org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler.toResource(PersistentEntityResourceAssembler.java:38)
            at org.springframework.data.web.PagedResourcesAssembler.createResource(PagedResourcesAssembler.java:208)
            at org.springframework.data.web.PagedResourcesAssembler.toResource(PagedResourcesAssembler.java:138)
            at org.springframework.data.rest.webmvc.AbstractRepositoryRestController.lambda$entitiesToResources$2(AbstractRepositoryRestController.java:94)
```