package $organization$.$project_name$

import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{Matchers, WordSpec}

class ServerSpec extends WordSpec with Matchers with ScalatestRouteTest {

  // we have to call the main method manually to ensure all fields are initialized (see scala.App extends DelayedInit).
  Server.main(null)

  "The cicero server" should {
    "return a message to signal the user that he maybe on the wrong path if he is not getting the evaluation path" in {
      Get() ~> Server.route ~> check {
        responseAs[String] shouldEqual "$project_name$"
      }
    }
  }

}
