package prac06_22001816

object Q1 {
  def main(args: Array[String]): Unit ={

    val inventory1: Map[Int,(String,Int,Double)] = Map(
      101->("book",50,25.0),
      102->("pen",45,17.0),
      103->("eraser",30,10.0)
    )

    var inventory2: Map[Int, (String, Int, Double)] = Map(
      102 -> ("pen", 35, 20.0),
      104 -> ("pencil", 38, 12.0)
    )

    //I.
    println("I.")
    println("Inventory 1:")
    inventory1.foreach {
      case (id, (name, quantity, price)) =>
        println(s"ID: $id, Name: $name, Quantity: $quantity, Price: $price")
    }
    //II.
    val totalValues = inventory1.values.map {
      case(_, quantity, price) => quantity * price
    }.sum
    println("\nII.")
    println(s"Total value of inventory1: $totalValues")

    //III.
    println("\nIII.")
    println(inventory1.isEmpty)

    //IV.
    println("\nIV.")
    val mergedInventory: Map[Int, (String, Int, Double)] = inventory2.foldLeft(inventory1) {
      case (acc, (id, (name, quantity, price))) =>
        acc.get(id) match {
          case Some((existingName, existingQuantity, existingPrice)) =>
            acc.updated(id, (existingName, existingQuantity + quantity, existingPrice max price))
          case None =>
            acc + (id -> (name, quantity, price))
        }
    }

    println("Merged Inventory:")
    mergedInventory.foreach {
      case (id, (name, quantity, price)) =>
        println(s"ID: $id, Name: $name, Quantity: $quantity, Price: $price")
    }

    //V.
    println("\nV.")
    val productId = 102
    inventory1.get(productId) match {
      case Some((name, quantity, price)) =>
        println(s"Product ID $productId details: Name=$name, Quantity=$quantity, Price=$price")
      case None =>
        println(s"Product ID $productId does not exist in inventory1")
    }
  }
}




















