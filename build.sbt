import Dependencies._

name := "kafka-streams-scala"
organization := "com.lightbend"
version := "0.3.2"
scalaVersion := Versions.Scala_2_12_Version
crossScalaVersions := Versions.CrossScalaVersions
scalacOptions := Seq("-Xexperimental", "-unchecked", "-deprecation", "-Ywarn-unused-import")
licenses := Seq("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))
developers := List(
  Developer("debasishg", "Debasish Ghosh", "@debasishg", url("https://github.com/debasishg")),
  Developer("blublinsky", "Boris Lublinsky", "@blublinsky", url("https://github.com/blublinsky")),
  Developer("maasg", "Gerard Maas", "@maasg", url("https://github.com/maasg"))
)
organizationName := "lightbend"
organizationHomepage := Option(url("http://lightbend.com/"))
homepage := scmInfo.value map (_.browseUrl)
scmInfo := Option(
  ScmInfo(url("https://github.com/lightbend/kafka-streams-scala"), "git@github.com:lightbend/kafka-streams-scala.git")
)

parallelExecution in Test := false
testFrameworks += new TestFramework("minitest.runner.Framework")

libraryDependencies ++= Seq(
  kafkaStreams excludeAll (ExclusionRule("org.slf4j", "slf4j-log4j12"), ExclusionRule("org.apache.zookeeper",
                                                                                      "zookeeper")),
  scalaLogging % "test",
  logback      % "test",
  kafka        % "test" excludeAll (ExclusionRule("org.slf4j", "slf4j-log4j12"), ExclusionRule("org.apache.zookeeper",
                                                                                        "zookeeper")),
  curator      % "test",
  minitest     % "test",
  minitestLaws % "test",
  algebird     % "test",
  chill        % "test",
  avro4s       % "test"
)

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
