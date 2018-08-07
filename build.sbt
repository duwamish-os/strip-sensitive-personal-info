name := "strip-sensitive-personal-info"

scalaVersion := "2.12.6"

dynverSonatypeSnapshots in ThisBuild := true

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % "7.2.23",
  "org.scalatest" %% "scalatest" % "3.0.5" % Test
)

isSnapshot in ThisBuild := false

publishTo := {
  println("====================")
  println(isSnapshot.value)
  println("====================")
  if (isSnapshot.value) {
    Some(Resolver.mavenLocal)
  }
  else {
    Some(Resolver.mavenLocal)
  }
}
