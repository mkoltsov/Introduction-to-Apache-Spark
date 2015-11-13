val readme = sc.textFile("../README.md")
val changes = sc.textFile("../CHANGES.txt")

def filterize(rdd:org.apache.spark.rdd.RDD[String]):org.apache.spark.rdd.RDD[String] = {
	rdd.flatMap(_.split(" ")).filter(_.contains("Spark"))
}

def wc(rdd:org.apache.spark.rdd.RDD[String]):org.apache.spark.rdd.RDD[(String, Int)] = {
	rdd.map(x=> (x, 1)).reduceByKey((x,y) => x+y)
} 

val rF = wc(filterize(readme))
val rC = wc(filterize(changes))

println(rF.join(rC).collect())


