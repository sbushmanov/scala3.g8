val scala3Version = "$scalaVersion$"

lazy val $name$ = project
  .in(file("."))
  .settings(
    name                             := "$name$",
    version                          := "$version$",
    scalaVersion                     := scala3Version,
    libraryDependencies             ++= Seq(
      "org.typelevel"          %% "cats-core"                  % "2.13.0",
      "org.scala-lang.modules" %% "scala-parallel-collections" % "1.2.0",
      "org.scala-lang.modules" %% "scala-parser-combinators"   % "2.4.0",
      "org.scalatest"          %% "scalatest"                  % "3.2.19" % Test
    ),
    assembly / assemblyJarName := s"\${name.value}-fatjar-\${version.value}.jar",
    assembly / assemblyMergeStrategy := {
      case PathList("META-INF", xs @ _*) => MergeStrategy.discard
      case x                             => MergeStrategy.first
    },
    Test / testOptions += Tests.Argument(TestFrameworks.ScalaTest, "-P4"),
    semanticdbEnabled                := true,
    semanticdbVersion                := scalafixSemanticdb.revision
  )

scalacOptions ++= Seq(
  "-Wunused:imports", // Required for unused import detection in Scala 3
  "-Wunused:privates", // Optional: for unused private members
  "-Wunused:locals", // Optional: for unused local values
  "-Wunused:params", // Optional: for unused parameters
  "-Wunused:implicits" // Optional: for unused implicits
)

enablePlugins(JmhPlugin)
