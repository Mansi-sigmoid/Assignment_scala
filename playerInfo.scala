class playerInfo(var year: Int, var playerName: String, var country: String, var matches: Int, var runs: Int, var wickets: Int) {}

object playerInfo {
  def Desc[T: Ordering] = implicitly[Ordering[T]].reverse;

  // insert player information into class object
  def push_into(year: Int, playerName: String, country: String, matches: Int, runs: Int, wickets: Int): playerInfo = {
    var playerInfo = new playerInfo(year, playerName, country, matches, runs, wickets);
    return playerInfo;
  }
  def main(args: Array[String]): Unit = {
    val bufferedSource = scala.io.Source.fromFile("/Users/mansigupta/Downloads/Scala_Assignment/src/main/scala.Sample-data.csv")
    var playerList = List(push_into(2020, "kabir", "India", 34, 299, 9))

    for (line <- bufferedSource.getLines) {
      val cols = line.split(",").map(_.trim)
      playerList = playerList :+ push_into(cols(0).toInt, cols(1), cols(2), cols(3).toInt, cols(4).toInt, cols(5).toInt)
    }
    println("Q1");
    var playerWithHighestRun = playerList.sortBy(x => x.runs).reverse
    println(playerWithHighestRun(0).playerName)

    println("Q2")
    for (player <- playerWithHighestRun.take(5)) {
      println(player.playerName)
    }

    println("Q3")
    var playerWithHighestWickets = playerList.sortBy(x => x.wickets).reverse
    for (player <- playerWithHighestWickets.take(5)) {
      println(player.playerName)
    }
    println("Q4")
    playerList = playerList.sortBy(x => x.wickets * 5).sortBy(x => x.runs * 0.05).reverse
    var cnt: Int = 1
    for (player <- playerList) {
      println(s"Rank $cnt --> " + player.playerName)
      cnt += 1;
    }
  }}
