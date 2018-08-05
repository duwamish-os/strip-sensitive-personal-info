name := "strip-sensitive-personal-info"

scalaVersion := "2.12.6"

dynverSonatypeSnapshots in ThisBuild := true

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % "7.2.23",
  "org.scalatest" %% "scalatest" % "3.0.5" % Test
)

lazy val version = "1.0.0"

//version in ThisBuild ~= (version => {
//  val vs = version.split("\\+")
//  vs.head
//})

publishTo := Some(Resolver.file("file", new File(Path.userHome.absolutePath + "/.m2/repository")))
