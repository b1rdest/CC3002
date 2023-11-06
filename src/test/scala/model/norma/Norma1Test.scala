package cl.uchile.dcc.citric
package model.norma

class Norma1Test extends munit.FunSuite {
  private val level = 1
  private val starGoal = 0
  private val winGoal = 0

  var norma: Norma = _
  var norma2: Norma = _

  override def beforeEach(context: BeforeEach): Unit = {
    norma = new Norma1()
    norma2 = new Norma2()
  }


  test("A Norma should have correctly set their attributes") {
    assertEquals(norma.level, level)
    assertEquals(norma.starGoal, starGoal)
    assertEquals(norma.winGoal, winGoal)
  }

  test("A Norma increase should either return itself or return a norma of the next level") {
    assertEquals(norma.increase(-1,-1), norma)
    assert(norma.increase(1,1).isInstanceOf[Norma2])
  }

}