import scala.math.BigDecimal.double2bigDecimal

object Bucketise_q1 {
  def binary_search(n : Double , arr:Array[BigDecimal]): Int={
    if(n >= 100.05)
      return -1
    if(100.00<= n && n <= 100.049)
      return arr.length-1
    else {
      var low = 0
      var high = arr.length - 1
      while (low <= high) {
        var mid = low + (high - low) /2
        if (n >= arr(mid) && n < arr(mid + 1)) {
          return mid
        } else if (arr(mid) > n)
          high = mid - 1
        else
          low = mid + 1
      }
    }
    -1
  }

  def main(args: Array[String]): Unit = {
    var check = true
    val arr = (0d to 100d by 0.05d).toArray
    //    arr.foreach(i => print(s"$i ,"))
    while(check){
      val result = scala.io.StdIn.readLine("type -1 to exit or Write a Number : ").toDouble
      if(result == -1) check = false
      var x = binary_search(result,arr)
      if(x>0){
        println(s"Bucket for $result is: [${arr(x)} - ${arr(x)+0.049}]")
      }else println(s"There is no Bucket for $result")
    }
  }
}
