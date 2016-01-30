name := "petStore"

version := "1.0"

scalaVersion := "2.11.7"

val akkaStreamVersion = "2.0.1"
val reactiveMongoVersion = "0.12.0-SNAPSHOT"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-stream-experimental" % akkaStreamVersion,
  "com.typesafe.akka" %% "akka-http-core-experimental" % akkaStreamVersion,
  "com.typesafe.akka" %% "akka-http-experimental" % akkaStreamVersion,
  "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaStreamVersion,
  "com.typesafe.akka" %% "akka-http-xml-experimental" % akkaStreamVersion,
  "com.typesafe.akka" %% "akka-http-testkit-experimental" % akkaStreamVersion,
  "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0",
  "ch.qos.logback" % "logback-classic" % "1.1.1",
  "org.reactivemongo" %% "reactivemongo" % reactiveMongoVersion,
  "org.reactivemongo" %% "reactivemongo-extensions-bson" % "0.11.7.play24",
  "com.github.cb372" %% "scalacache-ehcache" % "0.7.5",
  "com.github.simplyscala" %% "scalatest-embedmongo" % "0.2.3-SNAPSHOT" % "test",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)

parallelExecution in Test := false

dependencyOverrides += "org.reactivemongo" %% "reactivemongo" % reactiveMongoVersion
