import sbt._

object Dependencies {

  lazy val librariesCore = Seq(
    "io.opentracing" % "opentracing-api" % "0.31.0",
    "io.opentracing" % "opentracing-util" % "0.31.0",
    "com.datadoghq" % "dd-trace-api" % "0.27.0",
    "com.datadoghq" % "java-dogstatsd-client" % "2.8.1",

    "com.typesafe" % "config" % "1.3.4" % Optional,

    "com.typesafe.akka" %% "akka-http-core" % "10.1.10" % Optional,
    "com.typesafe.akka" %% "akka-http" % "10.1.10" % Optional,

    "io.circe" %% "circe-core" % "0.12.0" % Optional,
    "io.circe" %% "circe-generic" % "0.12.0" % Optional,
    "io.circe" %% "circe-generic-extras" % "0.12.0" % Optional,

    "org.scanamo" % "scanamo_2.12" % "1.0.0-M11" % Optional,
    "org.scanamo" % "scanamo-alpakka_2.12" % "1.0.0-M11" % Optional,

    "org.typelevel" %% "cats-core" % "2.0.0" % Optional
  ) ++ librariesTests

  lazy val librariesTests = Seq(
    "org.scalatest" %% "scalatest" % "3.0.8" % Test
  )
}
