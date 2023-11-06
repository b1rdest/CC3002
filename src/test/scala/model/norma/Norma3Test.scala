package cl.uchile.dcc.citric
package model.norma

class Norma3Test extends munit.FunSuite {
  private val level = 3
  private val starGoal = 30
  private val winGoal = 3

  var norma3: Norma = _
  var norma4: Norma = _

  override def beforeEach(context: BeforeEach): Unit = {
    norma3 = new Norma3()
    norma4 = new Norma4()
  }


  test("A Norma should have correctly set their attributes") {
    assertEquals(norma3.level, level)
    assertEquals(norma3.starGoal, starGoal)
    assertEquals(norma3.winGoal, winGoal)
  }

  test("A Norma increase should either return itself or return a norma of the next level") {
    assertEquals(norma3.increase(-1,-1), norma3)
    assert(norma3.increase(999,999).isInstanceOf[Norma4])
  }

}