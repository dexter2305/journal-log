import bloop.config.Config
import javax.xml.bind.JAXBElement.GlobalScope
val ScalatraVersion = "2.7.0"

ThisBuild / scalaVersion := "2.13.6"
ThisBuild / organization := "io.l8"

Global / onChangedBuildSource := ReloadOnSourceChanges

scalacOptions ++= Seq(
  "-deprecation",
)

lazy val journalLogProject = (project in file("."))
  .settings(
    name    := "journal-log",
    version := "0.1.0",
    libraryDependencies ++= Seq(
      "org.scalatra"     %% "scalatra"           % ScalatraVersion,
      "org.scalatra"     %% "scalatra-json"      % ScalatraVersion,
      "org.json4s"       %% "json4s-jackson"     % "3.5.5",
      "org.scalatra"     %% "scalatra-scalatest" % ScalatraVersion    % Test,
      //"org.scalatra"     %% "scalatra-forms"     % ScalatraVersion,
      //"ch.qos.logback"    % "logback-classic"    % "1.2.3"            % Runtime,
      "com.outr"         %% "scribe-slf4j"       % "3.0.2"            % Compile,
      "org.eclipse.jetty" % "jetty-webapp"       % "9.4.35.v20201120" % "compile; container",
      "javax.servlet"     % "javax.servlet-api"  % "3.1.0"            % Provided,
    ),
  )
  .enablePlugins(SbtTwirl)
  .enablePlugins(JettyPlugin)
