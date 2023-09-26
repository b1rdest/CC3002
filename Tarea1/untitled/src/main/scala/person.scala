package person

class A(val x: Int){
  print("a")
  def this(x: String) = {
    this(x.toInt)
    print("c2")
  }
  def this() = {
    this("0")
    print("c3")
  }
  print("b")
}


object Main {
  def main(args: Array[String]): Unit  = {
    new A()
  }
}