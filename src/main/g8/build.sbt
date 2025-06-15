val scala3Version = "$scalaVersion$"
val AkkaVersion   = "2.8.8"

lazy val $name$ = project
  .in(file("."))
  .settings(
    name := "$name$",
    version := "$version$",
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
      "org.scala-lang.modules" %% "scala-parallel-collections" % "1.2.0",
      "org.scala-lang.modules" %% "scala-parser-combinators"   % "2.4.0",
      "ch.qos.logback"          % "logback-classic"            % "1.5.18",
      "com.typesafe.akka"      %% "akka-actor-typed"           % AkkaVersion,
      "com.typesafe.akka"      %% "akka-stream"                % AkkaVersion,
      "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion % Test,
      "org.scalatest"     %% "scalatest"                % "3.2.19"    % Test
    ),
    assembly / assemblyJarName := "$name;format="lower"$-fatjar-$version$.jar",
    assembly / assemblyMergeStrategy := {
      case PathList("META-INF", xs @ _*) => MergeStrategy.discard
      case x => MergeStrategy.first
    },
    Test / testOptions += Tests.Argument(TestFrameworks.ScalaTest, "-P4"),
    semanticdbEnabled := true,
    semanticdbVersion := scalafixSemanticdb.revision,
  )

enablePlugins(JmhPlugin)
