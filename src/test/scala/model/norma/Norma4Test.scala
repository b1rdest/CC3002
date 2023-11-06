package cl.uchile.dcc.citric
package model.norma

class Norma4Test extends munit.FunSuite {
  private val level = 4
  private val starGoal = 70
  private val winGoal = 6

  var norma4: Norma = _
  var norma5: Norma = _

  override def beforeEach(context: BeforeEach): Unit = {
    norma4 = new Norma4()
    norma5 = new Norma5()
  }


  test("A Norma should have correctly set their attributes") {
    assertEquals(norma4.level, level)
    assertEquals(norma4.starGoal, starGoal)
    assertEquals(norma4.winGoal, winGoal)
  }

  test("A Norma increase should either return itself or return a norma of the next level") {
    assertEquals(norma4.increase(-1,-1), norma4)
    assert(norma4.increase(999,999).isInstanceOf[Norma5])
  }

}