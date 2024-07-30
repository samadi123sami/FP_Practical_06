import scala.io.StdIn.readLine

object StudentRecords {

  def validateInput(name: String, marks: String, totalMarks: String): (Boolean, Option[String]) = {
    if (name.isEmpty) {
      return (false, Some("Name cannot be empty."))
    }
    try {
      val marksInt = marks.toInt
      val totalMarksInt = totalMarks.toInt
      if (marksInt < 0 || totalMarksInt <= 0) {
        return (false, Some("Marks and total marks must be positive integers."))
      }
      if (marksInt > totalMarksInt) {
        return (false, Some("Marks cannot exceed total possible marks."))
      }
    } catch {
      case _: NumberFormatException => return (false, Some("Marks and total marks must be integers."))
    }
    (true, None)
  }

  def getStudentInfo(): (String, Int, Int, Double, Char) = {
    println("Enter student name:")
    val name = readLine()
    println("Enter marks obtained:")
    val marks = readLine()
    println("Enter total possible marks:")
    val totalMarks = readLine()

    val (isValid, errorMessage) = validateInput(name, marks, totalMarks)
    if (!isValid) {
      throw new IllegalArgumentException(errorMessage.getOrElse("Invalid input."))
    }

    val marksInt = marks.toInt
    val totalMarksInt = totalMarks.toInt
    val percentage = (marksInt.toDouble / totalMarksInt.toDouble) * 100

    val grade = percentage match {
      case p if p >= 90 => 'A'
      case p if p >= 75 => 'B'
      case p if p >= 50 => 'C'
      case _ => 'D'
    }

    (name, marksInt, totalMarksInt, percentage, grade)
  }

  def printStudentRecord(student: (String, Int, Int, Double, Char)): Unit = {
    val (name, marks, totalMarks, percentage, grade) = student
    println(s"Student Name: $name")
    println(s"Marks Obtained: $marks")
    println(s"Total Possible Marks: $totalMarks")
    println(f"Percentage: $percentage%.2f%%")
    println(s"Grade: $grade")
  }

  def getStudentInfoWithRetry(): (String, Int, Int, Double, Char) = {
    var validInput = false
    var studentInfo: (String, Int, Int, Double, Char) = null

    while (!validInput) {
      try {
        studentInfo = getStudentInfo()
        validInput = true
      } catch {
        case e: IllegalArgumentException =>
          println(e.getMessage)
          println("Please enter the details again.")
      }
    }

    studentInfo
  }

  def main(args: Array[String]): Unit = {
    val studentInfo = getStudentInfoWithRetry()
    printStudentRecord(studentInfo)
  }
}
