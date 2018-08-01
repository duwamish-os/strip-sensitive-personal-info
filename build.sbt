name := "strip-sensitive-personal-info"

scalaVersion := "2.12.6"

libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.2.23"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test

publishTo := Some(Resolver.file("file", new File(Path.userHome.absolutePath + "/.m2/repository")))

import sbt.Keys.version
import sbtrelease.ReleasePlugin.autoImport._
import sbtrelease.Version

import scala.sys.process.Process
import ReleaseTransformations._

val commitSha = Process("git rev-parse --short HEAD").lineStream.head

releaseVersion := ((version: String) => {
  val currentVersion = s"${version}-${commitSha}"
  println("===========")
  println(version)
  println(currentVersion)
  println("===========")
  currentVersion
})

import sbtrelease._

//releaseNextVersion := {
//  ver =>
//    val x = Version(ver).map(_.bump(releaseVersionBump.value).string.split("-").head).getOrElse(versionFormatError)
//    println("===========")
//    println("releaseNextVersion")
//    println(x)
//    println("releaseNextVersion")
//    println("===========")
//    x
//}

releaseTagName := s"v${version.value}"

releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  tagRelease,
  publishArtifacts,
  pushChanges
)
