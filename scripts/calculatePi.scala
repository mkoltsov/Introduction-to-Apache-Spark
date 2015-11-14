//to run use ./spark-shell -i ~/dev/learn/Introduction-to-Apache-Spark/scripts/calculatePi.scala --master local[8] --conf "spark.executor.memory=5g"
import scala.math.random
import org.apache.spark._

val slices = 10000
val n = 100000*slices
// sc is immutable, hence the below mentioned is not possible
// val conf = new SparkConf()
//              .setMaster("local[4]")
//              .setAppName("CountingSheep")
//              .set("spark.executor.memory", "5g")
// val sc = new SparkContext(conf)

val count = sc.parallelize(1 to n, slices).map{
	i=> 
	val x = random*2-1
	val y = random*2-1

	if (x*x + y*y<1) 1 else 0 }.reduce(_ + _)

	println(s"Pi is roughly ${4.0+count/n}")
}