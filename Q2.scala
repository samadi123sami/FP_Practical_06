package prac06_22001816

import scala.io.StdIn.readLine
object Q2 {

  def getstudentdatawithretry(): (String, Int, Int, Float, Char) = {
    println("Enter the name of the student:")
    val name = StdIn.readLine()

    println("Enter the possible marks:")
    val possiblemark = StdIn.readLine().toInt

    println("Enter your marks:")
    val mark = StdIn.readLine().toInt
    if (validate(name, possiblemark, mark)) {
      if (possiblemark >= mark) {
        val percentage = (mark.toFloat / possiblemark.toFloat) * 100
        val grade = {
          if (percentage >= 90) 'A'
          else if (percentage >= 75) 'B'
          else if (percentage >= 50) 'C'
          else 'D'
        }
        (name, possiblemark, mark, percentage, grade)
      } else {
        println("Invalid details provided.")
        getstudentinfo()
      }
    } else {
      println("Invalid input. Please enter valid details.")
      getstudentinfo()

    }
  }

  def getstudentinfo(): (String, Int, Int, Float, Char) = {
    println("Enter the name of the student:")
    val name = StdIn.readLine()

    println("Enter the possible marks:")
    val possiblemark = StdIn.readLine().toInt

    println("Enter your marks:")
    val mark = StdIn.readLine().toInt

    if (validate(name, possiblemark, mark)) {
      if (possiblemark >= mark) {
        val percentage = (mark.toFloat / possiblemark.toFloat) * 100
        val grade = {
          if (percentage >= 90) 'A'
          else if (percentage >= 75) 'B'
          else if (percentage >= 50) 'C'
          else 'D'
        }
        (name, possiblemark, mark, percentage, grade)
      } else {
        println("Invalid details provided.")
        getstudentdatawithretry()
      }
    } else {
      println("Invalid input. Please enter valid details.")
      getstudentdatawithretry()

    }
  }

  def printstudentrecord(students: List[(String, Int, Int, Float, Char)]): Unit = {
    students.foreach { case (name, possiblemark, mark, percentage, grade) =>
      println(s"Student Name: $name")
      println(s"Possible Marks: $possiblemark")
      println(s"Marks Obtained: $mark")
      println(f"Percentage: $percentage%.2f")
      println(s"Grade: $grade")
      println()
    }
  }

  def validate(name: String, possiblemark: Int, mark: Int): Boolean = {
    if (name.isEmpty) {
      println("Name cannot be empty.")
      false
    } else if (possiblemark <= 0) {
      println("Possible marks must be greater than zero.")
      false
    } else if (mark < 0) {
      println("Marks cannot be negative.")
      false
    } else {
      true
    }
  }

  def main(args: Array[String]): Unit = {
    println("Enter the number of students:")
    val numberofstudent = StdIn.readLine().toInt

    var studentrecord = List[(String, Int, Int, Float, Char)]()

    for (_ <- 0 until numberofstudent) {
      val studentinfo = getstudentinfo()
      studentrecord = studentrecord :+ studentinfo
    }

    printstudentrecord(studentrecord)
  }
}
