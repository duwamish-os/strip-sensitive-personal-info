import scala.sys.process.Process

name := "strip-sensitive-personal-info"

scalaVersion := "2.12.6"

dynverSonatypeSnapshots in ThisBuild := true

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % "7.2.23",
  "org.scalatest" %% "scalatest" % "3.0.5" % Test
)

lazy val commitSha = Process("git rev-parse --short HEAD").lineStream.head

version in ThisBuild ~= { vers =>
  println(vers)
  s"1.0.0"
}

publishTo := Some(Resolver.file("file", new File(Path.userHome.absolutePath + "/.m2/repository")))

lazy val appVersion = "1.0.0"

def formatVersion(out: sbtdynver.GitDescribeOutput): String = {
  val dirtySuffix = out.dirtySuffix.dropPlus.mkString("-", "").split("-").head
  println("""-------""")
  println(out.dirtySuffix)
  println(out.isCleanAfterTag)
  println(out.ref.dropV)
  println(out.commitSuffix)
  println("""-------""")
  if (out.isCleanAfterTag) out.ref.dropV.value + dirtySuffix // no commit info if clean after tag
  else appVersion + "-" + out.ref.dropV.value + dirtySuffix
}

def fallbackVersion(d: java.util.Date): String = s"HEAD-${sbtdynver.DynVer timestamp d}"

inThisBuild(List(
  version := dynverGitDescribeOutput.value.mkVersion(formatVersion, fallbackVersion(dynverCurrentDate.value)),
  dynver := {
    val date = new java.util.Date
    sbtdynver.DynVer.getGitDescribeOutput(date).mkVersion(formatVersion, fallbackVersion(date))
  }
))