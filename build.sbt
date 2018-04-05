lazy val commonSettings = Seq(
  version := "0.1",
  scalaVersion := "2.12.3",
  cancelable in Global := true,
 // fork in run := true
)

val xml = "org.scala-lang.modules" %% "scala-xml" % "1.1.0"

val neo4jOgmCore = "org.neo4j" % "neo4j-ogm-core" % "3.1.0"
val neo4jOgmApi = "org.neo4j" % "neo4j-ogm-api" % "3.1.0"
val neo4jOgmBoltDriver = "org.neo4j" % "neo4j-ogm-bolt-driver" % "3.1.0"

val slf4jLog4j12 = "org.slf4j" % "slf4j-log4j12" % "1.7.25"

val configTypesafe = "com.typesafe" % "config" % "1.3.2"

val fastClasspathScanner = "io.github.lukehutch" % "fast-classpath-scanner" % "2.18.1"

// spring
val springBootVersion = "2.0.0.RELEASE"
val springBoot = "org.springframework.boot" % "spring-boot" % springBootVersion
val springBootStarterDataNeo4j = "org.springframework.boot" % "spring-boot-starter-data-neo4j" % springBootVersion exclude("org.springframework.boot", "spring-boot-starter-logging")
val springBootStarterDataRest = "org.springframework.boot" % "spring-boot-starter-data-rest" % springBootVersion exclude("org.springframework.boot", "spring-boot-starter-logging")

// spring data neo4j
val springDataNeo4j = "org.springframework.data" % "spring-data-neo4j" % "5.0.5.RELEASE"
val springDataRestWebMvc = "org.springframework.data" % "spring-data-rest-webmvc" % "3.0.5.RELEASE"

val jacksonJsog = "com.voodoodyne.jackson.jsog" % "jackson-jsog" % "1.1"

lazy val root = (project in file("."))
  .settings(
    commonSettings,
    name := "snd-movies-scala",
    libraryDependencies ++= Seq(
      xml,
      neo4jOgmCore,
      neo4jOgmApi,
      neo4jOgmBoltDriver,
      slf4jLog4j12,
      configTypesafe,
      fastClasspathScanner,

      springBoot,
      springBootStarterDataNeo4j,
      springBootStarterDataRest,

      springDataNeo4j,
      springDataRestWebMvc,
      
      jacksonJsog
    )
  )