package cl.uchile.dcc.citric
package model.norma

class Norma5Test extends munit.FunSuite {
  private val level = 5
  private val starGoal = 120
  private val winGoal = 10

  var norma5: Norma = _
  var norma6: Norma = _

  override def beforeEach(context: BeforeEach): Unit = {
    norma5 = new Norma5()
    norma6 = new Norma6()
  }


  test("A Norma should have correctly set their attributes") {
    assertEquals(norma5.level, level)
    assertEquals(norma5.starGoal, starGoal)
    assertEquals(norma5.winGoal, winGoal)
  }

  test("A Norma increase should either return itself or return a norma of the next level") {
    assertEquals(norma5.increase(-1,-1), norma5)
    assert(norma5.increase(999,999).isInstanceOf[Norma6])
  }

}