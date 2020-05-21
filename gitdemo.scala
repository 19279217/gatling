package main.scala

import java.util.concurrent.TimeUnit
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class getdemo extends Simulation {
  val httpConf = http.baseUrl("http://172.21.48.8")
  val scn = scenario("172.21.48.8 hello").during(60){
    exec(http("172.21.48.8_hello").get("/hello"))
  }

  setUp(scn.inject(rampUsers(40000) during(0 seconds)).protocols(httpConf))
 }