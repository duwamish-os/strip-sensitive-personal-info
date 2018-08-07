import scala.sys.process.Process

lazy val commitSha = Process("git rev-parse --short HEAD").lineStream.head

version in ThisBuild ~= { vers =>
  s"$vers-$commitSha"
}

//lazy val appVersion = "1.0.0"
//
//def formatVersion(out: sbtdynver.GitDescribeOutput): String = {
//  val dirtySuffix = out.dirtySuffix.dropPlus.mkString("-", "").split("-").head
//  println("""-------""")
//  println(out.dirtySuffix)
//  println(out.isCleanAfterTag)
//  println(out.ref.dropV)
//  println(out.commitSuffix)
//  println("""-------""")
//  if (out.isCleanAfterTag) out.ref.dropV.value + dirtySuffix // no commit info if clean after tag
//  else appVersion + "-" + out.ref.dropV.value + dirtySuffix
//}
//
//def fallbackVersion(d: java.util.Date): String = s"HEAD-${sbtdynver.DynVer timestamp d}"
//
//inThisBuild(List(
//  version := dynverGitDescribeOutput.value.mkVersion(formatVersion, fallbackVersion(dynverCurrentDate.value)),
//  dynver := {
//    val date = new java.util.Date
//    sbtdynver.DynVer.getGitDescribeOutput(date).mkVersion(formatVersion, fallbackVersion(date))
//  }
//))