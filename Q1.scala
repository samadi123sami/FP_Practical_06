package prac06_22001816

object Q1 {

      def displayProduct(products: Map[Int, (String, Int, Double)]): Unit = {
        for ((productId, (name, quantity, price)) <- products) {
          println(s"Product ID: $productId, Name: $name, Quantity: $quantity, Price: $price")
        }
      }

      def main(args: Array[String]): Unit = {
        // Inventory 1
        val inventory1: Map[Int, (String, Int, Double)] = Map(
          101 -> ("book", 50, 25.0),
          102 -> ("pen", 45, 17.0),
          103 -> ("eraser", 30, 10.0)
        )

        //Inventory 1
        val inventory2: Map[Int, (String, Int, Double)] = Map(
          102 -> ("pen", 35, 20.0),
          104 -> ("pencil", 38, 12.0)
        )

        // I
        println("\nI.")
        println("Inventory 1:")
        displayProduct(inventory1)


        //II.
        println("\nII.")
        var total = inventory1.keys.size
        println("total products in inventory1 : " + total)


        //III.
        println("\nIII.")
        println(inventory1.isEmpty)

        // IV.
        println("\nIV.")
        val mergedInventory: Map[Int, (String, Int, Double)] = inventory1 ++ inventory2.map {
          case (id, (name, quantity, price)) =>
            inventory1.get(id) match {
              case Some((name1, quantity1, price1)) =>
                id -> (name1, quantity1 + quantity, price1 max price)
              case None =>
                id -> (name, quantity, price)
            }
        }

        println("Merged Inventory:")
        displayProduct(mergedInventory)

        // V.
        println("\nV.")
        val productIdToCheck = 102
        inventory1.get(productIdToCheck) match {
          case Some((name, quantity, price)) =>
            println(s"Product with ID $productIdToCheck exists in Inventory 1: Name: $name, Quantity: $quantity, Price: $price")
          case None =>
            println(s"Product with ID $productIdToCheck does not exist in Inventory 1.")
        }
      }
    }






















