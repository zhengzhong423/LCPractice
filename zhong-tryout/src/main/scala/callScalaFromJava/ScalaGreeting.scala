package callScalaFromJava

class ScalaGreeting {
  def greet(args: Array[String]): String = {
    print("x: " + args(0) + "\n")
    print("y: " + args(1))
    return args(0) + "," + args(1)
  }
}