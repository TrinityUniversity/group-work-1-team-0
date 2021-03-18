import org.scalatestplus.play._
import models._

class GroupWorkModelSpec extends PlaySpec {

    "GroupWorkModel" must {
        "do valid login for user" in {
            GroupWorkModel.validateUser("pabila") mustBe (true)
        }

        "regect login for invalid username" in {
          GroupWorkModel.validateUser("Mark") mustBe(false)
        }
    }
}