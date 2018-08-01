name := "strip-sensitive-personal-info"

scalaVersion := "2.12.6"

libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.2.23"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test

publishTo := Some(Resolver.file("file", new File(Path.userHome.absolutePath + "/.m2/repository")))

import sbt.Keys.version
import sbtrelease.ReleasePlugin
import sbtrelease.ReleasePlugin.autoImport._
import sbtrelease.ReleaseStateTransformations._
import sbtrelease.Vcs

import scala.sys.process.Process

val commitSha = Process("git rev-parse --short HEAD").lineStream.head

releaseVersion := ((version: String) => s"v${version}-${commitSha}")

releaseTagName := s"v${version.value}-${commitSha}"
