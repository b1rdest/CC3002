package cl.uchile.dcc.citric
package model.norma

class Norma2Test extends munit.FunSuite {
  private val level = 2
  private val starGoal = 10
  private val winGoal = 1

  var norma2: Norma = _
  var norma3: Norma = _

  override def beforeEach(context: BeforeEach): Unit = {
    norma2 = new Norma2()
    norma3 = new Norma3()
  }


  test("A Norma should have correctly set their attributes") {
    assertEquals(norma2.level, level)
    assertEquals(norma2.starGoal, starGoal)
    assertEquals(norma2.winGoal, winGoal)
  }

  test("A Norma increase should either return itself or return a norma of the next level") {
    assertEquals(norma2.increase(-1,-1), norma2)
    assert(norma2.increase(999,999).isInstanceOf[Norma3])
  }

}