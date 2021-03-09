addSbtPlugin("no.arktekk.sbt" % "aether-deploy" % "0.26.0")
addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.11")

libraryDependencies ++= Seq (
  "org.apache.httpcomponents" % "httpclient" % "4.5.13",
  "commons-codec" % "commons-codec" % "1.11",
  "commons-logging" % "commons-logging" % "1.2"
)
