import Dependencies._

lazy val commonSettings = Seq(
  scalaVersion := "2.12.10",
  organization := "com.danperes97",
  organizationName := "danperes97",
  scalacOptions ++= Seq(
    "-encoding",
    "utf8",
    "-deprecation",
    "-unchecked",
    "-language:higherKinds",
    "-language:existentials",
    "-Ypartial-unification",
    "-Yrangepos",
    "-feature"
  )
)

lazy val root = (project in file("."))
    .settings(
        commonSettings,
        name := "Dynamo4s",
    ).aggregate(core)

lazy val core = (project in file("core"))
  .settings(
    commonSettings,
    name := "Dynamo4s - Core",
    libraryDependencies ++= librariesCore,
    publishConfiguration := publishConfiguration.value.withOverwrite(true),
    publishLocalConfiguration := publishLocalConfiguration.value.withOverwrite(true),
  )

// Uncomment the following for publishing to Sonatype.
// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for more detail.

ThisBuild / description := "Some descripiton about your project."
ThisBuild / licenses    := List("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))
ThisBuild / homepage    := Some(url("https://github.com/danperes97/dynamo4s"))

lazy val bump = sys.env.getOrElse("BUMP", "minor")

developers in ThisBuild := List(
  Developer(
    id = "danperes97",
    name = "Danilo Ascencio Peres",
    email = "danilo.peres@hotmail.com",
    url = url("https://github.com/danperes97")
  )
)

publishArtifact in (Compile, packageDoc) := false

pomIncludeRepository in ThisBuild := { _ => false }
publishMavenStyle in ThisBuild := true

val versionBump = bump match {
  case "minor" => sbtrelease.Version.Bump.Minor
  case "major" => sbtrelease.Version.Bump.Major
  case "patch" => sbtrelease.Version.Bump.Bugfix
}

releaseVersionBump in ThisBuild := versionBump

overridePublishBothSettings
